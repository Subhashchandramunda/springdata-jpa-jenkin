package org.dxc.book.repository;


import java.util.List;

import org.dxc.book.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
public interface BookRepository extends JpaRepository<Book, Integer> {

	@Query("Select b from Book b where b.publisher=:publisher")
	List<Book> findByPublisher(@Param("publisher")String publisher);

	@Query("Select b from Book b where b.authorName=:authorName")
	List<Book> findByAuthor(@Param("authorName")String authorName);

	@Query("Select b from Book b where b.category=:category")
	List<Book> findByCategory(@Param("category")String category);

	

	


	
}
