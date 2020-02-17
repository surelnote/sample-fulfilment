package com.nuri.lguplus.mvc.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.annotations.Parameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.nuri.lguplus.entity.SampleEntity;
import com.nuri.lguplus.entity.TestEntity;
import com.nuri.lguplus.mvc.service.SampleEntityService;
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

	@RequestMapping(value = "/info", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
	public TestEntity info(@RequestParam(required = false) Long id) throws Exception {
		return testService.getInfo(id);
	}
	
	@RequestMapping(value = "/insert", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	public TestEntity insert(@RequestBody HashMap param) throws Exception {
		return testService.insert(param.get("comment").toString());
	}

	@RequestMapping(value = "/delete", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
	public void delete(@RequestParam(required = false) Long id) throws Exception {
		this.testService.delete(id);
	}
}
