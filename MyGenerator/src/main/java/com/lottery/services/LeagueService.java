package com.lottery.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.lottery.dao.matches.LeagueDao;
import com.lottery.model.common.Leagues;


@Component
@Transactional
public class LeagueService {
	
	 @Autowired
	private LeagueDao leagueDao;

	 
	 public List<Leagues> getLeagues(){
		 return leagueDao.getLeagues();
	 }

}
