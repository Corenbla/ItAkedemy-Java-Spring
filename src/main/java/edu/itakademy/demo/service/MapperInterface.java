package edu.itakademy.demo.service;

import edu.itakademy.demo.entity.Book;
import edu.itakademy.demo.entity.Library;
import edu.itakademy.demo.entity.dto.BookDTO;
import edu.itakademy.demo.entity.dto.LibraryDTO;

import java.util.List;
import java.util.Set;

public interface MapperInterface {
    BookDTO bookToBookDto(Book book);
    Book bookDTOToBook(BookDTO bookDTO);
    List<BookDTO> booksToBooksDTO(List<Book> books);
    Set<BookDTO> booksToBooksDTO(Set<Book> books);

    LibraryDTO libraryToLibraryDTO(Library library);
    Library libraryDTOToLibrary(LibraryDTO libraryDTO);
    List<LibraryDTO> librariesToLibrariesDTO(List<Library> libraries);
}
