package com.nuri.lguplus.mvc.service;

import java.io.UnsupportedEncodingException;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.nuri.lguplus.entity.SampleEntity;
import com.nuri.lguplus.repository.mybatis.SampleMapper;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class SampleService {
	
	// --> 이후 ConfigMap 처리
	@Value("${jwt.key}")
	private String key;
	@Value("${jwt.subject}")
	private String subject;
	@Value("${jwt.salt}")
	private String SALT;
	
	@Value("${jwt.expiration}")
	private long expirationTime;
	
	
	@Autowired
	private SampleMapper sampleEntityMapper;
	
	
	public SampleEntity getUser(Long id) {
		return sampleEntityMapper.selectById(id);
	}
	
	public <T> String createToken(T data) {
		LocalDateTime now = LocalDateTime.now();
		LocalDateTime expiration = now.plusMinutes(expirationTime);
		Date expirationDate = Date.from( expiration.atZone( ZoneId.systemDefault()).toInstant());
		
		return "Bearer " + Jwts.builder()
				.setHeaderParam("typ", "JWT")
				.setHeaderParam("regDate", now)
				.setSubject(this.subject)
				.setExpiration(expirationDate)
				.claim(this.key, data)
				.signWith(SignatureAlgorithm.HS256, this.generateKey())
				.compact();
		
	}

	private byte[] generateKey() {
		byte[] key = null;
		try {
			key = SALT.getBytes("UTF-8");
		} catch (UnsupportedEncodingException e) {
			if (log.isInfoEnabled()) {
				e.printStackTrace();
			} else {
				log.error("Making JWT Key Error ::: {}", e.getMessage());
			}
		}

		return key;
	}
	
	public void saveTokenToRedis(String token) {
		// TODO redis에 유저Id로 토큰 값 저장 - redis의 expire 조건으로(30분)
	}
}
	
