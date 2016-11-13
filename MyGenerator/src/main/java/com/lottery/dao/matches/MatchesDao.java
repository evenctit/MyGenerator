package com.lottery.dao.matches;

import java.util.List;

import org.springframework.stereotype.Component;

import com.lottery.dao.BaseDAO;
import com.lottery.model.common.Leagues;
import com.lottery.model.common.Matches;

@Component
public class MatchesDao extends BaseDAO<Matches>{
	
	public List<Leagues> getLeagues(){
		 return sqlSessionTemplate.selectList(getSqlName("selectLeagues"), null);
	 }

}
