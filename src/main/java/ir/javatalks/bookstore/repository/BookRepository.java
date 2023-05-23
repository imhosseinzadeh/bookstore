package ir.javatalks.bookstore.repository;

import ir.javatalks.bookstore.entity.Book;
import ir.javatalks.bookstore.entity.BookSubject;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends CrudRepository<Book, String>, PagingAndSortingRepository<Book, String> {
    Page<Book> findAllBySubject(BookSubject subject, Pageable pageable);
}
