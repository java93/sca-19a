package kg.alatoo.springwebapp.domain.repositories;

import kg.alatoo.springwebapp.domain.Book;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.Repository;

import java.util.List;

public interface BookRepository extends CrudRepository<Book,Long> {
}
