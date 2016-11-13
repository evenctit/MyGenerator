package com.mis.repositories;

import com.mis.domain.BioCategory;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BioCategoryRepository extends CrudRepository<BioCategory, Integer> {


}