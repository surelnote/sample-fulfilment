package com.nuri.lguplus.repository.mybatis;

import java.util.List;

import com.nuri.lguplus.entity.TestEntity;

public interface TestMapper {
	List<TestEntity> select();
	List<TestEntity> selectById(Long id);
}
