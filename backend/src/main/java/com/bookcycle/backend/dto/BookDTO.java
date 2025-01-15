package com.bookcycle.backend.dto;

import com.bookcycle.backend.entitie.Book;

public class BookDTO {

    private Long id;
    private String name;
    private String sinopse;
    private String author;
    private String status;
    private String condition;

    public BookDTO() {
    }

    public BookDTO(Long id, String name, String sinopse, String author, String status, String condition) {
        this.id = id;
        this.name = name;
        this.sinopse = sinopse;
        this.author = author;
        this.status = status;
        this.condition = condition;
    }

    public BookDTO(Book book){
        id = book.getId();
        name = book.getName();
        sinopse = book.getSinopse();
        author = book.getAuthor();
        status = book.getStatus();
        condition = book.getCondition();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSinopse() {
        return sinopse;
    }

    public void setSinopse(String sinopse) {
        this.sinopse = sinopse;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }
}
