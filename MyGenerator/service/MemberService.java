package com.mis.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mis.domain.Member;
import com.mis.repositories.MemberRepository;
import com.mis.util.Constants;

@Component
@Transactional
public class MemberService {

	@Autowired
	private MemberRepository memberRepository;

	public int createMember(Member member) {
		memberRepository.save(member);
		return Constants.RETURN_STATUS_SUCCESS;
	}

	public int updateMember(Member member) {
		memberRepository.save(member);
		return Constants.RETURN_STATUS_SUCCESS;
	}

	public int deleteMember(Member member) {
		memberRepository.delete(member);
		return Constants.RETURN_STATUS_SUCCESS;
	}

	public News findById(Long id) {
		return memberRepository.findOne(id);
	}

	public List<Member> getAll() {
		Iterator<Member> it = memberRepository.findAll().iterator();
		List<Member> list = new ArrayList<Member>();
		for (; it.hasNext();) {
			list.add((Member) it.next());
		}
		return list;
	}
	
	
}