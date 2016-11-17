package com.mis.repositories;

import com.mis.domain.ScholarInteraction;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ScholarInteractionRepository extends CrudRepository<ScholarInteraction, Integer> {


}