package edu.itakademy.demo.repository;

import edu.itakademy.demo.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepositoryInterface extends JpaRepository<Author, Integer> {
}
