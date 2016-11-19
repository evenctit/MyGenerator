package com.mis.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class BioSpecification implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id; 
    	@Column
private String basicInfo;
    	@Column
private String projectProgressBrifeDes;
    	@Column
private int bioCatId;
    	@Column
private String basicVideoDesPath;
    	@Column
private String projectProgressDetailDes;
    	@Column
private int databaseId;
    	@Column
private int relativeActicleId;
    

	public Integer getId(){
        return id;
     }
     
      public void setId(Integer id){
        this.id = id;
     }
    
     

		public String getBasicInfo(){
        return basicInfo;
     }
     
      public void setBasicInfo(String basicInfo){
        this.basicInfo = basicInfo;
     }
    
     

		public String getProjectProgressBrifeDes(){
        return projectProgressBrifeDes;
     }
     
      public void setProjectProgressBrifeDes(String projectProgressBrifeDes){
        this.projectProgressBrifeDes = projectProgressBrifeDes;
     }
    
     

		public int getBioCatId(){
        return bioCatId;
     }
     
      public void setBioCatId(int bioCatId){
        this.bioCatId = bioCatId;
     }
    
     

		public String getBasicVideoDesPath(){
        return basicVideoDesPath;
     }
     
      public void setBasicVideoDesPath(String basicVideoDesPath){
        this.basicVideoDesPath = basicVideoDesPath;
     }
    
     

		public String getProjectProgressDetailDes(){
        return projectProgressDetailDes;
     }
     
      public void setProjectProgressDetailDes(String projectProgressDetailDes){
        this.projectProgressDetailDes = projectProgressDetailDes;
     }
    
     

		public int getDatabaseId(){
        return databaseId;
     }
     
      public void setDatabaseId(int databaseId){
        this.databaseId = databaseId;
     }
    
     

		public int getRelativeActicleId(){
        return relativeActicleId;
     }
     
      public void setRelativeActicleId(int relativeActicleId){
        this.relativeActicleId = relativeActicleId;
     }
    
     


}