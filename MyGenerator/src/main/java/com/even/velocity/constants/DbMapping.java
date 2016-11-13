package com.even.velocity.constants;

import java.util.HashMap;
import java.util.Map;

public class DbMapping {
	
	public final static Map<String,String> dbMapping = new HashMap<String,String>(){
		
	};
	
	static{
		dbMapping.put("INT", "int");
		dbMapping.put("VARCHAR", "String");
		dbMapping.put("DATETIME", "Date");
		dbMapping.put("FLOAT", "float");
	}

}
