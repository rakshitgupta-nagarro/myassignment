package com.nagarro.services;

import java.util.List;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.nagarro.model.Book;

public class BookService {

	private final static String EMP = "/books";
	private final static String EMP_AND_ID = "/books/{id}";
	private final static String SERVER_URI = "http://localhost:8084";
	private final static RestTemplate restTemplate = new RestTemplate();

	public static List<Book> getAllBooks() {
		ResponseEntity<List<Book>> bookResponse = restTemplate.exchange(SERVER_URI + EMP, HttpMethod.GET, null,
				new ParameterizedTypeReference<List<Book>>() {
				});
		List<Book> books = bookResponse.getBody();
		return books;
	}

	public static Book getBook(int id) {
		Book book = restTemplate.getForObject(SERVER_URI + EMP_AND_ID, Book.class, id);
		return book;
	}

	public static void createBook(Book book) {
		restTemplate.postForObject(SERVER_URI + EMP, book, Book.class);
	}

	public static void updateBook(Book book) {
		restTemplate.postForObject(SERVER_URI + EMP + "/update", book, Book.class);
	}

	public static void deleteBook(int id) {
		restTemplate.getForObject(SERVER_URI + "/deletebook/{id}", Book.class, id);
	}

}
