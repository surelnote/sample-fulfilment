package com.nuri.lguplus.mvc.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.nuri.lguplus.entity.SampleEntity;
import com.nuri.lguplus.mvc.service.SampleService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping(value = "mvc")
public class SampleController {
	
	@Autowired
	private SampleService sampleService;
	
	@RequestMapping(value = "/user/{id}", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
	public SampleEntity getUser(HttpServletRequest request, HttpServletResponse response,
			@PathVariable(value = "id") Long id) throws Exception {
		return this.sampleService.getUser(id);
	}
	
	@RequestMapping(value = "/auth/{id}", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    public SampleEntity signin(String email, String password, HttpServletResponse response, @PathVariable(value = "id") Long id){
		
		SampleEntity loginMember = this.sampleService.getUser(id);
		
        String token = sampleService.createToken(loginMember);
        
        response.setHeader("Authorization", token);
        return loginMember;
        
    }
}
