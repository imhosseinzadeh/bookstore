package ir.javatalks.bookstore.repository;

import ir.javatalks.bookstore.entity.Customer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, Long> {
    Optional<Customer> findByEmailAndPassword(String email, String password);
}
