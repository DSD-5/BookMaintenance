package com.tutiempolibro.bookmaintenance.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tutiempolibro.bookmaintenance.business.BookBusiness;
import com.tutiempolibro.bookmaintenance.model.Book;

@Service
public class BookMaintenanceService implements IBookMaintenanceService {
	
	@Autowired
	private BookBusiness bookBusiness;
	
	@Override
	public Book registrarLibro(Book book) throws Exception {
		// TODO Auto-generated method stub
		return bookBusiness.registrarLibro(book);
	}

	@Override
	public Book actualizarLibro(Book book) throws Exception {
		// TODO Auto-generated method stub
		return bookBusiness.actualizarLibro(book);
	}

	@Override
	public Book obtenerLibro(Integer idlibro) throws Exception {
		// TODO Auto-generated method stub
		return bookBusiness.obtenerLibro(idlibro);
	}

	@Override
	public List<Book> obtenerListaLibros() throws Exception {
		// TODO Auto-generated method stub
		return bookBusiness.obtenerListaLibros();
	}

	
}
