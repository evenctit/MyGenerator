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

public class ControllerGenerator implements Generator {

	
	@Override
	public void generate(Table table) {
		BufferedWriter writer = null;
		try {
			Velocity.init();

			VelocityContext context = new VelocityContext();
			String tableName = StringUtil.transformColumnName(table.getName());
			String camelTableName = StringUtil.transformToCamelName(table.getName());
			context.put("packageName", VelocityConstant.V_TEMPLATE_PKG_CONTROLLER);
			context.put("modelName", tableName);
			context.put("camelModelName", camelTableName);
			context.put("allElems", table.getColumnList());
			writer = new BufferedWriter(new OutputStreamWriter((new FileOutputStream("controller/" + tableName + "Controller.java"))));

			Template template = Velocity.getTemplate(VelocityConstant.V_TEMPLATE_CONTROLLER);

			template.merge(context, writer);

			writer.flush();
			
			System.out.println("Generate controllers successful");

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
