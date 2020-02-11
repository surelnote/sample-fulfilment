package com.nuri.lguplus.entity.pk;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.Data;

@Embeddable
@Data
public class MultiPkSamplePK implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Column(name = "MP_CP_CODE")
	String pk1;
	
	@Column(name = "PG_CODE")
	String pk2;
	
}
