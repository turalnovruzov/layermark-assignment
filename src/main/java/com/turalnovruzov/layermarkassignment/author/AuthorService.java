package com.turalnovruzov.layermarkassignment.author;

import com.turalnovruzov.layermarkassignment.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class AuthorService {

    @Autowired
    private AuthorRepository authorRepository;

    public List<Author> getAllAuthors() {
        return authorRepository.findAll();
    }

    public Author getAuthorById(UUID id) throws ResourceNotFoundException {
        return authorRepository.findById(id).orElseThrow(ResourceNotFoundException::new);
    }

    public Author createAuthor(Author author) {
        return authorRepository.save(author);
    }
}
