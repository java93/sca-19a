package kg.alatoo.springwebapp.controllers;


import kg.alatoo.springwebapp.domain.Book;
import kg.alatoo.springwebapp.domain.repositories.AuthorRepository;
import kg.alatoo.springwebapp.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Objects;

@Controller
public class MainController {

    @Autowired
    private BookService bookService;
    @Autowired
    private AuthorRepository authorRepository;

    @GetMapping({"", "index"})
    public String home(Model model) {
        model.addAttribute("name", "Zhibek");
        return "home";
    }

    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }

    @GetMapping({"books", "books/{authorId}"})
    public String books(
            Model model,
            @ModelAttribute(name = "addedBook") Book addedBook,
            @PathVariable(required = false) Long authorId) throws NoSuchElementException {
        /*List<Book> books = new ArrayList<>();
        books.add(new Book("Database","85434354"));
        books.add(new Book("Spring","8435748464"));
        books.add(new Book("Com Network","54354358"));
        books.add(new Book("Thymeleaf","5434354354"));*/
        if (Objects.nonNull(authorId))
            model.addAttribute("author", authorRepository.findById(authorId).orElseThrow());

        model.addAttribute(
                "books",
                Objects.nonNull(authorId) ?
                        bookService.getAllBooksOfAuthorWithID(authorId)
                        : bookService.getAllBooks());
        model.addAttribute("newBook", new Book());
        model.addAttribute("addedBook", addedBook);
        return "books";
    }

    @GetMapping("authors/{bookId}")
    public String authors(@PathVariable(name = "bookId", required = false) Long bookId, Model model) {
        System.out.println(bookId);
        model.addAttribute("id", bookId);
        return "authors";
    }

    @PostMapping("addbook")
    public String addBook(@RequestBody MultiValueMap<String,String> requestBody,
            @ModelAttribute Book addedBook,
            RedirectAttributes redirectAttributes
            ) {

        System.out.println(requestBody);
        System.out.println("before save" + addedBook);
        addedBook = bookService.saveBook(addedBook);
        System.out.println("after save" + addedBook);
        redirectAttributes.addFlashAttribute("addedBook",addedBook);
        return "redirect:books";
    }
}
