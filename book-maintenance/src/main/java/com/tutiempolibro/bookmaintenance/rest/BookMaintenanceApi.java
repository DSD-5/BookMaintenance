package com.tutiempolibro.bookmaintenance.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.tutiempolibro.bookmaintenance.model.Book;
import com.tutiempolibro.bookmaintenance.service.IBookMaintenanceService;

@RestController("/bookMaintenance")
public class BookMaintenanceApi {
	
	@Autowired
	private IBookMaintenanceService bookMaintenanceService;
	
	@PostMapping(value = "/registerBook", produces = { "application/json" })
	public Book registrarLibro(@RequestBody Book book) throws Exception {
		// TODO Auto-generated method stub			
		return bookMaintenanceService.registrarLibro(book);
	}
	
	@PostMapping(value = "/updateBook", produces = { "application/json" })
	public Book actualizarLibro(@RequestBody Book book) throws Exception {
		// TODO Auto-generated method stub			
		return bookMaintenanceService.actualizarLibro(book);
	}
	
	@GetMapping(value = "/retrieveBook/{id}", produces = { "application/json" })
	public Book actualizarLibro(@PathVariable (value ="id") Integer id) throws Exception {
		// TODO Auto-generated method stub			
		return bookMaintenanceService.obtenerLibro(id);
	}
	
	@GetMapping(value = "/retrieveBooks", produces = { "application/json" })
	public List<Book> obtenerListaLibros() throws Exception {
		// TODO Auto-generated method stub			
		return bookMaintenanceService.obtenerListaLibros();
	}
	
}
