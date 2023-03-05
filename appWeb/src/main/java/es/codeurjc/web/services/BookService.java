package es.codeurjc.web.services;

import java.util.Collection;
import java.util.Optional;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import es.codeurjc.web.Book;
import es.codeurjc.web.repository.BookRepository;

@Service
public class BookService {

	@Autowired
	private BookRepository books;

	@PostConstruct
	public void init() {
		
		save(new Book("Libro1", "Cosas1", ":  )))))))"));
		save(new Book("Libro1", "Cosas2", ":))))))))) :)"));
		
	}

	public Collection<Book> findAll() {
		return books.findAll();
	}
	
	public Page<Book> findAll(Pageable pageable) {
		return books.findAll(pageable);
	}

	public Optional<Book> findById(long id) {
		return books.findById(id);
	}

	public void save(Book post) {

		books.save(post);
	}

	public void deleteById(long id) {
		this.books.deleteById(id);
	}

}
