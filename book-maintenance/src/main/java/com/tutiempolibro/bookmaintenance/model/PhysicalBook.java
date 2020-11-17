package com.tutiempolibro.bookmaintenance.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Entity(name="libro_fisico")
@IdClass(PhysicalBookIdentity.class)
@Data
public class PhysicalBook implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	private Integer idlibro;
	
	@Id
	@Column(unique = true)
	private String codlibfis;
	private String tipo;
	private String estado;
	private Date fechaingreso;
	
	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="idlibro", nullable=false, insertable = false, updatable = false)
	private Book book;
	
}
