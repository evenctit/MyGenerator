package com.mis.repositories;

import com.mis.domain.BioCategory;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BioCategoryRepository extends PagingAndSortingRepository<BioCategory, Integer> {


}