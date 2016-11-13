package com.mis.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Team implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id; 
    	@Column
private String desc;
    	@Column
private String direction;
    	@Column
private String subjects;
    	@Column
private String articles;
    

	public int getId(){
        return id;
     }
     
      public void setId(int id){
        this.id = id;
     }
     

	public String getDesc(){
        return desc;
     }
     
      public void setDesc(String desc){
        this.desc = desc;
     }
     

	public String getDirection(){
        return direction;
     }
     
      public void setDirection(String direction){
        this.direction = direction;
     }
     

	public String getSubjects(){
        return subjects;
     }
     
      public void setSubjects(String subjects){
        this.subjects = subjects;
     }
     

	public String getArticles(){
        return articles;
     }
     
      public void setArticles(String articles){
        this.articles = articles;
     }
     


}