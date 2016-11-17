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

import com.mis.domain.StudyTeam;
import com.mis.services.StudyTeamService;


@Controller
@RequestMapping("/studyTeam")
public class StudyTeamController {

	@Autowired
    private StudyTeamService studyTeamService;
    
    @RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public Map<String,Object> getAll() {
		List<StudyTeam> list = studyTeamService.getAll();
		Map<String,Object> model = new HashMap<String,Object>();
		model.put("list", list);
		return model;
	}
	
	@RequestMapping(method = RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> create(@RequestBody StudyTeam studyTeam) {
		studyTeamService.createStudyTeam(studyTeam);
		return null;
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseBody
	public Map<String,Object> getById(@PathVariable("id")Integer id) {
		StudyTeam studyTeam = studyTeamService.findById(id);
		Map<String,Object> model = new HashMap<String,Object>();
		model.put("studyTeam", studyTeam);
		return model;
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	@ResponseBody
	public Map<String,Object> update(@PathVariable("id")Integer id,@RequestBody StudyTeam studyTeam) {
		studyTeam.setId(id);
		studyTeamService.updateStudyTeam(studyTeam);
		return null;
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@ResponseBody
	public Map<String,Object> delete(@PathVariable("id")Integer id) {
		StudyTeam studyTeam = studyTeamService.findById(id);
		studyTeamService.deleteStudyTeam(studyTeam);
		return null;
	}
	
}