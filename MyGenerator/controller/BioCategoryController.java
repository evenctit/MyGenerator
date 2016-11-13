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

import com.mis.domain.BioCategory;
import com.mis.services.BioCategoryService;


@Controller
@RequestMapping("/bioCategory")
public class BioCategoryController {

	@Autowired
    private BioCategoryService bioCategoryService;
    
    @RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public Map<String,Object> getAll() {
		List<BioCategory> list = bioCategoryService.getAll();
		Map<String,Object> model = new HashMap<String,Object>();
		model.put("list", list);
		return model;
	}
	
	@RequestMapping(method = RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> create(@RequestBody BioCategory bioCategory) {
		bioCategoryService.createBioCategory(bioCategory);
		return null;
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseBody
	public Map<String,Object> getById(@PathVariable("id")Integer id}) {
		BioCategory bioCategory = bioCategoryService.findById(id);
		Map<String,Object> model = new HashMap<String,Object>();
		model.put("bioCategory", bioCategory);
		return model;
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	@ResponseBody
	public Map<String,Object> update(@PathVariable("id")Integer id,@RequestBody BioCategory bioCategory) {
		bioCategory.setId(id);
		bioCategoryService.updateBioCategory(bioCategory);
		return null;
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@ResponseBody
	public Map<String,Object> delete(@PathVariable("id")Integer id) {
		BioCategory bioCategory = bioCategoryService.findById(id);
		bioCategoryService.deleteBioCategory(bioCategory);
		return null;
	}
	
}