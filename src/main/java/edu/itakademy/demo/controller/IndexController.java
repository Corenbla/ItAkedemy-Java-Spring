package edu.itakademy.demo.controller;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController implements ErrorController {

    private static final String PATH = "/error";

    @RequestMapping(value = "/error")
    public String error(Model model) {
        return "error";
    }

    @Override
    public String getErrorPath() {
        return PATH;
    }
}
