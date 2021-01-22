package edu.itakademy.demo.service;

import edu.itakademy.demo.entity.Book;
import edu.itakademy.demo.entity.dto.BookDTO;

import java.util.List;

public interface BookServiceInterface {

    Book getBook(Integer id);

    BookDTO getBookDTO(Integer id);

    List<BookDTO> getByName(String name);

    List<BookDTO> getAll();

    void deleteBook(Integer id);

    BookDTO createBook(Book book);

    BookDTO editBook(Integer BookId, BookDTO book);
}
