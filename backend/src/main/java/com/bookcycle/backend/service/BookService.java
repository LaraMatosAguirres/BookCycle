package com.bookcycle.backend.service;

import com.bookcycle.backend.dto.BookDTO;
import com.bookcycle.backend.entitie.Book;
import com.bookcycle.backend.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public List<BookDTO> findAllBooks(){
        List<Book> list = bookRepository.findAll();
        return list.stream().map(x -> new BookDTO(x)).collect(Collectors.toList());
    }

}
