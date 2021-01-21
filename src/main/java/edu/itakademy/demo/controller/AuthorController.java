package edu.itakademy.demo.controller;

import edu.itakademy.demo.entity.Author;
import edu.itakademy.demo.entity.dto.AuthorDTO;
import edu.itakademy.demo.service.AuthorServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/author", produces = MediaType.APPLICATION_JSON_VALUE)
public class AuthorController {

    @Autowired
    private AuthorServiceInterface authorServiceInterface;

    @GetMapping
    public List<Author> list() {
        return this.authorServiceInterface.getAll();
    }

    @GetMapping("/{id}")
    public Author get(@PathVariable Integer id) {
        return this.authorServiceInterface.getAuthor(id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Integer id) {
        this.authorServiceInterface.deleteAuthor(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Author create(@RequestBody Author author) {

        return this.authorServiceInterface.createAuthor(author);
    }

    @PutMapping("/{id}")
    public Author edit(@PathVariable Integer id, @RequestBody AuthorDTO authorDTO) {
        return this.authorServiceInterface.editAuthor(id, authorDTO);
    }
}
