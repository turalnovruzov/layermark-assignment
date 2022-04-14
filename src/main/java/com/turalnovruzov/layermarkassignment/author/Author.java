package com.turalnovruzov.layermarkassignment.author;

import com.turalnovruzov.layermarkassignment.book.Book;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "author")
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false, insertable = false, updatable = false)
    private UUID id;

    @NotNull
    @Column(name = "name", nullable = false, columnDefinition = "TEXT")
    private String name;

    @Positive
    @NotNull
    @Column(name = "age", nullable = false)
    private Integer age;

    @OneToMany(mappedBy = "author", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Book> books = new ArrayList<>();

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
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

    /**
     * Updates author's name and age with the newAuthor's.
     */
    public void updateWithAuthor(Author newAuthor) {
        if (newAuthor.getAge() != null) { this.setAge(newAuthor.getAge()); }
        if (newAuthor.getName() != null) { this.setName(newAuthor.getName()); }
    }

}