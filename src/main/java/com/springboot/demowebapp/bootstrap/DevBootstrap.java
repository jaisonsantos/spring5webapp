package com.springboot.demowebapp.bootstrap;

import com.springboot.demowebapp.model.Author;
import com.springboot.demowebapp.model.Book;
import com.springboot.demowebapp.model.Publisher;
import com.springboot.demowebapp.reposiroty.AuthorRepository;
import com.springboot.demowebapp.reposiroty.BookRepository;
import com.springboot.demowebapp.reposiroty.PublisherRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

/**
 * @author Jaison Santos
 */
@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private AuthorRepository authorRepository;
    private BookRepository bookRepository;
    private PublisherRepository publisherRepository;

    public DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }

    private void initData(){

        Publisher publisher = new Publisher();
        publisher.setName("foo");
        publisherRepository.save(publisher);

        //Eric
        Author eric = new Author("Eric", "Evans");
        Book ddd = new Book("Domain Driven Design", "123", publisher);
        eric.add(ddd);
        ddd.add(eric);

        authorRepository.save(eric);
        bookRepository.save(ddd);

        //Rod
        Author rod = new Author("Rod", "Johnson");
        Book noEJB = new Book("J2EE Developement", "23444", publisher);
        rod.add(noEJB);

        authorRepository.save(rod);
        bookRepository.save(noEJB);

    }
}
