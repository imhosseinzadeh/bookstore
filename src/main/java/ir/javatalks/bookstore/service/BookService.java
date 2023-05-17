package ir.javatalks.bookstore.service;

import ir.javatalks.bookstore.entity.Book;
import ir.javatalks.bookstore.entity.BookSubject;
import ir.javatalks.bookstore.exception.BookSubjectNotFoundException;
import ir.javatalks.bookstore.repository.BookRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class BookService {

    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public Page<Book> findAllBooks(Pageable pageable) {
        return bookRepository.findAll(pageable);
    }

    public Page<Book> findAllBookBySubject(String subjectName, Pageable pageable) {
        try {
            BookSubject bookSubject = BookSubject.valueOf(subjectName);
            return bookRepository.findAllBySubject(bookSubject, pageable);
        } catch (IllegalArgumentException e) {
            throw new BookSubjectNotFoundException(subjectName);
        }
    }

}
