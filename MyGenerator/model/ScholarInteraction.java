package com.mis.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ScholarInteraction implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id; 
    	@Column
private $elem.type scholarDate;
    	@Column
private String scholarName;
    	@Column
private String scholarContent;
    	@Column
private int createBy;
    

	public Integer getId(){
        return id;
     }
     
      public void setId(Integer id){
        this.id = id;
     }
    
     

		public $elem.type getScholarDate(){
        return scholarDate;
     }
     
      public void setScholarDate($elem.type scholarDate){
        this.scholarDate = scholarDate;
     }
    
     

		public String getScholarName(){
        return scholarName;
     }
     
      public void setScholarName(String scholarName){
        this.scholarName = scholarName;
     }
    
     

		public String getScholarContent(){
        return scholarContent;
     }
     
      public void setScholarContent(String scholarContent){
        this.scholarContent = scholarContent;
     }
    
     

		public int getCreateBy(){
        return createBy;
     }
     
      public void setCreateBy(int createBy){
        this.createBy = createBy;
     }
    
     


}