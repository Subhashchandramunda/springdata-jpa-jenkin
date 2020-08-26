package org.dxc.book.service;


import java.util.List;

import java.util.Optional;

import org.dxc.book.model.Book;

public interface BookService {
	

	public void save(Book book);

	public List<Book> findAll();

	public Optional<Book> findById(int pId);

	public void deleteById(int pId);

	public void updateBook(int pId, Book book);		

	public List<Book> findByPublisher(String publisher);

	public List<Book> findByAuthor(String authorName);

	public List<Book> findByACategory(String category);

	
	
	

		

}
