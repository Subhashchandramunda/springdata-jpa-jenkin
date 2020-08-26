package org.dxc.book.controller;
import java.util.List;

import java.util.Optional;

import org.dxc.book.model.Book;
import org.dxc.book.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/book")
public class BookController {
	
	@Autowired
	BookService bookService;
	
	@RequestMapping(value="/save" ,method=RequestMethod.POST)
	public String saveBook(@RequestBody Book book) {
		bookService.save(book);
		return "book saved";
	}
	@RequestMapping(value="/getAllBooks" ,method=RequestMethod.GET)
	public List<Book> getAllBooks(){
		return (List<Book>) bookService.findAll();
	}
	@RequestMapping(value="/getBookById/{pId}" ,method=RequestMethod.GET)
	public Optional<Book> getBook(@PathVariable("pId")int pId) {
		return bookService.findById(pId);
	}
	@RequestMapping(value="/deleteBookById/{pId}" ,method=RequestMethod.DELETE)
	public String deleteBook(@PathVariable("pId")int pId) {
		 bookService.deleteById(pId);
		 return "Id deleted";
	}
	@RequestMapping(value="/updateBookById/{pId}" ,method=RequestMethod.PUT)
	public String updateBook(@RequestBody Book book,@PathVariable("pId")int pId) {
		bookService.updateBook(pId,book);
		return "Book Updated";
	}
	@RequestMapping(value="/findByPublisher/{publisher}" ,method=RequestMethod.GET)
	public List<Book> findByPublisher(@PathVariable("publisher")String publisher){
		return (List<Book>) bookService.findByPublisher(publisher);
	}
	@RequestMapping(value="/findByAuthor/{authorName}" ,method=RequestMethod.GET)
	public List<Book> findByAuthor(@PathVariable("authorName")String authorName){
		return (List<Book>) bookService.findByAuthor(authorName);
	}
	@RequestMapping(value="/findByCategory/{category}" ,method=RequestMethod.GET)
	public List<Book> findByCategory(@PathVariable("category")String category){
		return (List<Book>) bookService.findByACategory(category);
	}
	
}

