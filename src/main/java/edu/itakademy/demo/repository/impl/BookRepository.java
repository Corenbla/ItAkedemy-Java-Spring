package edu.itakademy.demo.repository.impl;

import edu.itakademy.demo.entity.Book;
import edu.itakademy.demo.repository.BookRepositoryInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
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

    @Override
    @Transactional
    public void deleteBook(Integer id) {
        Book book = this.em.find(Book.class, id);
        this.em.remove(book);
    }

    @Override
    @Transactional
    public void saveBook(Book book) {
        this.em.persist(book);
    }

    @Override
    @Transactional
    public void editBook(Book book) {
        em.merge(book);
    }
}
