package com.nuri.lguplus.entity;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.nuri.lguplus.entity.common.DefaultField;
import com.nuri.lguplus.entity.pk.MultiPkSamplePK;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="LGU_MULTI_PK_SAMPLE")
public class MultiPkSample extends DefaultField {
	
	@Id
	@EmbeddedId
	@Getter @Setter
	MultiPkSamplePK cpInfoPK;
	
	@Getter @Setter
	@Column(name = "COLUMN1", length=10)
	String column1;
	
	@Getter @Setter
	@Column(name = "COLUMN2", length=10)
	String column2;

}
