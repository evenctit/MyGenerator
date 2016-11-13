package com.mis.repositories;

import com.mis.domain.Article;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArticleRepository extends CrudRepository<Article, Integer> {


}