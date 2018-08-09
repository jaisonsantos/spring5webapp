package com.springboot.demowebapp.reposiroty;

import com.springboot.demowebapp.model.Author;
import org.springframework.data.repository.CrudRepository;

/**
 * @author Jaison Santos
 */
public interface AuthorRepository extends CrudRepository<Author, Long> {
}
