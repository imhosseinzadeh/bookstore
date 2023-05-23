package ir.javatalks.bookstore.controller;

import ir.javatalks.bookstore.entity.Book;
import ir.javatalks.bookstore.mapper.BookMapper;
import ir.javatalks.bookstore.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.RequestParam;

@RequiredArgsConstructor
public class BookController {

    private final BookService bookService;
    private final BookMapper bookMapper;

    public BookController(BookService bookService, BookMapper bookMapper) {
        this.bookService = bookService;
        this.bookMapper = bookMapper;
    }

    public Page<Book> findAllBooks(@RequestParam(defaultValue = "0") Integer pageNo,
                                   @RequestParam(defaultValue = "10") Integer pageSize) {
        return bookService.findAllBooks(pageNo, pageSize);
    }

}

