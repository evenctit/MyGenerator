package com.mis.repositories;

import com.mis.domain.BioSpecification;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BioSpecificationRepository extends CrudRepository<BioSpecification, Integer> {


}