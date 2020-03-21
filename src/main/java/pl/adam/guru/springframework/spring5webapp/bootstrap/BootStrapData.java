package pl.adam.guru.springframework.spring5webapp.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import pl.adam.guru.springframework.spring5webapp.domain.Author;
import pl.adam.guru.springframework.spring5webapp.domain.Book;
import pl.adam.guru.springframework.spring5webapp.domain.Publisher;
import pl.adam.guru.springframework.spring5webapp.repositories.AuthorRepository;
import pl.adam.guru.springframework.spring5webapp.repositories.BookRepository;
import pl.adam.guru.springframework.spring5webapp.repositories.PublisherRepository;

/**
 * Created by aslazinski on 2020-03-14.
 */
@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;


    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... strings) throws Exception {

        Publisher publisher = new Publisher();
        publisher.setName("SFG Publishing");
        publisher.setCity("St Petersburg");
        publisher.setState("FL");

        publisherRepository.save(publisher);

        Author eric = new Author("Eric", "Evans");
        Book ddd = new Book ("Domain Driver Dessign","123123");
        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);

        ddd.setPublisher(publisher);
        publisher.getBooks().add(ddd);

        authorRepository.save(eric);
        bookRepository.save(ddd);

        publisherRepository.save(publisher);

        Author rod = new Author("Rod","Johnson");
        Book noEJB = new Book("J2EE Developmentwithout EJB","39393939339");
        rod.getBooks().add(noEJB);
        noEJB.getAuthors().add(rod);

        publisher.getBooks().add(noEJB);
        noEJB.setPublisher(publisher);

        authorRepository.save(rod);
        bookRepository.save(noEJB);
        publisherRepository.save(publisher);

        System.out.println("Started in Bootstrap");
        System.out.println("Number of Books: " +bookRepository.count());
        System.out.println("Number of Publisher: " +publisherRepository.count());
        System.out.println("Number of books belong to publisher: " +publisher.getBooks().size());

    }
}
