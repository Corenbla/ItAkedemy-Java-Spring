package edu.itakademy.demo.service.impl;

import edu.itakademy.demo.entity.Book;
import edu.itakademy.demo.entity.dto.BookDTO;
import edu.itakademy.demo.repository.BookRepositoryInterface;
import edu.itakademy.demo.service.BookServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class BookService implements BookServiceInterface {

    @Autowired
    private BookRepositoryInterface bookRepositoryInterface;

    @Override
    public Book getBook(Integer id) {
        return this.bookRepositoryInterface.findById(id).orElseThrow(
            ()-> new ResponseStatusException(HttpStatus.NOT_FOUND)
        );
    }

    @Override
    public List<Book> getByName(String name) {
        System.out.println("Foo!");
        System.out.println(name);
        System.out.println(this.bookRepositoryInterface.findAllByName(name));
        return this.bookRepositoryInterface.findAllByName(name);
    }

    @Override
    public List<Book> getAll() {
        return this.bookRepositoryInterface.findAll();
    }

    @Override
    public void deleteBook(Integer id) {
        this.bookRepositoryInterface.deleteById(id);
    }

    @Override
    public Book createBook(Book book) {
        this.bookRepositoryInterface.save(book);

        return book;
    }

    @Override
    public Book editBook(Integer bookId, BookDTO bookDTO) {
        Book book = this.mapToEntity(bookDTO, this.getBook(bookId));
        this.bookRepositoryInterface.save(book);

        return book;
    }

    private Book mapToEntity(BookDTO bookDTO, Book book) {
        if (bookDTO.getName() != null) {
            book.setName(bookDTO.getName());
        }

        return book;
    }
}
