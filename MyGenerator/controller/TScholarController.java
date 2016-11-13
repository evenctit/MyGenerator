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

import com.mis.domain.TScholar;
import com.mis.services.TScholarService;


@Controller
@RequestMapping("/tScholar")
public class TScholarController {

	@Autowired
    private TScholarService tScholarService;
    
    @RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public Map<String,Object> getAll() {
		List<News> list = tScholarService.getAll();
		Map<String,Object> model = new HashMap<String,Object>();
		model.put("list", list);
		return model;
	}
	
	@RequestMapping(method = RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> create(@RequestBody TScholar tScholar) {
		tScholarService.createTScholar(tScholar);
		return null;
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	@ResponseBody
	public Map<String,Object> update(@PathVariable("id")Long id,@RequestBody TScholar tScholar) {
		tScholar.setId(id);
		tScholarService.updateTScholar(tScholar);
		return null;
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@ResponseBody
	public Map<String,Object> delete(@PathVariable("id")Long id) {
		TScholar tScholar = tScholarService.findById(id);
		tScholarService.deleteTScholar(tScholar);
		return null;
	}
	
}