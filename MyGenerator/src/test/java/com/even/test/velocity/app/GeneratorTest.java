package com.even.test.velocity.app;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.even.velocity.app.ControllerGenerator;
import com.even.velocity.app.DaoGenerator;
import com.even.velocity.app.Generator;
import com.even.velocity.app.ModelGenerator;
import com.even.velocity.app.ServiceGenerator;
import com.even.velocity.model.Column;
import com.even.velocity.model.Table;

public class GeneratorTest {

	
	@Test
	public void testModelGenerator(){
		Generator gen = new ModelGenerator();
		gen.generate(getTable());
		
	}
		
	@Test
	public void testDaoGenerator(){
		Generator gen = new DaoGenerator();
		gen.generate(getTable());
		
	}
	
	@Test
	public void testServiceGenerator(){
		Generator gen = new ServiceGenerator();
		gen.generate(getTable());
	}
	
	@Test
	public void testControllerGenerator(){
		Generator gen = new ControllerGenerator();
		gen.generate(getTable());
	}
	
	private Table getTable(){
		Table table = new Table();
		table.setName("matches_result");
		List<Column> list = new ArrayList<Column>();
		Column col1 = new Column();
		col1.setOriginalName("id");
		col1.setCamelName("id");
		col1.setColName("Id");
		col1.setType("int");
		list.add(col1);
		
		Column col2 = new Column();
		col2.setOriginalName("match_referencd_id");
		col2.setCamelName("matchReferencdId");
		col2.setColName("MatchReferencdId");
		col2.setType("String");
		list.add(col2);
		
		table.setColumnList(list);
		
		return table;
	}

}
