package com.lottery.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.lottery.dao.matches.MatchesDao;
import com.lottery.model.common.Leagues;


@Component
@Transactional
public class MatchService {
	
	 @Autowired
	private MatchesDao matchesDao;

	public MatchesDao getMatchesDao() {
		return matchesDao;
	}

	public void setMatchesDao(MatchesDao matchesDao) {
		this.matchesDao = matchesDao;
	}
	 
	 public List<Leagues> getLeagues(){
		 List<Leagues> result = null;
		 
		 
		 
		 return result;
	 }

}
