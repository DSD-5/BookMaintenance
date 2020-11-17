package com.tutiempolibro.bookmaintenance.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Id;

public class PhysicalBookIdentity implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	private Integer idlibro;
	
	@Id
	@Column(unique = true)
	private String codlibfis;

	public PhysicalBookIdentity(Integer idlibro, String codlibfis) {
		super();
		this.idlibro = idlibro;
		this.codlibfis = codlibfis;
	}
	
	public PhysicalBookIdentity() {
		
	}
	
}
