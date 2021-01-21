package edu.itakademy.demo.service;

import edu.itakademy.demo.entity.Author;
import edu.itakademy.demo.entity.dto.AuthorDTO;

import java.util.List;

public interface AuthorServiceInterface {

    List<Author> getAll();

    Author getAuthor(Integer id);

    void deleteAuthor(Integer id);

    Author createAuthor(Author author);

    Author editAuthor(Integer id, AuthorDTO authorDTO);
}
