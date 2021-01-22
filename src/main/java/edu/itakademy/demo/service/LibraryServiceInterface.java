package edu.itakademy.demo.service;

import edu.itakademy.demo.entity.Library;
import edu.itakademy.demo.entity.dto.LibraryDTO;

import java.util.List;

public interface LibraryServiceInterface {

    List<LibraryDTO> getAll();

    Library getLibrary(Integer id);

    LibraryDTO getLibraryDTO(Integer id);

    List<LibraryDTO> getByName(String name);

    void deleteLibrary(Integer id);

    LibraryDTO createLibrary(Library library);

    LibraryDTO editLibrary(Integer id, LibraryDTO libraryDTO);
}
