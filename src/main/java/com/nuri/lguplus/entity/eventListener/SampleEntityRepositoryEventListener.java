package com.nuri.lguplus.entity.eventListener;


import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.rest.core.event.AbstractRepositoryEventListener;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.nuri.lguplus.config.context.AppContext;
import com.nuri.lguplus.entity.SampleEntity;
import com.nuri.lguplus.entity.SampleEntityChild;
import com.nuri.lguplus.repository.jpa.SampleEntityRepository;

import lombok.extern.slf4j.Slf4j;

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
		
		LocalDateTime ldt = LocalDateTime.now();
		sampleEntity.setCreateUser(AppContext.getCurrentUser().getUserId());
		sampleEntity.setUpdateUser(AppContext.getCurrentUser().getUserId());
		sampleEntity.setCreateTime(ldt);
		sampleEntity.setUpdateTime(ldt);
		
		if(sampleEntity.getSampleEntityChilds() != null) {
			for(SampleEntityChild sec : sampleEntity.getSampleEntityChilds()) {
				sec.setSampleEntity(sampleEntity);
				sec.setCreateUser(AppContext.getCurrentUser().getUserId());
				sec.setUpdateUser(AppContext.getCurrentUser().getUserId());
				sec.setCreateTime(ldt);
				sec.setUpdateTime(ldt);
			}
		}
	}

	@Override
	protected void onAfterCreate(SampleEntity sampleEntity) {
		log.info("onAfterCreate");
	}

	@Override
	protected void onBeforeSave(SampleEntity sampleEntity) {
		log.info("onBeforeSave");
		
		//TODO 일반 유저가 is_deleted 필드를 update하려 하면 막아야한다.
		
		LocalDateTime ldt = LocalDateTime.now();
		sampleEntity.setUpdateUser(AppContext.getCurrentUser().getUserId());
		sampleEntity.setUpdateTime(ldt);
		
		if(sampleEntity.getSampleEntityChilds() != null) {
			for(SampleEntityChild sec : sampleEntity.getSampleEntityChilds()) {
				sec.setSampleEntity(sampleEntity);
				sec.setUpdateUser(AppContext.getCurrentUser().getUserId());
				sec.setUpdateTime(ldt);
			}
		}
	}

	@Override
	protected void onAfterSave(SampleEntity sampleEntity) {
		log.info("onAfterSave");
	}

	@Override
	@Transactional(propagation = Propagation.MANDATORY)
	protected void onBeforeDelete(SampleEntity sampleEntity) {
		log.info("onBeforeDelete");
		
		LocalDateTime ldt = LocalDateTime.now();
		sampleEntity.setUpdateUser(AppContext.getCurrentUser().getUserId());
		sampleEntity.setUpdateTime(ldt);
		
		if(sampleEntity.getSampleEntityChilds() != null) {
			for(SampleEntityChild sec : sampleEntity.getSampleEntityChilds()) {
				sec.setUpdateUser(AppContext.getCurrentUser().getUserId());
				sec.setUpdateTime(ldt);
			}
		}
		sampleEntityRepository.save(sampleEntity);
	}

	@Override
	protected void onAfterDelete(SampleEntity sampleEntity) {
		log.info("onAfterDelete");
	}
}
