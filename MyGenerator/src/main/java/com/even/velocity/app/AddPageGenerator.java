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

public class AddPageGenerator implements Generator {

	
	@Override
	public void generate(Table table) {
		BufferedWriter writer = null;
		try {
			Velocity.init();

			VelocityContext context = new VelocityContext();
			String tableName = StringUtil.transformColumnName(table.getName());
			String camelTableName = StringUtil.transformToCamelName(table.getName());
			context.put("tableName", table.getName());
			context.put("modelName", tableName);
			context.put("camelModelName", camelTableName);
			context.put("allElems", table.getColumnList());
			
			writer = new BufferedWriter(new OutputStreamWriter((new FileOutputStream("pages/" + camelTableName + "_add.html"))));

			Template addtemplate = Velocity.getTemplate(VelocityConstant.V_TEMPLATE_ADD_PAGE);

			addtemplate.merge(context, writer);

			writer.flush();
			
			System.out.println("Generate add pages successful");
			
			writer = new BufferedWriter(new OutputStreamWriter((new FileOutputStream("pages/" + camelTableName + "_list.html"))));

			Template listtemplate = Velocity.getTemplate(VelocityConstant.V_TEMPLATE_LIST_PAGE);

			listtemplate.merge(context, writer);

			writer.flush();
			
			System.out.println("Generate list pages successful");
			
			writer = new BufferedWriter(new OutputStreamWriter((new FileOutputStream("js/" + camelTableName + "_ctrl.js"))));

			Template jsTemplate = Velocity.getTemplate(VelocityConstant.V_TEMPLATE_JS_PAGE);

			jsTemplate.merge(context, writer);

			writer.flush();
			
			System.out.println("Generate pages successful");
			
			

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
