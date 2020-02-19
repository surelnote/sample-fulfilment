package com.nuri.lguplus.mvc.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.nuri.lguplus.entity.TestEntity;
import com.nuri.lguplus.mvc.service.TestService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping(value = "test")
public class TestController {
	
	@Autowired
	private TestService testService;
	
	@RequestMapping(value = "/list", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
	public List<TestEntity> list(HttpServletRequest request, HttpServletResponse response) throws Exception {
		return testService.getList();
	}

}
