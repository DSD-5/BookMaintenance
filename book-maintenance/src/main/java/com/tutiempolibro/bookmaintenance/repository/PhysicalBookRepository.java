package com.tutiempolibro.bookmaintenance.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.tutiempolibro.bookmaintenance.model.PhysicalBook;

public interface PhysicalBookRepository  extends JpaRepository<PhysicalBook, Integer>{
	
	  @Modifying
	  @Query("delete from libro_fisico l where l.idlibro = :idlibro")
	  void deleteLibrosFisicosByIdlibro(Integer idlibro);
	  
	  public List<PhysicalBook> findByIdlibro(Integer idlibro);
	
}
