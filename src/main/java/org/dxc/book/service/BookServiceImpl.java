package org.dxc.book.service;

import java.util.List;
import java.util.Optional;

import org.dxc.book.model.Book;
import org.dxc.book.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class BookServiceImpl implements BookService {

	@Autowired
	BookRepository bookRepository;
	
	@Override
	public void save(Book book) {
		// TODO Auto-generated method stub
		bookRepository.save(book);
	}

	@Override
	public List<Book> findAll() {
		// TODO Auto-generated method stub		
	List<Book>	booklist=bookRepository.findAll();
	return booklist;
	}
	

	@Override
	public Optional<Book> findById(int pId) {
		// TODO Auto-generated method stub
		Optional<Book> optional=bookRepository.findById(pId);
		return optional;
	}

	@Override
	public void deleteById(int pId) {
		// TODO Auto-generated method stub
		bookRepository.deleteById(pId);
	}

	@Override
	public void updateBook(int pId, Book book){
		// TODO Auto-generated method stub
		Book book1=bookRepository.getOne(pId);
		book1.setBookName(book.getBookName());
		book1.setAuthorName(book.getAuthorName());
		book1.setCategory(book.getCategory());
		book1.setIsbn(book.getIsbn());
		book1.setPublisher(book.getPublisher());
		book1.setPrice(book.getPrice());		
		bookRepository.save(book1);
	}

	@Override
	public List<Book> findByPublisher(String publisher) {
		// TODO Auto-generated method stub
		return bookRepository.findByPublisher(publisher);
	}

	@Override
	public List<Book> findByAuthor(String authorName) {
		// TODO Auto-generated method stub
		return bookRepository.findByAuthor(authorName);
	}

	@Override
	public List<Book> findByACategory(String category) {
		// TODO Auto-generated method stub
		return bookRepository.findByCategory(category);
	}	

}
