package com.springboot.demowebapp.reposiroty;

import com.springboot.demowebapp.model.Publisher;
import org.springframework.data.repository.CrudRepository;

/**
 * @author Jaison Santos
 */
public interface PublisherRepository extends CrudRepository<Publisher, Long> {
}
