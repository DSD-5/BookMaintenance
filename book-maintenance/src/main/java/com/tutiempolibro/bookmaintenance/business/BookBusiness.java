package com.tutiempolibro.bookmaintenance.business;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tutiempolibro.bookmaintenance.model.Autor;
import com.tutiempolibro.bookmaintenance.model.Book;
import com.tutiempolibro.bookmaintenance.model.Category;
import com.tutiempolibro.bookmaintenance.model.PhysicalBook;
import com.tutiempolibro.bookmaintenance.repository.AutorRepository;
import com.tutiempolibro.bookmaintenance.repository.BookRepository;
import com.tutiempolibro.bookmaintenance.repository.CategoryRepository;
import com.tutiempolibro.bookmaintenance.repository.PhysicalBookRepository;

@Service
public class BookBusiness {

	@Autowired
	private BookRepository bookRepo;

	@Autowired
	private CategoryRepository categoryRepo;

	@Autowired
	private AutorRepository autorRepo;

	@Autowired
	private PhysicalBookRepository physicalBookRepo;

	public Book registrarLibro(Book libro) throws Exception {

		Optional<Category> categoria = categoryRepo.findById(libro.getCategoria().getIdcategoria());
		if (!categoria.isPresent()) {
			throw new Exception("Categoria asociada no existe");
		}

		Optional<Autor> autor = autorRepo.findById(libro.getAutor().getIdautor());
		if (!autor.isPresent()) {
			throw new Exception("Autor asociado no existe");
		}

		libro = bookRepo.save(libro);

		for (PhysicalBook p : libro.getLibrosfisicos()) {
			p.setIdlibro(libro.getIdlibro());
			p.setFechaingreso(new Date());
			physicalBookRepo.save(p);
		}

		return libro;
	}

	@Transactional
	public Book actualizarLibro(Book libro) throws Exception {

		Optional<Category> categoria = categoryRepo.findById(libro.getCategoria().getIdcategoria());
		if (!categoria.isPresent()) {
			throw new Exception("Categoria asociada no existe");
		}

		Optional<Autor> autor = autorRepo.findById(libro.getAutor().getIdautor());
		if (!autor.isPresent()) {
			throw new Exception("Autor asociado no existe");
		}

		physicalBookRepo.deleteLibrosFisicosByIdlibro(libro.getIdlibro());

		for (PhysicalBook p : libro.getLibrosfisicos()) {
			p.setIdlibro(p.getIdlibro());
			p.setCodlibfis(p.getCodlibfis());
			p.setFechaingreso(new Date());
			physicalBookRepo.save(p);
		}

		return bookRepo.save(libro);
	}

	public Book obtenerLibro(Integer idlibro) throws Exception {
		Optional<Book> bookOp = bookRepo.findById(idlibro);

		if (bookOp.isPresent()) {
			Book book = bookOp.get();

			return book;
		}

		return null;

	}

	public List<Book> obtenerListaLibros() throws Exception {

		return bookRepo.findAll();

	}

}
