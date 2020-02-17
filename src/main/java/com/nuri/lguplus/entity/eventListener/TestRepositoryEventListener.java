package com.nuri.lguplus.entity.eventListener;

import java.time.LocalDateTime;

import org.springframework.data.rest.core.event.AbstractRepositoryEventListener;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.nuri.lguplus.config.context.AppContext;
import com.nuri.lguplus.entity.TestEntity;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class TestRepositoryEventListener extends AbstractRepositoryEventListener<TestEntity> {
	@Override
	protected void onBeforeSave(TestEntity testEntity) {
		log.info("TestRepositoryEventListener.onBeforeSave");
		
		LocalDateTime ldt = LocalDateTime.now();
		testEntity.setCreateUser(AppContext.getCurrentUser().getUserId());
		testEntity.setUpdateUser(AppContext.getCurrentUser().getUserId());
		testEntity.setCreateTime(ldt);
		testEntity.setUpdateTime(ldt);
	}
	

	@Override
	protected void onBeforeCreate(TestEntity testEntity) {
		log.info("TestRepositoryEventListener.onBeforeCreate");
	}

	@Override
	protected void onAfterCreate(TestEntity testEntity) {
		log.info("TestRepositoryEventListener.onAfterCreate");
	}

	@Override
	protected void onAfterSave(TestEntity testEntity) {
		log.info("TestRepositoryEventListener.onAfterSave");
	}

	@Override
	@Transactional(propagation = Propagation.MANDATORY)
	protected void onBeforeDelete(TestEntity testEntity) {
		log.info("TestRepositoryEventListener.onBeforeDelete");
	}

	@Override
	protected void onAfterDelete(TestEntity testEntity) {
		log.info("TestRepositoryEventListener.onAfterDelete");
	}
}
