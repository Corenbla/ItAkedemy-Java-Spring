package edu.itakademy.demo.service;

import edu.itakademy.demo.entity.Book;
import edu.itakademy.demo.entity.dto.BookDTO;

import java.util.List;

public interface BookServiceInterface {

    Book getBook(Integer id);

    List<Book> getByName(String name);

    List<Book> getAll();

    void deleteBook(Integer id);

    Book createBook(Book book);

    Book editBook(Integer BookId, BookDTO book);
}
