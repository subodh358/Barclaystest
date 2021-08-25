package com.luv2code.springboot.bookdemo.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.luv2code.springboot.bookdemo.rest.BookService;
import com.test.springboot.bookdemo.entity.Book;

@RestController
@RequestMapping("/api")
public class BookRestController {


	private BookService bookService;

	@Autowired
	public BookRestController(BookService bookService) {
		this.bookService = bookService;
	}

	@GetMapping("/books")
	public List<Book> findAll() {
		return bookService.findAll();
	}

	@GetMapping("/books/{bookName}")
	public Book findbyID(@PathVariable String bookName) {

		Book book = bookService.findByName(bookName);
		if (book == null)
			throw new RuntimeException("book not found");
		return book;

	}

	@PostMapping("/books")
	public Book addBook(@RequestBody Book theBook) {

		theBook.setId(0);

		bookService.save(theBook);

		return theBook;
	}

}
