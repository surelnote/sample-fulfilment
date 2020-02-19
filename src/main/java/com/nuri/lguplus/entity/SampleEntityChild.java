package com.nuri.lguplus.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.SQLDelete;

import com.nuri.lguplus.entity.common.IdField;

import lombok.Getter;
import lombok.Setter;

@Entity
@DynamicInsert
@DynamicUpdate
@Table(name="LGU_SAMPLE_ENTITY_CHILD")
@SQLDelete(sql="update LGU_SAMPLE_ENTITY_CHILD set IS_DELETED=true where ID=? ")
public class SampleEntityChild extends IdField {
	
	@Getter @Setter
	@Column(name = "EMAIL", length=100)
	String email;
	
	@Getter @Setter
	@Column(name = "PHONE_NUMBER", length=20)
	String phoneNumber;
	
	@Setter
	@Column(name = "IS_DELETED", columnDefinition = "boolean default false")
	boolean isDeleted;

	@Getter @Setter
	@ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "SAMPLEENTITY_ID")
    private SampleEntity sampleEntity;

	
}
