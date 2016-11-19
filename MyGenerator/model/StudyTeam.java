package com.mis.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class StudyTeam implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id; 
    	@Column
private String desc;
    	@Column
private String studyDirection;
    	@Column
private String subjectsTask;
    	@Column
private String relativeArticles;
    	@Column
private int type;
    	@Column
private String teamGroupName;
    

	public Integer getId(){
        return id;
     }
     
      public void setId(Integer id){
        this.id = id;
     }
    
     

		public String getDesc(){
        return desc;
     }
     
      public void setDesc(String desc){
        this.desc = desc;
     }
    
     

		public String getStudyDirection(){
        return studyDirection;
     }
     
      public void setStudyDirection(String studyDirection){
        this.studyDirection = studyDirection;
     }
    
     

		public String getSubjectsTask(){
        return subjectsTask;
     }
     
      public void setSubjectsTask(String subjectsTask){
        this.subjectsTask = subjectsTask;
     }
    
     

		public String getRelativeArticles(){
        return relativeArticles;
     }
     
      public void setRelativeArticles(String relativeArticles){
        this.relativeArticles = relativeArticles;
     }
    
     

		public int getType(){
        return type;
     }
     
      public void setType(int type){
        this.type = type;
     }
    
     

		public String getTeamGroupName(){
        return teamGroupName;
     }
     
      public void setTeamGroupName(String teamGroupName){
        this.teamGroupName = teamGroupName;
     }
    
     


}