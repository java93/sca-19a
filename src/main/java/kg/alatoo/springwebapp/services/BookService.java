package kg.alatoo.springwebapp.services;

import kg.alatoo.springwebapp.domain.Book;
import kg.alatoo.springwebapp.domain.repositories.AuthorRepository;
import kg.alatoo.springwebapp.domain.repositories.BookRepository;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.Set;

@Service
public class BookService {

    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;

    public BookService(BookRepository bookRepository, AuthorRepository authorRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
    }

    public Set<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    public Set<Book> getAllBooksOfAuthorWithID(Long id) throws NoSuchElementException {
        return authorRepository
                .findById(id)
                .orElseThrow()
                .getBooks();
    }


    public Book saveBook(Book book) {
        return bookRepository.save(book);
    }
}
