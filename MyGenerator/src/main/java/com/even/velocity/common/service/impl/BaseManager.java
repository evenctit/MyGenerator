package com.even.velocity.common.service.impl;


import java.util.List;
import java.util.Map;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;

import com.even.velocity.dao.BaseDAO;
import com.even.velocity.model.Identifiable;
import com.lottery.utils.UUIDUtils;

public abstract class BaseManager<T extends Identifiable> {

	/**
	 * 获取基础数据库操作类
	 * @return
	 */
	protected abstract BaseDAO<T> getBaseDAO();

	public <V extends T> V queryOne(T query) {
		return getBaseDAO().selectOne(query);
	}

	
	public <V extends T> V queryById(String id) {
		return getBaseDAO().selectById(id);
	}
	
	public <V extends T> V queryById(int id) {
		return getBaseDAO().selectById(id);
	}

	
	public <V extends T> List<V> queryList(T query) {
		return getBaseDAO().selectList(query);
	}
	
	
	public <V extends T> List<V> queryAll() {
		return getBaseDAO().selectAll();
	}

	
	public <K, V extends T> Map<K, V> queryMap(T query, String mapKey) {
		return getBaseDAO().selectMap(query, mapKey);
	}

	
	public Long queryCount() {
		return getBaseDAO().selectCount();
	}

	
	public Long queryCount(T query) {
		return getBaseDAO().selectCount(query);
	}

	
    @Transactional
	public void insert(T entity) {
		getBaseDAO().insert(entity);
	}

	
    @Transactional
	public int delete(T query) {
		return getBaseDAO().delete(query);
	}

	
    @Transactional
	public int deleteById(String id) {
		return getBaseDAO().deleteById(id);
	}

	
    @Transactional
	public int deleteAll() {
		return getBaseDAO().deleteAll();
	}

	
    @Transactional
	public int updateById(T entity) {
		return getBaseDAO().updateById(entity);
	}

	
    @Transactional
	public int updateByIdSelective(T entity) {
		return getBaseDAO().updateByIdSelective(entity);
	}

	
	@Transactional
	public void deleteByIdInBatch(List<String> idList) {
		getBaseDAO().deleteByIdInBatch(idList);
	}

	
	@Transactional
	public void insertInBatch(List<T> entityList) {
		getBaseDAO().insertInBatch(entityList);
	}

	
	@Transactional
	public void updateInBatch(List<T> entityList) {
		getBaseDAO().updateInBatch(entityList);
	}

	
	public <V extends T> List<V> queryList(T query, Pageable pageable) {
		return getBaseDAO().selectList(query, pageable);
	}

	
	public <V extends T> Page<V> queryPageList(T query, Pageable pageable) {
		return getBaseDAO().selectPageList(query, pageable);
	}

	
	public <K, V extends T> Map<K, V> queryMap(T query, String mapKey, Pageable pageable) {
		return getBaseDAO().selectMap(query, mapKey, pageable);
	}
    
    public Long queryCount(T query,String condition) {
        if(condition!=null&&condition!=""){
            return getBaseDAO().selectCount(query);
        }else{
            return getBaseDAO().selectCount();
        }

    }

    public String generalTableKey(){
    	return UUIDUtils.create();
    }
    
}
