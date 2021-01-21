package edu.itakademy.demo.repository;

import edu.itakademy.demo.entity.Library;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LibraryRepositoryInterface extends JpaRepository<Library, Integer> {
}
