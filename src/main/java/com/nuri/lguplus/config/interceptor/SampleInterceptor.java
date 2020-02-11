package com.nuri.lguplus.config.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.nuri.lguplus.config.context.AppContext;
import com.nuri.lguplus.domain.SampleDomain;

import lombok.extern.slf4j.Slf4j;


/** 
 * 이 Interceptor는 Login시에 걸리지 않게 config할것
 * 
 * TODO
 *  1. preHandle에서 request header에 저장된 토큰값을 parsing하여 유저 정보를 UserInfo 객체에 mapping
 *    -- token validation 필요
 *  2. ThreadLocal에 UserInfo를 저장하고 다른곳에서 자유로이 사용한다.
 *  3. afterCompletion 후에 ThreadLocal의 자원 꼭 반환할것
 */
@Slf4j
public class SampleInterceptor extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
    	
		log.info("Interceptor > preHandle");
		SampleDomain sample = new SampleDomain();
		sample.setUserId("PJJ2222");
		AppContext.setCurrentUser(sample);
		
		return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        log.info("Interceptor > postHandle");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object object, Exception arg3) throws Exception {
        log.info("Interceptor > afterCompletion" );
        AppContext.clear();
    }
}