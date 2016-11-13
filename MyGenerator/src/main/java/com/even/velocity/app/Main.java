package com.even.velocity.app;

import java.util.List;

import com.even.velocity.dao.DbUtil;
import com.even.velocity.model.Table;

public class Main {

	public static void main(String[] args) {
		Main t = new Main();
		t.generateClasses();
	}

	private void generateClasses() {

		List<Table> list = DbUtil.getAllTables();
		Generator modelGenerator = new ModelGenerator();
		Generator controllerGenerator = new ControllerGenerator();
		Generator serviceGenerator = new ServiceGenerator();
		Generator daoGenerator = new DaoGenerator();
		Generator pageGenerator = new PageGenerator();
		for (Table table : list) {
			modelGenerator.generate(table);
			controllerGenerator.generate(table);
			serviceGenerator.generate(table);
			daoGenerator.generate(table);
			pageGenerator.generate(table);
			System.out.println("Generate " +  table.getName() + " domain successful");
		}
	}

}
