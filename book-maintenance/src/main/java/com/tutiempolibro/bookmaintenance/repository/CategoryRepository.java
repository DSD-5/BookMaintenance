package com.tutiempolibro.bookmaintenance.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tutiempolibro.bookmaintenance.model.Category;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
	
}
