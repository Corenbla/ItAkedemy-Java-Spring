package edu.itakademy.demo.service;

import edu.itakademy.demo.entity.Book;

import java.util.List;

public interface BookServiceInterface {

    Book getBook(Integer id);
    List<Book> getAll();
}
