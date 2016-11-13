package com.even.velocity.model;

import java.util.Date;

public class Leagues extends BaseModel implements Identifiable {

    private int id;
    
    private String name;
    
    private String icon;
    
    private int seq;
    


	public int getId(){
        return id;
     }
     
      public void setId(int id){
        this.id = id;
     }
     

	public String getName(){
        return name;
     }
     
      public void setName(String name){
        this.name = name;
     }
     

	public String getIcon(){
        return icon;
     }
     
      public void setIcon(String icon){
        this.icon = icon;
     }
     

	public int getSeq(){
        return seq;
     }
     
      public void setSeq(int seq){
        this.seq = seq;
     }
     


}