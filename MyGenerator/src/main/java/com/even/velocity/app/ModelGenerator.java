package com.even.velocity.app;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;

import com.even.velocity.constants.VelocityConstant;
import com.even.velocity.model.Table;
import com.even.velocity.util.StringUtil;

public class ModelGenerator implements Generator {

	@Override
	public void generate(Table table) {
		BufferedWriter writer = null;
		try {
			Velocity.init();

			VelocityContext context = new VelocityContext();
			String tableName = StringUtil.transformColumnName(table.getName());
			context.put("packageName", "com.mis.domain");
			context.put("modelName", tableName);
			context.put("allElems", table.getColumnList());
			writer = new BufferedWriter(new OutputStreamWriter((new FileOutputStream("model/" + tableName + ".java"))));

			Template template = Velocity.getTemplate(VelocityConstant.V_TEMPLATE_MODEL);

			template.merge(context, writer);

			writer.flush();
			
			writer = new BufferedWriter(new OutputStreamWriter((new FileOutputStream("model/" + tableName + "Vo.java"))));

			template = Velocity.getTemplate(VelocityConstant.V_TEMPLATE_MODEL_VO);

			template.merge(context, writer);

			writer.flush();
			
			writer = new BufferedWriter(new OutputStreamWriter((new FileOutputStream("model/" + tableName + "Query.java")),"utf8"));

			template = Velocity.getTemplate(VelocityConstant.V_TEMPLATE_MODEL_QUERY);
			template.setEncoding("utf8");

			template.merge(context, writer);

			writer.flush();
			
			System.out.println("Generate models successful");

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				writer.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

}
