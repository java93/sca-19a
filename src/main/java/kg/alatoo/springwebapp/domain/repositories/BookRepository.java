package kg.alatoo.springwebapp.domain.repositories;

import kg.alatoo.springwebapp.domain.Book;
import org.springframework.data.repository.CrudRepository;

import java.util.Set;

public interface BookRepository extends CrudRepository<Book,Long> {
    Set<Book> findAll();
}
