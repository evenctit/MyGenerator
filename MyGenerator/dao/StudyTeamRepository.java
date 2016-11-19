package com.mis.repositories;

import com.mis.domain.StudyTeam;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudyTeamRepository extends PagingAndSortingRepository<StudyTeam, Integer> {


}