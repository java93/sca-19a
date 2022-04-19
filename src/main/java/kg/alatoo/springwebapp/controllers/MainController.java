package kg.alatoo.springwebapp.controllers;

import kg.alatoo.springwebapp.domain.Book;
import kg.alatoo.springwebapp.repositories.BookRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

    private final BookRepository bookRepository;

    public MainController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    //    @RequestMapping(method = RequestMethod.GET)
    @GetMapping
    public String hello() {
        return "Hello World!";
    }

    @GetMapping("bye")
    public String goodBye() {
        return "Good Bye!";
    }

    @GetMapping("addbook")
    public String addBook() {
        Book databaseBook = new Book("Database", "125434754");
        System.out.println(databaseBook);
        bookRepository.save(databaseBook);
        System.out.println(databaseBook);

        return "Book added: " + databaseBook.toString();
    }
}
