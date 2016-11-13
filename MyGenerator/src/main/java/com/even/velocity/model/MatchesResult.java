package com.even.velocity.model;

import java.util.Date;

public class MatchesResult extends BaseModel implements Identifiable {

    private int id;
    
    private String matchReferenceId;
    
    private String matchOptions;
    
    private float matchOdds;
    


	public int getId(){
        return id;
     }
     
      public void setId(int id){
        this.id = id;
     }
     

	public String getMatchReferenceId(){
        return matchReferenceId;
     }
     
      public void setMatchReferenceId(String matchReferenceId){
        this.matchReferenceId = matchReferenceId;
     }
     

	public String getMatchOptions(){
        return matchOptions;
     }
     
      public void setMatchOptions(String matchOptions){
        this.matchOptions = matchOptions;
     }
     

	public float getMatchOdds(){
        return matchOdds;
     }
     
      public void setMatchOdds(float matchOdds){
        this.matchOdds = matchOdds;
     }
     


}