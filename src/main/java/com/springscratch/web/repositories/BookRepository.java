package com.springscratch.web.repositories;

import com.springscratch.web.model.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book,Long>{
}
