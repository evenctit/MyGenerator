package com.mis.repositories;

import com.mis.domain.DataAnalyzeCategory;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DataAnalyzeCategoryRepository extends CrudRepository<DataAnalyzeCategory, Integer> {


}