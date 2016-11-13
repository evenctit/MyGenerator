package com.mis.repositories;

import com.mis.domain.TScholar;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TScholarRepository extends CrudRepository<TScholar, Long> {


}