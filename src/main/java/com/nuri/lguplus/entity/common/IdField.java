package com.nuri.lguplus.entity.common;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import org.hibernate.annotations.GenericGenerator;

import lombok.Getter;
import lombok.Setter;

@MappedSuperclass
public class IdField extends DefaultField{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Getter @Setter
	long id;
	
//	@Id
//	@GeneratedValue(generator = "uuid")
//	@GenericGenerator(name = "uuid", strategy = "uuid2")
//	@Column(columnDefinition = "BINARY(16)", length = 16)
//	@Getter @Setter
//	private UUID id;
}
