package com.bookcycle.backend.service;

import com.bookcycle.backend.dto.BookDTO;
import com.bookcycle.backend.entitie.Book;
import com.bookcycle.backend.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public List<BookDTO> findAllBooks(){
        List<Book> list = bookRepository.findAll();
        return list.stream().map(x -> new BookDTO(x)).collect(Collectors.toList());
    }

    public BookDTO findBookById(Long id){
        Optional<Book> obj = bookRepository.findById(id);
        Book book = obj.orElse(null);
        return new BookDTO(book);
    }

    public BookDTO createBook(BookDTO bookDTO){
        Book book = new Book();
        saveToEntity(bookDTO, book);
        book = bookRepository.save(book);
        return new BookDTO(book);
    }

    public BookDTO updateBook(Long id, BookDTO bookDTO){
        Book book = bookRepository.getOne(id);
        saveToEntity(bookDTO, book);
        book = bookRepository.save(book);
        return new BookDTO(book);
    }

    public void deleteBook(Long id){
        bookRepository.deleteById(id);
    }

    public void saveToEntity(BookDTO bookDTO, Book book){
        book.setName(bookDTO.getName());
        book.setAuthor(bookDTO.getAuthor());
        book.setStatus(bookDTO.getStatus());
        book.setCondition(bookDTO.getCondition());
        book.setSinopse(bookDTO.getSinopse());

    }
}
