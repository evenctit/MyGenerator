package com.mis.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mis.domain.Team;
import com.mis.repositories.TeamRepository;
import com.mis.util.Constants;

@Component
@Transactional
public class TeamService {

	@Autowired
	private TeamRepository teamRepository;

	public int createTeam(Team team) {
		teamRepository.save(team);
		return Constants.RETURN_STATUS_SUCCESS;
	}

	public int updateTeam(Team team) {
		teamRepository.save(team);
		return Constants.RETURN_STATUS_SUCCESS;
	}

	public int deleteTeam(Team team) {
		teamRepository.delete(team);
		return Constants.RETURN_STATUS_SUCCESS;
	}

	public Team findById(Integer id) {
		return teamRepository.findOne(id);
	}

	public List<Team> getAll() {
		Iterator<Team> it = teamRepository.findAll().iterator();
		List<Team> list = new ArrayList<Team>();
		for (; it.hasNext();) {
			list.add((Team) it.next());
		}
		return list;
	}
	
	
}