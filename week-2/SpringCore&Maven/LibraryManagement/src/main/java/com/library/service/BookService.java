package com.library.service;
import com.library.repository.*;
public class BookService {
	BookRepository bookRepository;
	public void setBookRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }
	public void addBook(String book_name) {
		bookRepository.saveBook(book_name);
	}
}
