package com.nuri.lguplus.entity.eventListener;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.rest.core.event.AbstractRepositoryEventListener;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.nuri.lguplus.entity.SampleEntity;
import com.nuri.lguplus.repository.jpa.SampleEntityRepository;

import lombok.extern.slf4j.Slf4j;

@Transactional
@Slf4j
@Component
public class SampleEntityRepositoryEventListener extends AbstractRepositoryEventListener<SampleEntity> {

	@Autowired
	private SampleEntityRepository sampleEntityRepository;
	
	@Value("${apiurl.sampleValue}")
	String sampleValue;

	
	@Override
	protected void onBeforeCreate(SampleEntity sampleEntity) {
		log.info("onBeforeCreate");
	}

	@Override
	protected void onAfterCreate(SampleEntity sampleEntity) {
		log.info("onAfterCreate");
	}

	@Override
	protected void onBeforeSave(SampleEntity sampleEntity) {
		log.info("onBeforeSave");
	}

	@Override
	protected void onAfterSave(SampleEntity sampleEntity) {
		log.info("onAfterSave");
	}

	@Override
	protected void onBeforeDelete(SampleEntity sampleEntity) {
		log.info("onBeforeDelete");
	}

	@Override
	protected void onAfterDelete(SampleEntity sampleEntity) {
		log.info("onAfterDelete");
	}
}
