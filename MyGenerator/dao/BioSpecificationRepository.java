package com.mis.repositories;

import com.mis.domain.BioSpecification;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BioSpecificationRepository extends PagingAndSortingRepository<BioSpecification, Integer> {


}