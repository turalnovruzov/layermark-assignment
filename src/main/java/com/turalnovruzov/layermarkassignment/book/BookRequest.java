package com.turalnovruzov.layermarkassignment.book;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.UUID;

public class BookRequest {

    @NotBlank
    private String name;

    @NotBlank
    @Length(min = 17, max = 17)
    private String isbn;

    @NotNull
    private UUID authorId;

    public BookRequest(String name, String isbn, UUID authorId) {
        this.name = name;
        this.isbn = isbn;
        this.authorId = authorId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public UUID getAuthorId() {
        return authorId;
    }

    public void setAuthorId(UUID authorId) {
        this.authorId = authorId;
    }
}
