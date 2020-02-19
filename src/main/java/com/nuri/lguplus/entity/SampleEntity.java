package com.nuri.lguplus.entity;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.PostPersist;
import javax.persistence.PostRemove;
import javax.persistence.PostUpdate;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.SQLDelete;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.transaction.annotation.Transactional;

import com.nuri.lguplus.config.context.AppContext;
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
	@Size(min=3,max=5,message="User Id는 3자이상 5자미만으로 입력해야 합니다.")
	@NotNull(message="User Id는 필수항목입니다.")
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
	@Setter
	@Column(name = "IS_DELETED", columnDefinition = "boolean default false")
	boolean isDeleted;
	
	@Getter @Setter
	@OneToMany(mappedBy="sampleEntity", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<SampleEntityChild> sampleEntityChilds;

	
	@PrePersist
	private void prePersist() {
		LocalDateTime ldt = LocalDateTime.now();
		this.setCreateUser(AppContext.getCurrentUser().getUserId());
		this.setUpdateUser(AppContext.getCurrentUser().getUserId());
		this.setCreateTime(ldt);
		this.setUpdateTime(ldt);
		
		if(this.getSampleEntityChilds() != null) {
			for(SampleEntityChild sec : this.getSampleEntityChilds()) {
				sec.setSampleEntity(this);
				sec.setCreateUser(AppContext.getCurrentUser().getUserId());
				sec.setUpdateUser(AppContext.getCurrentUser().getUserId());
				sec.setCreateTime(ldt);
				sec.setUpdateTime(ldt);
			}
		}
	}
	
	@Transactional
	@PostPersist
    private void postPersist() {
//		TestRepository testRepository = FulfilmentApplication.applicationContext.getBean(TestRepository.class);
//		TestEntity te = new TestEntity();
//		te.setComment("test");
//		te.setCreateUser("PJJ2");
//		testRepository.save(te);
//		throw new Exception();
		
    }

    
    @PostUpdate
    private void postUpdate() {
    	LocalDateTime ldt = LocalDateTime.now();
		this.setUpdateUser(AppContext.getCurrentUser().getUserId());
		this.setUpdateTime(ldt);
		
		if(this.getSampleEntityChilds() != null) {
			for(SampleEntityChild sec : this.getSampleEntityChilds()) {
				sec.setSampleEntity(this);
				sec.setUpdateUser(AppContext.getCurrentUser().getUserId());
				sec.setUpdateTime(ldt);
			}
		}
    }
    
    @PostRemove
    private void PostRemove() {
    	LocalDateTime ldt = LocalDateTime.now();
		this.setUpdateUser(AppContext.getCurrentUser().getUserId());
		this.setUpdateTime(ldt);
		
		if(this.getSampleEntityChilds() != null) {
			for(SampleEntityChild sec : this.getSampleEntityChilds()) {
				sec.setSampleEntity(this);
				sec.setUpdateUser(AppContext.getCurrentUser().getUserId());
				sec.setUpdateTime(ldt);
			}
		}
    }
	
}