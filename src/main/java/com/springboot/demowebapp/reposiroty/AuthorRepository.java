package com.springboot.demowebapp.reposiroty;

import com.springboot.demowebapp.model.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Long> {
}
