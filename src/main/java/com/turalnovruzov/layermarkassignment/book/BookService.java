package com.turalnovruzov.layermarkassignment.book;

import com.turalnovruzov.layermarkassignment.author.Author;
import com.turalnovruzov.layermarkassignment.author.AuthorService;
import com.turalnovruzov.layermarkassignment.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    public Book createBook(Book book) throws ResourceNotFoundException {
        Author author = authorService.getAuthorById(book.getAuthor().getId());
        book.setAuthor(author);
        return bookRepository.save(book);
    }

    public void deleteBookById(UUID id) {
        bookRepository.deleteById(id);
    }

    public Book getBookById(UUID id) throws ResourceNotFoundException {
        return bookRepository.findById(id).orElseThrow(ResourceNotFoundException::new);
    }

    public Book updateBook(UUID id, Book newBook) throws ResourceNotFoundException {
        Author author = authorService.getAuthorById(newBook.getAuthor().getId());
        newBook.setAuthor(author);

        Book book = getBookById(id);
        book.updateWithBook(newBook);

        return bookRepository.save(book);
    }
}
