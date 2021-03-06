package com.turalnovruzov.layermarkassignment.book;

import com.turalnovruzov.layermarkassignment.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RequestMapping("/books")
@RestController
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping
    public List<Book> getAllBooks() {
        return bookService.getAllBooks();
    }

    @GetMapping("/{id}")
    public Book getBookById(@PathVariable UUID id) throws ResourceNotFoundException {
        return bookService.getBookById(id);
    }

    @PostMapping
    public Book createBook(@Valid @RequestBody BookRequest bookRequest) throws ResourceNotFoundException {
        return bookService.createBook(bookRequest);
    }

    @PutMapping("/{id}")
    public Book updateBook(@PathVariable UUID id, @Valid @RequestBody BookRequest bookRequest) throws ResourceNotFoundException {
        return bookService.updateBook(id, bookRequest);
    }

    @DeleteMapping("/{id}")
    public void deleteBookById(@PathVariable UUID id) {
        bookService.deleteBookById(id);
    }
}
