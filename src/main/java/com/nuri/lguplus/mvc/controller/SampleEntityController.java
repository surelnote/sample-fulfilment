package com.nuri.lguplus.mvc.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.nuri.lguplus.entity.SampleEntity;
import com.nuri.lguplus.mvc.service.SampleEntityService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping(value = "sampleEntities")
public class SampleEntityController {
	
	@Autowired
	private SampleEntityService sampleEntityService;
	
	
	@RequestMapping(value = "/list", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
	public List<SampleEntity> getUser(HttpServletRequest request, HttpServletResponse response) throws Exception {
		return this.sampleEntityService.getList();
	}
	
}
