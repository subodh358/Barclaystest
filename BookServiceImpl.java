package com.luv2code.springboot.bookdemo.rest;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.springboot.bookdemo.entity.Book;

@Service
public class BookServiceImpl implements BookService {

	private EntityManager entityManager;
	
    @Autowired
	public BookServiceImpl(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public List<Book> findAll() {
		// TODO Auto-generated method stub
		javax.persistence.Query query = entityManager.createQuery("from Book", Book.class);
		List<Book> books = query.getResultList();
		return books;
	}

	@Override
	public Book findByName(String theName) {
		// TODO Auto-generated method stub
		Book book = entityManager.find(Book.class, theName);
		return book;
	}

	@Override
	public void save(Book book) {
		// get the current hibernate session
		Book dbBook = entityManager.merge(book);
		book.setId((dbBook.getId())); // get generated id
	}

}
