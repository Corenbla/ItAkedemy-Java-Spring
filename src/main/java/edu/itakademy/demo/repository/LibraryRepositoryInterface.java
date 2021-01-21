package edu.itakademy.demo.repository;

import edu.itakademy.demo.entity.Library;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface LibraryRepositoryInterface extends JpaRepository<Library, Integer> {

    @Query("select u from Library u where u.name like %?1%")
    List<Library> getByName(String name);
}
