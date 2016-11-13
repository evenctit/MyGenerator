package com.mis.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mis.domain.TScholar;
import com.mis.repositories.TScholarRepository;
import com.mis.util.Constants;

@Component
@Transactional
public class TScholarService {

	@Autowired
	private TScholarRepository tScholarRepository;

	public int createTScholar(TScholar tScholar) {
		tScholarRepository.save(tScholar);
		return Constants.RETURN_STATUS_SUCCESS;
	}

	public int updateTScholar(TScholar tScholar) {
		tScholarRepository.save(tScholar);
		return Constants.RETURN_STATUS_SUCCESS;
	}

	public int deleteTScholar(TScholar tScholar) {
		tScholarRepository.delete(tScholar);
		return Constants.RETURN_STATUS_SUCCESS;
	}

	public News findById(Long id) {
		return tScholarRepository.findOne(id);
	}

	public List<TScholar> getAll() {
		Iterator<TScholar> it = tScholarRepository.findAll().iterator();
		List<TScholar> list = new ArrayList<TScholar>();
		for (; it.hasNext();) {
			list.add((TScholar) it.next());
		}
		return list;
	}
	
	
}