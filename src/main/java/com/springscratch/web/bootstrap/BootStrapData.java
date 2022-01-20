package com.springscratch.web.bootstrap;

import com.springscratch.web.model.Author;
import com.springscratch.web.model.Book;
import com.springscratch.web.model.Publisher;
import com.springscratch.web.repositories.AuthorRepository;
import com.springscratch.web.repositories.BookRepository;
import com.springscratch.web.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

//initializing spring with data
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
    public void run(String... args) throws Exception {
        Publisher publisher = new Publisher();
        publisher.setName("SFG Publishing");
        publisher.setCity("St Petersburg");
        publisher.setState("FL");
        publisherRepository.save(publisher);
        System.out.println(publisherRepository.count());

        //add first author,book and publisher details
        Author a1=new Author("Eric","Evans");
        Book b1= new Book("Programming with C","12345");
        a1.getBooks().add(b1);
        b1.getAuthors().add(a1);
        b1.setPublisher(publisher);
        publisher.getBooks().add(b1);
        authorRepository.save(a1);
        bookRepository.save(b1);
        publisherRepository.save(publisher);

        //add second author,book and publisher details
        Author a2=new Author("Rod","Jhonson");
        Book b2=new Book("J2EE Development","3456789");
        a2.getBooks().add(b2);
        b2.getAuthors().add(a1);
        b2.setPublisher(publisher);
        publisher.getBooks().add(b2);

        authorRepository.save(a2);
        bookRepository.save(b2);
        publisherRepository.save(publisher);

        System.out.println("Started in Bootstrap");
        System.out.println("Numbers of book: "+bookRepository.count());
    }
}
