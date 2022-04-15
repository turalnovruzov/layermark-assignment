package com.turalnovruzov.layermarkassignment.book;

import com.turalnovruzov.layermarkassignment.author.Author;
import com.turalnovruzov.layermarkassignment.author.AuthorService;
import com.turalnovruzov.layermarkassignment.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private AuthorService authorService;

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    public Book createBook(@Valid BookRequest bookRequest) throws ResourceNotFoundException {
        // Get the books author
        Author author = authorService.getAuthorById(bookRequest.getAuthorId());

        // Create the new book
        Book book = new Book(
                bookRequest.getName(),
                bookRequest.getIsbn(),
                author
        );

        // Save the book
        return bookRepository.save(book);
    }

    public void deleteBookById(UUID id) {
        bookRepository.deleteById(id);
    }

    public Book getBookById(UUID id) throws ResourceNotFoundException {
        return bookRepository.findById(id).orElseThrow(ResourceNotFoundException::new);
    }

    public Book updateBook(UUID id, @Valid BookRequest bookRequest) throws ResourceNotFoundException {
        // Get the books author
        Author author = authorService.getAuthorById(bookRequest.getAuthorId());

        // Get the book with the given id
        Book book = getBookById(id);

        // Update the book
        book.setName(bookRequest.getName());
        book.setIsbn(bookRequest.getIsbn());
        book.setAuthor(author);

        // Save the book
        return bookRepository.save(book);
    }
}
