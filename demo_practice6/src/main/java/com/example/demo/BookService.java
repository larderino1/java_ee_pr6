package com.example.demo;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BookService {

    private final EntityManager entityManager;

    public BookService(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Transactional
    public BookEntity createBook(String name, String author, String ISBN) {
        BookEntity book = new BookEntity();
        book.setName(name);
        book.setAuthor(author);
        book.setISBN(ISBN);

        return entityManager.merge(book);
    }


    @Transactional
    public List<BookEntity> findAllBooks() {
        return entityManager.createQuery("SELECT book FROM BookEntity book", BookEntity.class)
                .getResultList();
    }



    @Transactional
    public List<BookEntity> findBookWhereNameOrAuthorContains(String searchText) {
        return entityManager.createQuery("SELECT book FROM BookEntity book WHERE book.name LIKE :query OR book.author LIKE :query", BookEntity.class)
                .setParameter("query", '%' + searchText + '%')
                .getResultList();
    }

    public List<BookEntity> findByAuthor(String author) {
        return entityManager.createNamedQuery(BookEntity.FIND_BY_AUTHOR, BookEntity.class)
                .setParameter("author", author)
                .getResultList();
    }

    public BookEntity findByISBN(String ISBN){
        return entityManager.createNamedQuery(BookEntity.FIND_BY_ISBN, BookEntity.class)
                .setParameter("ISBN", ISBN)
                .getSingleResult();
    }

    public BookEntity findByName(String name){
        return entityManager.createNamedQuery(BookEntity.FIND_BY_NAME, BookEntity.class)
                .setParameter("name", name)
                .getSingleResult();
    }

}
