package com.nuri.lguplus.repository.jpa;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import com.nuri.lguplus.entity.SampleEntity;


//@RestResource(path="api/test")
//@RepositoryRestResource(path = "api/test", collectionResourceRel = "api/test")
public interface SampleEntityRepository extends PagingAndSortingRepository<SampleEntity, Long> {
	
}

//public interface SampleEntityRepository extends PagingAndSortingRepository<SampleEntity, UUID> {
//	
//}

