package com.springboot.demowebapp.bootstrap;

import com.springboot.demowebapp.model.Author;
import com.springboot.demowebapp.model.Book;
import com.springboot.demowebapp.reposiroty.AuthorRepository;
import com.springboot.demowebapp.reposiroty.BookRepository;
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

    public DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }

    private void initData(){

        //Eric
        Author eric = new Author("Eric", "Evans");
        Book ddd = new Book("Domain Driven Design", "123", "Harper Colins");
        eric.add(ddd);
        ddd.add(eric);

        authorRepository.save(eric);
        bookRepository.save(ddd);

        //Rod
        Author rod = new Author("Rod", "Johnson");
        Book noEJB = new Book("J2EE Developement", "23444", "Worx");
        rod.add(noEJB);

        authorRepository.save(rod);
        bookRepository.save(noEJB);

    }
}
