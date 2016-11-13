package com.even.velocity.model;


import java.io.Serializable;

/**
 * primary key should be ID
 * On
 * @author Even
 * @date 2016-03-12
 * int for mysql
 * 
 */
public interface Identifiable extends Serializable {
	/**
	 * 获取主键
	 * @author amen
	 * @return
	 * @date 2014年3月3日下午5:56:13
	 */
	public int getId();

	/**
	 * 设置ID属性
	 * @param id
	 */
	public void setId(int id);
}
