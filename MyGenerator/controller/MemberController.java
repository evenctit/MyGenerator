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

import com.mis.domain.Member;
import com.mis.services.MemberService;


@Controller
@RequestMapping("/member")
public class MemberController {

	@Autowired
    private MemberService memberService;
    
    @RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public Map<String,Object> getAll() {
		List<News> list = memberService.getAll();
		Map<String,Object> model = new HashMap<String,Object>();
		model.put("list", list);
		return model;
	}
	
	@RequestMapping(method = RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> create(@RequestBody Member member) {
		memberService.createMember(member);
		return null;
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	@ResponseBody
	public Map<String,Object> update(@PathVariable("id")Long id,@RequestBody Member member) {
		member.setId(id);
		memberService.updateMember(member);
		return null;
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@ResponseBody
	public Map<String,Object> delete(@PathVariable("id")Long id) {
		Member member = memberService.findById(id);
		memberService.deleteMember(member);
		return null;
	}
	
}