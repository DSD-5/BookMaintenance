package com.tutiempolibro.bookmaintenance.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tutiempolibro.bookmaintenance.model.Book;

public interface BookRepository extends JpaRepository<Book, Integer>{
	
	
	
}
