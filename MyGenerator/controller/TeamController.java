package com.mis.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mis.domain.Team;
import com.mis.services.TeamService;


@Controller
@RequestMapping("/team")
public class TeamController {

	@Autowired
    private TeamService teamService;
    
    @RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public Map<String,Object> getAll() {
		List<Team> list = teamService.getAll();
		Map<String,Object> model = new HashMap<String,Object>();
		model.put("list", list);
		return model;
	}
	
	@RequestMapping(method = RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> create(@RequestBody Team team) {
		teamService.createTeam(team);
		return null;
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseBody
	public Map<String,Object> getById(@PathVariable("id")Integer id}) {
		Team team = teamService.findById(id);
		Map<String,Object> model = new HashMap<String,Object>();
		model.put("team", team);
		return model;
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	@ResponseBody
	public Map<String,Object> update(@PathVariable("id")Integer id,@RequestBody Team team) {
		team.setId(id);
		teamService.updateTeam(team);
		return null;
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@ResponseBody
	public Map<String,Object> delete(@PathVariable("id")Integer id) {
		Team team = teamService.findById(id);
		teamService.deleteTeam(team);
		return null;
	}
	
}