package com.even.velocity.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.even.velocity.common.service.impl.BaseManager;
import com.even.velocity.dao.BaseDAO;
import com.even.velocity.dao.MatchesResultDao;
import com.even.velocity.model.MatchesResult;
import com.even.velocity.model.MatchesResultQuery;
import com.even.velocity.model.MatchesResultVo;
import com.even.velocity.model.bean.Pages;
import com.even.velocity.model.bean.SuccessMsg;

@Component
@Transactional
public class MatchesResultService extends BaseManager<MatchesResult> {

	@Autowired
	private MatchesResultDao matchesResultDao;
	
	@Override
  	protected BaseDAO<MatchesResult> getBaseDAO() {
    	return matchesResultDao;
    }

	public SuccessMsg add(MatchesResult matchesResult){
	    try{
	    	// matchesResult.setId(generalTableKey());
	    	this.insert(matchesResult);
	    	return SuccessMsg.msg("Create a new record successful");
	    }catch (Exception e){
			return SuccessMsg.msg(false, "Fail to create a new record!");
	    }
    }
    
    public List<MatchesResult> getAll( MatchesResultQuery queryVo) throws Exception {
		List<MatchesResult> matchesResult = null;
		try {
			matchesResult = this.queryList(queryVo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return matchesResult;
	}
	
	public Pages list( MatchesResultQuery queryVo) throws Exception {
		Pages pages = new Pages();
		try {
			Long pageCount = Long.parseLong(String.valueOf(this.queryCount(queryVo))); // total number of records
			List<MatchesResult> matchesResult = this.queryList(queryVo);
			
			pages.setPageSize(queryVo.getPageSize());
			pages.setPage(queryVo.getPage() == null || queryVo.getPage() < 0 ? 0 : queryVo.getPage());// current page
			pages.setRecords(pageCount.intValue());// total number of pages
			pages.setRows(matchesResult); // page data
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return pages;
	}
	
	 public SuccessMsg delete(String id){
		if(this.deleteById(id)>0){
			return SuccessMsg.msg("delete successful.");
		}else{
		  	return SuccessMsg.msg(false, "delete fail!");
		}
	 }
	
	public SuccessMsg update(MatchesResult matchesResult){
		if(this.updateByIdSelective(matchesResult)>0){
        	try{
            	matchesResult = this.queryById(matchesResult.getId());
                return SuccessMsg.msg("update successful.");
              }catch (Exception e){
              	return SuccessMsg.msg(false, "update fail!");
              }
		  }else{
		  	return SuccessMsg.msg(false, "update fail!");
		  }
	}
	
	public MatchesResultVo selectById(MatchesResult matchesResult) {
		MatchesResultVo matchesResultVo = null;
			try {
				matchesResultVo = this.queryById(matchesResult.getId());
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			return matchesResultVo;
	}
	
	
}