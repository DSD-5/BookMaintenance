package com.tutiempolibro.bookmaintenance.service;

import java.util.List;

import com.tutiempolibro.bookmaintenance.model.Book;

public interface IBookMaintenanceService {

	public Book registrarLibro(Book book) throws Exception;
	
	public Book actualizarLibro(Book book) throws Exception;
	
	public Book obtenerLibro(Integer idlibro) throws Exception;
	
	public List<Book> obtenerListaLibros() throws Exception;
	
}
