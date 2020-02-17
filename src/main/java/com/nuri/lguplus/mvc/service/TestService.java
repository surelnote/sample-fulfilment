package com.nuri.lguplus.mvc.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nuri.lguplus.config.context.AppContext;
import com.nuri.lguplus.entity.TestEntity;
import com.nuri.lguplus.repository.jpa.TestRepository;
import com.nuri.lguplus.repository.mybatis.TestMapper;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class TestService {
	@Autowired
	private TestMapper testMapper;	
	@Autowired
	private TestRepository testRepository;	
	
	public List<TestEntity> getList() {
		// return (List<TestEntity>) testRepository.findAll();
		return testMapper.select();
	}

	public TestEntity getInfo(Long id) {
		log.info("TestService.getInfo");
		return testRepository.findById(id).get();
	}

	public TestEntity insert(String comment) {
		log.info("TestService.insert");
		
		TestEntity entity = new TestEntity();
		entity.setComment(comment);
		entity.setCreateUser(AppContext.getCurrentUser().getUserId());
		entity.setUpdateUser(AppContext.getCurrentUser().getUserId());
		
		return testRepository.save(entity);
	}

	public void delete(Long id) {
		log.info("TestService.delete");
		
		testRepository.deleteById(id);
	}
}