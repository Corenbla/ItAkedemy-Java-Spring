package edu.itakademy.demo.service.impl;

import edu.itakademy.demo.entity.Author;
import edu.itakademy.demo.entity.dto.AuthorDTO;
import edu.itakademy.demo.repository.AuthorRepositoryInterface;
import edu.itakademy.demo.service.AuthorServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class AuthorService implements AuthorServiceInterface {
    @Autowired
    private AuthorRepositoryInterface authorRepositoryInterface;

    @Override
    public List<Author> getAll() {
        return this.authorRepositoryInterface.findAll();
    }

    @Override
    public Author getAuthor(Integer id) {
        return this.authorRepositoryInterface.findById(id).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND)
        );
    }

    @Override
    public void deleteAuthor(Integer id) {
        try {
            this.authorRepositoryInterface.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public Author createAuthor(Author author) {
        return this.authorRepositoryInterface.save(author);
    }

    @Override
    public Author editAuthor(Integer id, AuthorDTO authorDTO) {
        Author author = this.mapToEntity(authorDTO, this.getAuthor(id));
        this.authorRepositoryInterface.save(author);

        return author;
    }

    private Author mapToEntity(AuthorDTO authorDTO, Author author) {
        if (authorDTO.getFirstName() != null) {
            author.setFirstName(authorDTO.getFirstName());
        }

        if (authorDTO.getLastName() != null) {
            author.setLastName(authorDTO.getFirstName());
        }

        return author;
    }
}
