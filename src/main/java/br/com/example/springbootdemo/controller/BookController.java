package br.com.example.springbootdemo.controller;

import br.com.example.springbootdemo.entity.BookEntity;
import br.com.example.springbootdemo.entity.dto.BookDto;
import br.com.example.springbootdemo.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping
    public List<BookEntity> findaAll() {

        return bookService.findAll();
    }

    @GetMapping("/{id}")
    public  BookEntity findById(@PathVariable Long id){

        return bookService.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public BookEntity save(@RequestBody BookDto dto) {
        return bookService.save(dto);
    }

    @PutMapping("/{id}")
    public BookEntity updateBook(@RequestBody BookDto dto, @PathVariable Long id) {
        BookEntity bookEntity = bookService.findById(id);
        return bookService.update(bookEntity, dto);
    }

    @DeleteMapping("/{}id")
    public void delete(@PathVariable long id) {
        bookService.delete(id);
    }



}
