package edu.itakademy.demo.controller;

import edu.itakademy.demo.entity.Book;
import edu.itakademy.demo.service.BookServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping(value = "/book")
public class BookController {

    @Autowired
    private BookServiceInterface bookServiceInterface;

    @GetMapping
    public String list(Model model) {

        List<Book> books = this.bookServiceInterface.getAll();
        model.addAttribute("books", books);

        return "book/list";
    }
}
