package com.mis.repositories;

import com.mis.domain.DataAnalyze;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DataAnalyzeRepository extends CrudRepository<DataAnalyze, Integer> {


}