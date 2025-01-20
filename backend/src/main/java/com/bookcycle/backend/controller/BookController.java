package com.bookcycle.backend.controller;

import com.bookcycle.backend.dto.BookDTO;
import com.bookcycle.backend.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
