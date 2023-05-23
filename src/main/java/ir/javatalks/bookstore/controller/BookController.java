package ir.javatalks.bookstore.controller;

import ir.javatalks.bookstore.entity.Book;
import ir.javatalks.bookstore.mapper.BookMapper;
import ir.javatalks.bookstore.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RestController("/books")
@RequiredArgsConstructor
public class BookController {

    private final BookService bookService;
    private final BookMapper bookMapper;

    @GetMapping("/find-all")
    public Page<Book> findAllBooks(@RequestParam(defaultValue = "0") Integer pageNo,
                                   @RequestParam(defaultValue = "10") Integer pageSize) {
        return bookService.findAllBooks(pageNo, pageSize);
    }

}

