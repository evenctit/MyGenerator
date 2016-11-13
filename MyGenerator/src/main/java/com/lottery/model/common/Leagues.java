package com.lottery.model.common;

import com.lottery.model.BaseModel;

public class Leagues extends BaseModel{
	
	private String id;
	
	private String name;
	
	private String icon;
	
	private String seq;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public String getSeq() {
		return seq;
	}

	public void setSeq(String seq) {
		this.seq = seq;
	}
	
	

}
