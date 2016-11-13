package com.mis.repositories;

import com.mis.domain.Bio;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BioRepository extends CrudRepository<Bio, Integer> {


}