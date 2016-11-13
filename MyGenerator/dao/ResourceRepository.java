package com.mis.repositories;

import com.mis.domain.Resource;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResourceRepository extends CrudRepository<Resource, Integer> {


}