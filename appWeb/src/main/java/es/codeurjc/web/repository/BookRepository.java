package es.codeurjc.web.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import es.codeurjc.web.Book;

public interface BookRepository extends JpaRepository<Book, Long> {

}