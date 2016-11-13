package com.mis.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class RoleUser implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id; 
    	@Column
private int userId;
    	@Column
private int roleId;
    

	public int getId(){
        return id;
     }
     
      public void setId(int id){
        this.id = id;
     }
     

	public int getUserId(){
        return userId;
     }
     
      public void setUserId(int userId){
        this.userId = userId;
     }
     

	public int getRoleId(){
        return roleId;
     }
     
      public void setRoleId(int roleId){
        this.roleId = roleId;
     }
     


}