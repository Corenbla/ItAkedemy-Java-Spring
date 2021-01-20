package edu.itakademy.demo.repository.impl;

import edu.itakademy.demo.entity.Book;
import edu.itakademy.demo.repository.BookRepositoryInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class BookRepository implements BookRepositoryInterface {

    @Autowired
    private EntityManager em;

    @Override
    public Book getBookById(Integer id) {
        return this.em.find(Book.class, id);
    }

    @Override
    public List<Book> getAll() {
        return this.em.createQuery("SELECT e FROM Book e", Book.class).getResultList();
    }
}
