package com.mis.repositories;

import com.mis.domain.Member;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository extends CrudRepository<Member, Long> {


}