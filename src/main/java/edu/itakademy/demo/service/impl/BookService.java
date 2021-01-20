package edu.itakademy.demo.service.impl;

import edu.itakademy.demo.entity.Book;
import edu.itakademy.demo.repository.BookRepositoryInterface;
import edu.itakademy.demo.service.BookServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService implements BookServiceInterface {

    @Autowired
    private BookRepositoryInterface bookRepositoryInterface;

    @Override
    public Book getBook(Integer id) {
        return this.bookRepositoryInterface.getBookById(id);
    }

    @Override
    public List<Book> getAll() {
        return this.bookRepositoryInterface.getAll();
    }
}
