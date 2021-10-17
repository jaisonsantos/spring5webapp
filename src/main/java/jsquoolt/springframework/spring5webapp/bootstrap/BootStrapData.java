package jsquoolt.springframework.spring5webapp.bootstrap;

import jsquoolt.springframework.spring5webapp.domain.Author;
import jsquoolt.springframework.spring5webapp.domain.Book;
import jsquoolt.springframework.spring5webapp.domain.Publisher;
import jsquoolt.springframework.spring5webapp.repositories.AuthorRepository;
import jsquoolt.springframework.spring5webapp.repositories.BookRepository;
import jsquoolt.springframework.spring5webapp.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootStrapData(AuthorRepository authorRepository, 
                         BookRepository bookRepository, 
                         PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        System.out.println("Started in Bootstrap");
        
        Publisher publisher = new Publisher();
        publisher.setName("JS Publishing");
        publisher.setCity("Barcelona");
        publisher.setState("Barcelona");
        
        publisherRepository.save(publisher);

        System.out.println("Publisher count: " + publisherRepository.count());
        
        Book ddd = new Book("Driven Domain Design", "123123");
        Author eric = new Author("Eric", "Evans");
        
        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);
        
        ddd.setPublisher(publisher);
        publisher.getBooks().add(ddd);
        
        authorRepository.save(eric);
        bookRepository.save(ddd);
        publisherRepository.save(publisher);
        
        Author rod = new Author("Rod", "Johnson");
        Book noEJB = new Book("J2EE Development without EJB", "3939459459");
        
        rod.getBooks().add(noEJB);
        noEJB.getAuthors().add(rod);
        
        noEJB.setPublisher(publisher);
        publisher.getBooks().add(noEJB);
        
        authorRepository.save(rod);
        bookRepository.save(noEJB);
        publisherRepository.save(publisher);
        
        System.out.println("Started in Bootstrap");
        System.out.println("Number of Books: " + bookRepository.count());
        System.out.println("Publisher Number of Books: " + publisher.getBooks().size());
        
    }
}
