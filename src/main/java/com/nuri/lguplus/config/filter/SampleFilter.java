package com.nuri.lguplus.config.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SampleFilter implements Filter {
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		log.info("init SampleFilter");
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		
		//TODO CORS 관련된 내용 넣을것
		
		log.info("##### filter - before #####");
		chain.doFilter(req, res);
		log.info("##### filter - after #####");
	}
	
	@Override
	public void destroy() {
		log.info("destroy CORSFilter");
	}
	
}