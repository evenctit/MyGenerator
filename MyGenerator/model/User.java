package com.mis.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id; 
    	@Column
private String username;
    	@Column
private String password;
    	@Column
private String status;
    	@Column
private String desc;
    	@Column
private int teamId;
    

	public int getId(){
        return id;
     }
     
      public void setId(int id){
        this.id = id;
     }
     

	public String getUsername(){
        return username;
     }
     
      public void setUsername(String username){
        this.username = username;
     }
     

	public String getPassword(){
        return password;
     }
     
      public void setPassword(String password){
        this.password = password;
     }
     

	public String getStatus(){
        return status;
     }
     
      public void setStatus(String status){
        this.status = status;
     }
     

	public String getDesc(){
        return desc;
     }
     
      public void setDesc(String desc){
        this.desc = desc;
     }
     

	public int getTeamId(){
        return teamId;
     }
     
      public void setTeamId(int teamId){
        this.teamId = teamId;
     }
     


}