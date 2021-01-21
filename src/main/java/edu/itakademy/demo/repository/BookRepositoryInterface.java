package edu.itakademy.demo.repository;

import edu.itakademy.demo.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BookRepositoryInterface extends JpaRepository<Book, Integer> {

    @Query("select u from Book u where u.name like %?1%")
    List<Book> findAllByName(String name);
}
