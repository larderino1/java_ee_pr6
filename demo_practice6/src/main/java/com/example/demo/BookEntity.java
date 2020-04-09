package com.example.demo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.*;
import org.hibernate.annotations.NamedQueries;
import org.hibernate.annotations.NamedQuery;

@Entity
@Table(name = "users")
@NoArgsConstructor
@Getter
@Setter
@ToString
@NamedQueries({
        @NamedQuery(query = "SELECT book FROM BookEntity book WHERE book.author = :author", name = BookEntity.FIND_BY_AUTHOR),
        @NamedQuery(query = "SELECT book FROM BookEntity book WHERE book.ISBN = :ISBN", name = BookEntity.FIND_BY_ISBN),
        @NamedQuery(query = "SELECT book FROM BookEntity book WHERE book.name = :name", name = BookEntity.FIND_BY_NAME)
})
public class BookEntity {

    public static final String FIND_BY_AUTHOR = "BookEntity.FIND_BY_AUTHOR";
    public static final String FIND_BY_ISBN = "BookEntity.FIND_BY_ISBN";
    public static final String FIND_BY_NAME = "BookEntity.FIND_BY_NAME";

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "book_name")
    private String name;

    @Column(name = "author")
    private String author;
    @Column(name = "ISBN")
    private String ISBN;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }
}
