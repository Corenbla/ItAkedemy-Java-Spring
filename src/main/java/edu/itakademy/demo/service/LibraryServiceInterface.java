package edu.itakademy.demo.service;

import edu.itakademy.demo.entity.Library;
import edu.itakademy.demo.repository.LibraryRepositoryInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LibraryServiceInterface {

    @Autowired
    LibraryRepositoryInterface libraryRepositoryInterface;

    public List<Library> getAll() {
        return this.libraryRepositoryInterface.findAll();
    }
}
