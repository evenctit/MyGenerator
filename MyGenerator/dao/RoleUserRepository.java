package com.mis.repositories;

import com.mis.domain.RoleUser;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleUserRepository extends CrudRepository<RoleUser, Integer> {


}