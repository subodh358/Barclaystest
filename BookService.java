package com.luv2code.springboot.bookdemo.rest;

import java.util.List;

import com.test.springboot.bookdemo.entity.Book;

public interface BookService {

	public List<Book> findAll();

	public Book findByName(String theName);

	public void save(Book book);

}
