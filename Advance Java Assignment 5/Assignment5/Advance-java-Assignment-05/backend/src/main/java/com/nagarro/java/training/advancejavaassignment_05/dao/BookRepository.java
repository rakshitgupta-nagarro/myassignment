package com.nagarro.java.training.advancejavaassignment_05.dao;

import com.nagarro.java.training.advancejavaassignment_05.model.Book;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends CrudRepository<Book, Integer> {
	public Book findById(int id);
}
