package com.lottery.web.interceptor;


import java.util.Iterator;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class SharedVariableInterceptor extends HandlerInterceptorAdapter implements InitializingBean{
	static Log log = LogFactory.getLog(SharedVariableInterceptor.class);
	
	
	@Override
	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		log.info(request.getContextPath() + ";" + request.getServletPath() + ";" + request.getRequestURI());

		if(modelAndView == null) {
			return;
		}

        String viewName = modelAndView.getViewName();
        if(viewName != null && !viewName.startsWith("redirect:")) {
            modelAndView.addObject("ctx", request.getContextPath());
            
        }
        String path = request.getServletPath().toString().trim();
        log.info(path);
        
        Map reqParam = request.getParameterMap();
        Iterator keys = reqParam.keySet().iterator();
        StringBuilder sb = new StringBuilder();
        while(keys.hasNext()){
        	Object o = keys.next();
        	if(o == null) continue;
        	log.info(o);
        	if(!"page".equals(o.toString()) && !"pageSize".equals(o.toString())){
        		sb.append("&");
        		String[] values = (String[])reqParam.get(o);
        		if(values != null && values.length > 0)
        			sb.append(o.toString() + "=" + values[0]);
        	}
        }
        modelAndView.addObject("param_queryString", sb.toString());
	}



	private void initSharedRenderVariables() {
		//globalRenderVariables.put("global_system_start_time", new Date());
	}
	
	public void afterPropertiesSet() throws Exception {
		initSharedRenderVariables();
	}
}
