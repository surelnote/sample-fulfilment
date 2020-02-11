package com.nuri.lguplus.repository.jpa;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.nuri.lguplus.entity.SampleEntity2;


//@RestResource(path="api/test")
//@RepositoryRestResource(path = "api/test", collectionResourceRel = "api/test")
public interface SampleEntityRepository2 extends PagingAndSortingRepository<SampleEntity2, Long> {
	
}

//public interface SampleEntityRepository extends PagingAndSortingRepository<SampleEntity, UUID> {
//	
//}

