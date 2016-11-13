package com.even.velocity.web.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.even.velocity.common.service.impl.BaseManager;
import com.even.velocity.model.Identifiable;

public abstract class BaseControllerImpl<T extends Identifiable, Q extends T> {
	
	private Logger log = LoggerFactory.getLogger(BaseControllerImpl.class);


	protected abstract BaseManager<T> getBaseManager();


}
