package com.castillo.fullstackbooks.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.castillo.fullstackbooks.models.Book;
import com.castillo.fullstackbooks.repository.BookRepository;


@Service
public class BookService {
	
	@Autowired
	private BookRepository bookRepo;
	
	//get all books to show on dashboard
	public List<Book> getAllBooks() {
		//use the repo to query the book table for all books 
		return (List<Book>)this.bookRepo.findAll();
	}
	
	//create idea
	public Book createNewBook(Book book) {
		return this.bookRepo.save(book);
	}
	
	//get one book
	public Book getOneBook(Long id) {
		return this.bookRepo.findById(id).orElse(null);
	}
	
	//update one book
	public Book updateBook(Book book) {
		return this.bookRepo.save(book);
	} 
	
	//delete one book
	public void deleteBook(Long id) {
		this.bookRepo.deleteById(id);
	}

}
