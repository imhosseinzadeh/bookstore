package ir.javatalks.bookstore.repository;

import ir.javatalks.bookstore.entity.Book;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends CrudRepository<Book, Long> {
}
