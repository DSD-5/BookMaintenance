package com.tutiempolibro.bookmaintenance.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tutiempolibro.bookmaintenance.model.Autor;

public interface AutorRepository extends JpaRepository<Autor, Integer> {
	
	
}
