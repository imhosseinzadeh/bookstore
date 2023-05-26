package ir.javatalks.bookstore.controller;

import ir.javatalks.bookstore.dto.BookDto;
import ir.javatalks.bookstore.entity.Book;
import ir.javatalks.bookstore.mapper.BookMapper;
import ir.javatalks.bookstore.service.BookService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/books")
@RequiredArgsConstructor
@Slf4j
public class BookController {

    private final BookService bookService;
    private final BookMapper bookMapper;

    @GetMapping("/find-all")
    @PreAuthorize("hasAnyRole('USER', 'CUSTOMER', 'ADMIN')")
    public Page<Book> findAllBooks(@RequestParam(defaultValue = "0") Integer pageNo,
                                   @RequestParam(defaultValue = "10") Integer pageSize) {
        return bookService.findAllBooks(pageNo, pageSize);
    }

    @PostMapping("/add")
    @PreAuthorize("hasAnyAuthority('BOOK_WRITE')")
    public void addBook(@RequestBody BookDto bookDto) {
        log.debug("ADDING BOOK {}", bookDto);
    }

    @PutMapping("/update")
    @PreAuthorize("hasAnyAuthority('BOOK_WRITE')")
    public void updateBook(@RequestBody BookDto bookDto) {
        log.debug("UPDATING BOOK {}", bookDto);
    }

    @DeleteMapping("/remove")
    @PreAuthorize("hasAnyAuthority('BOOK_WRITE')")
    public void removeBook(@RequestBody BookDto bookDto) {
        log.debug("REMOVING BOOK {}", bookDto);
    }

}
