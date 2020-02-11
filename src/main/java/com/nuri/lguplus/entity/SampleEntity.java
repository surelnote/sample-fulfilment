package com.nuri.lguplus.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

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
@Table(name="LGU_SAMPLE_ENTITY")
@SQLDelete(sql="update LGU_SAMPLE_ENTITY set IS_DELETED=true where ID=? ")
//@RestResource(path="api/test")
public class SampleEntity extends IdField {

	@Getter @Setter
	@Column(name = "USERID", length=12)
	String userId;
	
	@Getter @Setter
	@Column(name = "USERNAME", length=12)
	String userName;
	
	@Getter @Setter
	@Column(name = "PASSWORD", length=20)
	String password;

	@Getter @Setter
	@Column(name = "SCORES", length=10)
	int[] scores;
	
	@RestResource(exported = false)
	@Getter @Setter
	@Column(name = "IS_DELETED", columnDefinition = "boolean default false")
	boolean isDeleted;
	
	@Getter @Setter
	@OneToMany(mappedBy="sampleEntity", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<SampleEntityChild> sampleEntityChilds;

}