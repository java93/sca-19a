package kg.alatoo.springwebapp.domain.repositories;

import kg.alatoo.springwebapp.domain.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author,Long> {
}
