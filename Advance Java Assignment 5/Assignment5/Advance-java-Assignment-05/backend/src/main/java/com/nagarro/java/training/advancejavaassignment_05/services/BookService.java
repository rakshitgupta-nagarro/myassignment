package com.nagarro.java.training.advancejavaassignment_05.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.nagarro.java.training.advancejavaassignment_05.model.Book;
import com.nagarro.java.training.advancejavaassignment_05.dao.BookRepository;

@Component
public class BookService {

	@Autowired
	private BookRepository BookRepository;

	// get all books
	public List<Book> getAllBooks() {
		List<Book> list = (List<Book>) this.BookRepository.findAll();
		return list;
	}

	// get book by id
	public Book getBookById(int id) {
		Book book = null;
		book = this.BookRepository.findById(id);
		return book;
	}

	// register book
	public Book addBook(Book book) {
		Book result = this.BookRepository.save(book);
		return result;
	}

	// delete book
	public void deleteBook(int id) {
		this.BookRepository.deleteById(id);
	}

	// update book details
	public void updateBook(Book book, int id) {
		Book updatedBook = new Book(id, book.getBookCode(), book.getBookName(), book.getAuthor(), book.getDateAdded());
		BookRepository.save(updatedBook);
	}
}
