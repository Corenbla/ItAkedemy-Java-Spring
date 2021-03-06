package edu.itakademy.demo.controller;

import edu.itakademy.demo.entity.Book;
import edu.itakademy.demo.entity.dto.BookDTO;
import edu.itakademy.demo.service.BookServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/book", produces = MediaType.APPLICATION_JSON_VALUE)
public class BookController {

    @Autowired
    private BookServiceInterface bookServiceInterface;

    @GetMapping
    public List<BookDTO> list() {
        return this.bookServiceInterface.getAll();
    }

    @GetMapping("/{id}")
    public BookDTO get(@PathVariable Integer id) {
        return this.bookServiceInterface.getBookDTO(id);
    }

    @GetMapping("/byName/{name}")
    public List<BookDTO> getByName(@PathVariable String name) {
        return this.bookServiceInterface.getByName(name);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Integer id) {
        this.bookServiceInterface.deleteBook(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public BookDTO create(@RequestBody Book book) {

        return this.bookServiceInterface.createBook(book);
    }

    @PutMapping("/{id}")
    public BookDTO edit(@PathVariable Integer id, @RequestBody BookDTO bookDTO) {
        return this.bookServiceInterface.editBook(id, bookDTO);
    }
}
