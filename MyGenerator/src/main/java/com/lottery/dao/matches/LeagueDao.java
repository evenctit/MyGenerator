package com.lottery.dao.matches;

import java.util.List;

import org.springframework.stereotype.Component;

import com.lottery.dao.BaseDAO;
import com.lottery.model.common.Leagues;

@Component
public class LeagueDao extends BaseDAO<Leagues>{
	
	public List<Leagues> getLeagues(){
		 return sqlSessionTemplate.selectList(getSqlName("selectLeagues"), null);
	 }

}
