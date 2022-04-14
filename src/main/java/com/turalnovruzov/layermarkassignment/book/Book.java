package com.turalnovruzov.layermarkassignment.book;

import com.turalnovruzov.layermarkassignment.author.Author;
import org.hibernate.Hibernate;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "book")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false, insertable = false, updatable = false)
    private UUID id;

    @NotNull
    @Column(name = "name", nullable = false, columnDefinition = "TEXT")
    private String name;

    @Length(min = 17, max = 17)
    @Column(name = "isbn", nullable = false, length = 17)
    private String isbn;

    @NotNull
    @ManyToOne(optional = false)
    @JoinColumn(name = "author_id", nullable = false)
    private Author author;

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public UUID getId() {
        return id;
    }

    public void updateWithBook(Book newBook) {
        this.setIsbn(newBook.getIsbn());
        this.setName(newBook.getName());
        this.setAuthor(newBook.getAuthor());
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "name = " + name + ", " +
                "isbn = " + isbn + ", " +
                "author = " + author + ")";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Book book = (Book) o;
        return id != null && Objects.equals(id, book.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}