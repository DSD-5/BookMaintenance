package com.tutiempolibro.bookmaintenance.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Entity(name="autor")
@Data
public class Autor implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idautor;
	
	private String publicaciones;
	
	private Date fecharegistro;
	
	private String estado;
	
}
