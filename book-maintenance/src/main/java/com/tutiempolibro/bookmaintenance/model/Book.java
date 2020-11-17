package com.tutiempolibro.bookmaintenance.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Entity(name="libro")
@Data
public class Book implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idlibro;
	
	private String nombre;
	private String descripcion;
	private Integer stockventa;
	private Integer stockalquiler;
	private String tipo;
	private String estado;
	private Double costoalquiler;
	private Double costoventa;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idcategoria")
	private Category categoria;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idautor")
	private Autor autor;
	
	
	@OneToMany(mappedBy="book")
	private List<PhysicalBook> librosfisicos;
	
}
