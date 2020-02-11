package com.nuri.lguplus.entity.common;


import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;

import lombok.Data;

@Data
@MappedSuperclass
public abstract class DefaultField {

	@CreationTimestamp
	@Column(name = "CREATE_TIME", columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP", updatable=false)
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
	@JsonSerialize(using = LocalDateTimeSerializer.class)
	@JsonDeserialize(using = LocalDateTimeDeserializer.class)
	LocalDateTime createTime;
	
	@UpdateTimestamp
	@Column(name = "UPDATE_TIME", columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
	@JsonSerialize(using = LocalDateTimeSerializer.class)
	@JsonDeserialize(using = LocalDateTimeDeserializer.class)
	LocalDateTime updateTime;
	
	@Column(name = "CREATE_USER", nullable=false, updatable=false)
	String createUser;
	
	@Column(name = "UPDATE_USER", nullable=true)
	String updateUser;
	
}
	