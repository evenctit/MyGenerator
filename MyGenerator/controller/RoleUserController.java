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

import com.mis.domain.RoleUser;
import com.mis.services.RoleUserService;


@Controller
@RequestMapping("/roleUser")
public class RoleUserController {

	@Autowired
    private RoleUserService roleUserService;
    
    @RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public Map<String,Object> getAll() {
		List<RoleUser> list = roleUserService.getAll();
		Map<String,Object> model = new HashMap<String,Object>();
		model.put("list", list);
		return model;
	}
	
	@RequestMapping(method = RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> create(@RequestBody RoleUser roleUser) {
		roleUserService.createRoleUser(roleUser);
		return null;
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseBody
	public Map<String,Object> getById(@PathVariable("id")Integer id}) {
		RoleUser roleUser = roleUserService.findById(id);
		Map<String,Object> model = new HashMap<String,Object>();
		model.put("roleUser", roleUser);
		return model;
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	@ResponseBody
	public Map<String,Object> update(@PathVariable("id")Integer id,@RequestBody RoleUser roleUser) {
		roleUser.setId(id);
		roleUserService.updateRoleUser(roleUser);
		return null;
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@ResponseBody
	public Map<String,Object> delete(@PathVariable("id")Integer id) {
		RoleUser roleUser = roleUserService.findById(id);
		roleUserService.deleteRoleUser(roleUser);
		return null;
	}
	
}