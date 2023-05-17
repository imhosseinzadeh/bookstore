package ir.javatalks.bookstore.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import ir.javatalks.bookstore.dto.BookDto;
import ir.javatalks.bookstore.entity.Book;
import ir.javatalks.bookstore.entity.BookSubject;
import ir.javatalks.bookstore.exception.BookSubjectNotFoundException;
import ir.javatalks.bookstore.repository.BookRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class BookService {

  private final BookRepository bookRepository;
  private final ObjectMapper objectMapper;

  public BookService(BookRepository bookRepository, ObjectMapper objectMapper) {

    this.bookRepository = bookRepository;
    this.objectMapper = objectMapper;
  }

  public Page<Book> findAllBooks(Integer pageNo, Integer pageSize) {
    Pageable pageable = PageRequest.of(pageNo, pageSize);
    return bookRepository.findAll(pageable);
  }

  public Page<Book> findAllBookBySubject(String subjectName, Integer pageNo, Integer pageSize) {
    Pageable pageable = PageRequest.of(pageNo, pageSize);
    BookSubject bookSubject = BookSubject.valueOf(subjectName);
    return bookRepository.findAllBySubject(bookSubject, pageable);

  }


  public Book save(BookDto bookDto) {
     Book book =  objectMapper.convertValue(bookDto, Book.class);
     return bookRepository.save(book);
  }


}
