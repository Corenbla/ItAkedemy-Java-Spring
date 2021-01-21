package edu.itakademy.demo.controller;

import edu.itakademy.demo.entity.Library;
import edu.itakademy.demo.service.LibraryServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/api/library", produces = MediaType.APPLICATION_JSON_VALUE)
public class LibraryController {

    @Autowired
    private LibraryServiceInterface libraryServiceInterface;

    @GetMapping
    public List<Library> list() {
        return this.libraryServiceInterface.getAll();
    }
}
