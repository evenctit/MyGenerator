package com.mis.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Article implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id; 
    	@Column
private String subject;
    	@Column
private String content;
    	@Column
private $elem.type createDate;
    	@Column
private int createBy;
    	@Column
private $elem.type updateDate;
    	@Column
private int updateBy;
    	@Column
private int status;
    	@Column
private String author;
    	@Column
private $elem.type publishDate;
    	@Column
private String periodicals;
    	@Column
private String dataAnalyzeId;
    

	public int getId(){
        return id;
     }
     
      public void setId(int id){
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
     

	public $elem.type getCreateDate(){
        return createDate;
     }
     
      public void setCreateDate($elem.type createDate){
        this.createDate = createDate;
     }
     

	public int getCreateBy(){
        return createBy;
     }
     
      public void setCreateBy(int createBy){
        this.createBy = createBy;
     }
     

	public $elem.type getUpdateDate(){
        return updateDate;
     }
     
      public void setUpdateDate($elem.type updateDate){
        this.updateDate = updateDate;
     }
     

	public int getUpdateBy(){
        return updateBy;
     }
     
      public void setUpdateBy(int updateBy){
        this.updateBy = updateBy;
     }
     

	public int getStatus(){
        return status;
     }
     
      public void setStatus(int status){
        this.status = status;
     }
     

	public String getAuthor(){
        return author;
     }
     
      public void setAuthor(String author){
        this.author = author;
     }
     

	public $elem.type getPublishDate(){
        return publishDate;
     }
     
      public void setPublishDate($elem.type publishDate){
        this.publishDate = publishDate;
     }
     

	public String getPeriodicals(){
        return periodicals;
     }
     
      public void setPeriodicals(String periodicals){
        this.periodicals = periodicals;
     }
     

	public String getDataAnalyzeId(){
        return dataAnalyzeId;
     }
     
      public void setDataAnalyzeId(String dataAnalyzeId){
        this.dataAnalyzeId = dataAnalyzeId;
     }
     


}