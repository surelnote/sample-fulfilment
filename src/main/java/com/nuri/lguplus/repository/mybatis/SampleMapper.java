package com.nuri.lguplus.repository.mybatis;

import com.nuri.lguplus.entity.SampleEntity;

public interface SampleMapper {
	SampleEntity selectById(Long id);
}
