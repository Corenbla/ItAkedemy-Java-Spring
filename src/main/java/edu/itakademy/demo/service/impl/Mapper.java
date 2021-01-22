package edu.itakademy.demo.service.impl;

import edu.itakademy.demo.entity.Book;
import edu.itakademy.demo.entity.Library;
import edu.itakademy.demo.entity.dto.BookDTO;
import edu.itakademy.demo.entity.dto.LibraryDTO;
import edu.itakademy.demo.service.BookServiceInterface;
import edu.itakademy.demo.service.LibraryServiceInterface;
import edu.itakademy.demo.service.MapperInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class Mapper implements MapperInterface {
    @Autowired
    BookServiceInterface bookServiceInterface;

    @Autowired
    LibraryServiceInterface libraryServiceInterface;

    @Override
    public BookDTO bookToBookDto(Book book) {
        if (book == null) {
            return null;
        }

        BookDTO bookDTO = new BookDTO();
        bookDTO.setId((book.getId() != null) ? book.getId() : -1);
        bookDTO.setName(book.getName());
        bookDTO.setLibrary(this.libraryToLibraryDTO(book.getLibrary()));

        return bookDTO;
    }

    @Override
    public Book bookDTOToBook(BookDTO bookDTO) {
        Book book = this.bookServiceInterface.getBook(bookDTO.getId());

        if (bookDTO.getName() != null) {
            book.setName(bookDTO.getName());
        }

        if (bookDTO.getLibrary() != null) {
            book.setLibrary(this.libraryDTOToLibrary(bookDTO.getLibrary()));
        }

        return book;
    }

    @Override
    public List<BookDTO> booksToBooksDTO(List<Book> books) {
        List<BookDTO> bookDTOs = new ArrayList<>();

        for (Book book: books) {
            bookDTOs.add(this.bookToBookDto(book));
        }
        return bookDTOs;
    }

    @Override
    public Set<BookDTO> booksToBooksDTO(Set<Book> books) {
        Set<BookDTO> bookDTOs = new HashSet<>();

        for (Book book: books) {
            bookDTOs.add(this.bookToBookDto(book));
        }
        return bookDTOs;
    }

    @Override
    public LibraryDTO libraryToLibraryDTO(Library library) {
        if (library == null) {
            return null;
        }

        LibraryDTO libraryDTO = new LibraryDTO();
        libraryDTO.setId((library.getId() != null) ? library.getId() : -1);
        libraryDTO.setName(library.getName());
        libraryDTO.setBooks(this.booksToBooksDTO(library.getBooks()));

        return libraryDTO;
    }

    @Override
    public Library libraryDTOToLibrary(LibraryDTO libraryDTO) {
        Library library = this.libraryServiceInterface.getLibrary(libraryDTO.getId());

        if (libraryDTO.getName() != null) {
            library.setName(libraryDTO.getName());
        }

        if (libraryDTO.getBooks() != null) {
            library.setBooks(library.getBooks());
        }

        return library;
    }

    @Override
    public List<LibraryDTO> librariesToLibrariesDTO(List<Library> libraries) {
        List<LibraryDTO> libraryDTOs = new ArrayList<>();

        for (Library library: libraries) {
            libraryDTOs.add(this.libraryToLibraryDTO(library));
        }

        return libraryDTOs;
    }
}
