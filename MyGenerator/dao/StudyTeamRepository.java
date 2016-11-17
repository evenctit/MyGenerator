package com.mis.repositories;

import com.mis.domain.StudyTeam;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudyTeamRepository extends CrudRepository<StudyTeam, Integer> {


}