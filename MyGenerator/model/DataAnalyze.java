package com.mis.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class DataAnalyze implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id; 
    	@Column
private int dataAnalyzeCatId;
    	@Column
private String dataAnalyzeTitle;
    	@Column
private String dataAnalyzeLink;
    

	public Integer getId(){
        return id;
     }
     
      public void setId(Integer id){
        this.id = id;
     }
    
     

		public int getDataAnalyzeCatId(){
        return dataAnalyzeCatId;
     }
     
      public void setDataAnalyzeCatId(int dataAnalyzeCatId){
        this.dataAnalyzeCatId = dataAnalyzeCatId;
     }
    
     

		public String getDataAnalyzeTitle(){
        return dataAnalyzeTitle;
     }
     
      public void setDataAnalyzeTitle(String dataAnalyzeTitle){
        this.dataAnalyzeTitle = dataAnalyzeTitle;
     }
    
     

		public String getDataAnalyzeLink(){
        return dataAnalyzeLink;
     }
     
      public void setDataAnalyzeLink(String dataAnalyzeLink){
        this.dataAnalyzeLink = dataAnalyzeLink;
     }
    
     


}