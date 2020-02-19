package com.nuri.lguplus.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.SQLDelete;
import org.springframework.data.rest.core.annotation.RestResource;

import com.nuri.lguplus.entity.common.IdField;

import lombok.Getter;
import lombok.Setter;

@Entity
@DynamicInsert
@DynamicUpdate
@Table(name="TEST_DATA")
@SQLDelete(sql="update TEST_DATA set IS_DELETED=true where ID=? ")
public class TestEntity extends IdField {

	@Getter @Setter
	@Column(name = "COMMENT", length=100)
	@Size(min=3,max=5,message="comment는 3자이상 5자이하로 입력해야 합니다.")
	@NotNull(message="comment는 필수항목입니다.")
	String comment;
	
	@RestResource(exported = false)
	@Getter @Setter
	@Column(name = "IS_DELETED", columnDefinition = "boolean default false")
	boolean isDeleted;
}