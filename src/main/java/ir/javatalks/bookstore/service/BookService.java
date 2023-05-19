package ir.javatalks.bookstore.service;

import ir.javatalks.bookstore.entity.Book;
import ir.javatalks.bookstore.entity.BookSubject;
import ir.javatalks.bookstore.repository.BookRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BookService {

    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Transactional
    public Book save(Book book) {
        return bookRepository.save(book);
    }

    @Transactional(readOnly = true)
    public Page<Book> findAllBooks(Integer pageNo, Integer pageSize) {
        Pageable pageable = PageRequest.of(pageNo, pageSize);
        return bookRepository.findAll(pageable);
    }

    @Transactional(readOnly = true)
    public Page<Book> findAllBookBySubject(String subjectName, Integer pageNo, Integer pageSize) {
        Pageable pageable = PageRequest.of(pageNo, pageSize);
        BookSubject bookSubject = BookSubject.valueOf(subjectName);
        return bookRepository.findAllBySubject(bookSubject, pageable);
    }

}
