package com.even.velocity.app;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.List;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;

import com.even.velocity.constants.VelocityConstant;
import com.even.velocity.dao.DbUtil;
import com.even.velocity.model.Table;
import com.even.velocity.util.StringUtil;

public class DaoGenerator implements Generator {

	@Override
	public void generate(Table table) {

		BufferedWriter writer = null;
		try {
			Velocity.init();

			VelocityContext context = new VelocityContext();
			String tableName = StringUtil.transformColumnName(table.getName());
			context.put("packageName", VelocityConstant.V_TEMPLATE_PKG_DAO);
			context.put("modelName", tableName);
			writer = new BufferedWriter(new OutputStreamWriter((new FileOutputStream("dao/" + tableName + "Repository.java"))));

			Template template = Velocity.getTemplate(VelocityConstant.V_TEMPLATE_DAO);

			template.merge(context, writer);

			writer.flush();
			
			System.out.println("Generate dao layer successful");

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(writer != null){
					writer.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

}
