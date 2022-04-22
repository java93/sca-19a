package kg.alatoo.springwebapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class MainController {

    @GetMapping({"","index"})
    public String home(Model model) {
        model.addAttribute("name", "Zhibek");
        return "home";
    }
    @GetMapping("books")
    public String books(Model model) {
        List<String> books = new ArrayList<>();
        books.add("Database");
        books.add("Spring");
        books.add("Com Network");
        books.add("Thymeleaf");
        model.addAttribute("books",books);
        return "books";
    }
}
