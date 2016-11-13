package com.even.velocity.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.even.velocity.common.service.impl.BaseManager;
import com.even.velocity.model.MatchesResult;
import com.even.velocity.model.MatchesResultQuery;
import com.even.velocity.model.MatchesResultVo;
import com.even.velocity.model.bean.Pages;
import com.even.velocity.model.bean.SuccessMsg;
import com.even.velocity.service.MatchesResultService;
import com.even.velocity.web.controller.BaseControllerImpl;

@Controller
@RequestMapping("/matchesResult")
public class MatchesResultController extends BaseControllerImpl<MatchesResult, MatchesResultQuery> {

	@Autowired(required=true)
    @Qualifier(value="matchesResultService")
    private MatchesResultService matchesResultService;

	@Override
    protected BaseManager<MatchesResult>  getBaseManager() {
    	return matchesResultService; 
    }
    
   	@RequestMapping("/new")
	public String addPage(Model model,MatchesResult matchesResult) {
    	return "/add";
	}
	
	@RequestMapping("/add")
    public String add(MatchesResult matchesResult){
		SuccessMsg msg = matchesResultService.add(matchesResult);
        return "/manager";
	}

	@RequestMapping("/save")
    public String save(MatchesResultVo matchesResultVo, Model model){
		try {
			if(matchesResultVo.getId() == 0 || "".equals(matchesResultVo.getId())){
				SuccessMsg msg = matchesResultService.add(matchesResultVo);
			}else{
				SuccessMsg msg = matchesResultService.update(matchesResultVo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
    	return "redirect:/matchesResult/list";
    }
    
    @RequestMapping("/list")
    public  String  list(Model model,MatchesResultQuery queryVo)throws Exception{
		Pages matchesResult =  matchesResultService.list(queryVo);
        model.addAttribute("pageDatas", matchesResult);
        return "/list";
	}
	
	@RequestMapping("/getAll")
    public  String  getAll(Model model, MatchesResultQuery queryVo)throws Exception{
		List<MatchesResult> matchesResult = matchesResultService.getAll(queryVo);
        model.addAttribute("matchesResult", matchesResult);
        return "/manager";
	}
	
	@RequestMapping("/delete")
	public String delete(String id){
		SuccessMsg msg = matchesResultService.delete(id);
        return "/manager";
	}

	
	@RequestMapping("/update")
	public String update(MatchesResult matchesResult){   
		  SuccessMsg msg = matchesResultService.update(matchesResult);
		  return "/manager";
	}
	
	@RequestMapping("/selectById")
	public String selectById(Model model, MatchesResult matchesResult) {
		MatchesResultVo matchesResultVo = matchesResultService.selectById(matchesResult);
		model.addAttribute("matchesResult", matchesResultVo);
		return "/manager/edit";
	}
	
	
	
}