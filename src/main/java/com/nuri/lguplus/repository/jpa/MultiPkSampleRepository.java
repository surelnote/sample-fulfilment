package com.nuri.lguplus.repository.jpa;

import org.springframework.data.repository.Repository;

import com.nuri.lguplus.entity.MultiPkSample;
import com.nuri.lguplus.entity.pk.MultiPkSamplePK;

public interface MultiPkSampleRepository extends Repository<MultiPkSample, MultiPkSamplePK> {
	MultiPkSample findById(MultiPkSamplePK cpInfoPK);
}
