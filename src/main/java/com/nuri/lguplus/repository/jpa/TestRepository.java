package com.nuri.lguplus.repository.jpa;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.nuri.lguplus.entity.TestEntity;


//@RestResource(path="api/test")
//@RepositoryRestResource(path = "api/test", collectionResourceRel = "api/test")
public interface TestRepository extends PagingAndSortingRepository<TestEntity, Long> {
	
}

//public interface SampleEntityRepository extends PagingAndSortingRepository<SampleEntity, UUID> {
//	
//}

