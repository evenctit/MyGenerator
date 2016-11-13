package com.lottery.controller.league;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lottery.model.common.Leagues;
import com.lottery.services.LeagueService;

@Controller
public class LeagueController {
	
	@Autowired
	private LeagueService leagueService;
	
	
	@RequestMapping("/showLeagues")
	public String showLeagues(Model model){
		
		List<Leagues> list = leagueService.getLeagues();
		model.addAttribute("leagueList", list);
		return "manager/leagues";
	}

}
