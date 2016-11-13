package com.even.velocity.model;

public class Column {
	
	private String originalName;

	private String colName;
	
	private String type;
	
	private String table;
	
	private String camelName;
//    private boolean             where;
//    private boolean             select;
//    private boolean             groupBy;
//    private boolean             having;
//    private boolean             join;

	

	public String getType() {
		return type;
	}

	public String getColName() {
		return colName;
	}

	public void setColName(String colName) {
		this.colName = colName;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getTable() {
		return table;
	}

	public void setTable(String table) {
		this.table = table;
	}

	public String getCamelName() {
		return camelName;
	}

	public void setCamelName(String camelName) {
		this.camelName = camelName;
	}

	public String getOriginalName() {
		return originalName;
	}

	public void setOriginalName(String originalName) {
		this.originalName = originalName;
	}
	
	

	
}
