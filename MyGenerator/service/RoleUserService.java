package com.mis.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mis.domain.RoleUser;
import com.mis.repositories.RoleUserRepository;
import com.mis.util.Constants;

@Component
@Transactional
public class RoleUserService {

	@Autowired
	private RoleUserRepository roleUserRepository;

	public int createRoleUser(RoleUser roleUser) {
		roleUserRepository.save(roleUser);
		return Constants.RETURN_STATUS_SUCCESS;
	}

	public int updateRoleUser(RoleUser roleUser) {
		roleUserRepository.save(roleUser);
		return Constants.RETURN_STATUS_SUCCESS;
	}

	public int deleteRoleUser(RoleUser roleUser) {
		roleUserRepository.delete(roleUser);
		return Constants.RETURN_STATUS_SUCCESS;
	}

	public RoleUser findById(Integer id) {
		return roleUserRepository.findOne(id);
	}

	public List<RoleUser> getAll() {
		Iterator<RoleUser> it = roleUserRepository.findAll().iterator();
		List<RoleUser> list = new ArrayList<RoleUser>();
		for (; it.hasNext();) {
			list.add((RoleUser) it.next());
		}
		return list;
	}
	
	
}