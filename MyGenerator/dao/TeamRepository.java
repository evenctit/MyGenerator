package com.mis.repositories;

import com.mis.domain.Team;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeamRepository extends CrudRepository<Team, Integer> {


}