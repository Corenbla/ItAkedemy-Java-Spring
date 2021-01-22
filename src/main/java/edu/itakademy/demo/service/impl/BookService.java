package edu.itakademy.demo.service.impl;

import edu.itakademy.demo.entity.Book;
import edu.itakademy.demo.entity.dto.BookDTO;
import edu.itakademy.demo.repository.BookRepositoryInterface;
import edu.itakademy.demo.service.BookServiceInterface;
import edu.itakademy.demo.service.MailServiceInterface;
import edu.itakademy.demo.service.MapperInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookService implements BookServiceInterface {

    @Autowired
    private MailServiceInterface mailServiceInterface;

    @Autowired
    private BookRepositoryInterface bookRepositoryInterface;

    @Autowired
    MapperInterface mapperInterface;

    @Override
    public Book getBook(Integer id) {

        return this.bookRepositoryInterface.findById(id).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND)
        );
    }

    @Override
    public BookDTO getBookDTO(Integer id) {
        Book book = this.getBook(id);

        return this.mapperInterface.bookToBookDto(book);
    }

    @Override
    public List<BookDTO> getByName(String name) {
        List<Book> books = this.bookRepositoryInterface.findAllByName(name);

        return this.mapperInterface.booksToBooksDTO(books);
    }

    @Override
    public List<BookDTO> getAll() {
        List<Book> books = this.bookRepositoryInterface.findAll();

        return this.mapperInterface.booksToBooksDTO(books);
    }

    @Override
    public void deleteBook(Integer id) {
        this.bookRepositoryInterface.deleteById(id);
    }

    @Override
    public BookDTO createBook(Book book) {
        book = this.bookRepositoryInterface.save(book);
//        this.mailServiceInterface.sendSimpleMessage(book);

        return this.mapperInterface.bookToBookDto(book);
    }

    @Override
    public BookDTO editBook(Integer bookId, BookDTO bookDTO) {
        Book book = this.mapperInterface.bookDTOToBook(bookDTO);
        this.bookRepositoryInterface.save(book);

        return bookDTO;
    }
}
