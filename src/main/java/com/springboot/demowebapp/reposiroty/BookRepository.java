package com.springboot.demowebapp.reposiroty;

import com.springboot.demowebapp.model.Book;
import org.springframework.data.repository.CrudRepository;

/**
 * @author Jaison Santos
 */
public interface BookRepository extends CrudRepository<Book, Long> {

}
