package com.turalnovruzov.layermarkassignment.author;

import com.turalnovruzov.layermarkassignment.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
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

    public Author createAuthor(@Valid AuthorRequest authorRequest) {
        // Create the author
        Author author = new Author(
                authorRequest.getName(),
                authorRequest.getAge()
        );

        // Save the author
        return authorRepository.save(author);
    }

    public Author updateAuthor(UUID id, @Valid AuthorRequest newAuthor) throws ResourceNotFoundException {
        // Get the author with the given id
        Author author = getAuthorById(id);

        // Update the author
        author.setName(newAuthor.getName());
        author.setAge(newAuthor.getAge());

        // Save the author
        return authorRepository.save(author);
    }

    public void deleteAuthorById(UUID id) {
        authorRepository.deleteById(id);
    }
}
