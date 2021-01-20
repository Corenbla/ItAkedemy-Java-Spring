package edu.itakademy.demo.repository;

import edu.itakademy.demo.entity.Book;

import java.util.List;

public interface BookRepositoryInterface {

    public Book getBookById(Integer id);

    public List<Book> getAll();

    void deleteBook(Integer id);

    void saveBook(Book name);

    void editBook(Book book);
}
