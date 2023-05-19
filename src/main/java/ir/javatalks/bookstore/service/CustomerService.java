package ir.javatalks.bookstore.service;

import ir.javatalks.bookstore.entity.Customer;
import ir.javatalks.bookstore.exception.CustomerNotFoundException;
import ir.javatalks.bookstore.repository.CustomerRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;


@Service
public class CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Transactional
    public Customer signUp(Customer customer) {
        return customerRepository.save(customer);
    }

    @Transactional(readOnly = true)
    public Customer logIn(String email, String password) {
        Optional<Customer> customer = customerRepository.findByEmailAndPassword(email, password);

        return customer.orElseThrow(() -> new CustomerNotFoundException(email, password));
    }

    @Transactional(readOnly = true)
    public Optional<Customer> findByEmail(String email) {
        return customerRepository.findByEmail(email);
    }
}
