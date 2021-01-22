package edu.itakademy.demo.service.impl;

import edu.itakademy.demo.entity.Library;
import edu.itakademy.demo.entity.dto.LibraryDTO;
import edu.itakademy.demo.repository.LibraryRepositoryInterface;
import edu.itakademy.demo.service.LibraryServiceInterface;
import edu.itakademy.demo.service.MapperInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class LibraryService implements LibraryServiceInterface {
    @Autowired
    LibraryRepositoryInterface libraryRepositoryInterface;

    @Autowired
    MapperInterface mapperInterface;

    @Override
    public List<Library> getAll() {
        return this.libraryRepositoryInterface.findAll();
    }

    @Override
    public Library getLibrary(Integer id) {
        return this.libraryRepositoryInterface.findById(id).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND)
        );
    }

    @Override
    public LibraryDTO getLibraryDTO(Integer id) {
        Library library = this.getLibrary(id);

        return this.mapperInterface.libraryToLibraryDTO(library);
    }

    @Override
    public List<Library> getByName(String name) {

        return this.libraryRepositoryInterface.getByName(name);
    }

    @Override
    public void deleteLibrary(Integer id) {
        try {
            this.libraryRepositoryInterface.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public Library createLibrary(Library library) {
        return this.libraryRepositoryInterface.save(library);
    }

    @Override
    public Library editLibrary(Integer id, LibraryDTO libraryDTO) {
        Library library = this.mapperInterface.libraryDTOToLibrary(libraryDTO);
        this.libraryRepositoryInterface.save(library);

        return library;
    }
}
