package com.mis.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class News implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id; 
    	@Column
private String subject;
    	@Column
private String content;
    	@Column
private String status;
    	@Column
private $elem.type createDate;
    	@Column
private $elem.type updateDate;
    	@Column
private int createBy;
    	@Column
private $elem.type publishDate;
    	@Column
private int acticalId;
    	@Column
private String acticalLink;
    	@Column
private String acticalAuthor;
    

	public Integer getId(){
        return id;
     }
     
      public void setId(Integer id){
        this.id = id;
     }
    
     

		public String getSubject(){
        return subject;
     }
     
      public void setSubject(String subject){
        this.subject = subject;
     }
    
     

		public String getContent(){
        return content;
     }
     
      public void setContent(String content){
        this.content = content;
     }
    
     

		public String getStatus(){
        return status;
     }
     
      public void setStatus(String status){
        this.status = status;
     }
    
     

		public $elem.type getCreateDate(){
        return createDate;
     }
     
      public void setCreateDate($elem.type createDate){
        this.createDate = createDate;
     }
    
     

		public $elem.type getUpdateDate(){
        return updateDate;
     }
     
      public void setUpdateDate($elem.type updateDate){
        this.updateDate = updateDate;
     }
    
     

		public int getCreateBy(){
        return createBy;
     }
     
      public void setCreateBy(int createBy){
        this.createBy = createBy;
     }
    
     

		public $elem.type getPublishDate(){
        return publishDate;
     }
     
      public void setPublishDate($elem.type publishDate){
        this.publishDate = publishDate;
     }
    
     

		public int getActicalId(){
        return acticalId;
     }
     
      public void setActicalId(int acticalId){
        this.acticalId = acticalId;
     }
    
     

		public String getActicalLink(){
        return acticalLink;
     }
     
      public void setActicalLink(String acticalLink){
        this.acticalLink = acticalLink;
     }
    
     

		public String getActicalAuthor(){
        return acticalAuthor;
     }
     
      public void setActicalAuthor(String acticalAuthor){
        this.acticalAuthor = acticalAuthor;
     }
    
     


}