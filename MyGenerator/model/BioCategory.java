package com.mis.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class BioCategory implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id; 
    	@Column
private String wzmc;
    	@Column
private int flId;
    

	public int getId(){
        return id;
     }
     
      public void setId(int id){
        this.id = id;
     }
     

	public String getWzmc(){
        return wzmc;
     }
     
      public void setWzmc(String wzmc){
        this.wzmc = wzmc;
     }
     

	public int getFlId(){
        return flId;
     }
     
      public void setFlId(int flId){
        this.flId = flId;
     }
     


}