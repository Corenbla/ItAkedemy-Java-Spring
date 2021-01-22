package edu.itakademy.demo.controller;

import edu.itakademy.demo.entity.Library;
import edu.itakademy.demo.entity.dto.LibraryDTO;
import edu.itakademy.demo.service.LibraryServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/library", produces = MediaType.APPLICATION_JSON_VALUE)
public class LibraryController {

    @Autowired
    private LibraryServiceInterface libraryServiceInterface;

    @GetMapping
    public List<LibraryDTO> list() {
        return this.libraryServiceInterface.getAll();
    }

    @GetMapping("/{id}")
    public LibraryDTO get(@PathVariable Integer id) {
        return this.libraryServiceInterface.getLibraryDTO(id);
    }

    @GetMapping("/byName/{name}")
    public List<LibraryDTO> getByName(@PathVariable String name) {
        return this.libraryServiceInterface.getByName(name);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Integer id) {
        this.libraryServiceInterface.deleteLibrary(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public LibraryDTO create(@RequestBody Library library) {

        return this.libraryServiceInterface.createLibrary(library);
    }

    @PutMapping("/{id}")
    public LibraryDTO edit(@PathVariable Integer id, @RequestBody LibraryDTO libraryDTO) {
        return this.libraryServiceInterface.editLibrary(id, libraryDTO);
    }
}
