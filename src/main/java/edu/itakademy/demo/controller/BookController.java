package edu.itakademy.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/book")
public class BookController {

    @GetMapping
    public String list(Model model) {
        model.addAttribute("key", "value");

        return "book/list";
    }
}
