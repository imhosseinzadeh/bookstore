package ir.javatalks.bookstore.controller;

import ir.javatalks.bookstore.entity.Book;
import ir.javatalks.bookstore.entity.BookSubject;
import ir.javatalks.bookstore.exception.BookSubjectNotFoundException;
import ir.javatalks.bookstore.service.BookService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.RequestParam;

public class BookController {

  private BookService bookService;

  public BookController(BookService bookService) {
    this.bookService = bookService;
  }

  public Page<Book> findAllBooks(@RequestParam(defaultValue = "0") Integer pageNo,
      @RequestParam(defaultValue = "10") Integer pageSize) {
    return bookService.findAllBooks(pageNo, pageSize);
  }

}

