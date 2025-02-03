package com.bookcycle.backend.controller;

import com.bookcycle.backend.dto.BookDTO;
import com.bookcycle.backend.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/books")
public class BookController {

    @Autowired
    private BookService bookService;

    public ResponseEntity<List<BookDTO>> findAll(){
        List<BookDTO> list = bookService.findAllBooks();
        return ResponseEntity.ok(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<BookDTO> findById(@PathVariable Long id){
        BookDTO dto = bookService.findBookById(id);
        return ResponseEntity.ok(dto);
    }

    @PostMapping(value = "/{id}")
    public ResponseEntity<BookDTO> insertBook (BookDTO bookDTO){
        BookDTO dto = bookService.createBook(bookDTO);
        return ResponseEntity.ok(dto);
    }

    @PutMapping
    public ResponseEntity<BookDTO> editBook(@PathVariable Long id, BookDTO bookDTO){
        BookDTO dto = bookService.updateBook(id, bookDTO);
        return ResponseEntity.ok(dto);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<BookDTO> deleteBook(@PathVariable Long id){
        bookService.deleteBook(id);
        return ResponseEntity.noContent().build();
    }
}
