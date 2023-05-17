package ir.javatalks.bookstore.service;

import ir.javatalks.bookstore.entity.Customer;
import ir.javatalks.bookstore.exception.CustomerNotFoundByIdException;
import ir.javatalks.bookstore.repository.CustomerRepository;
import jakarta.validation.Valid;
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
    public Customer signUp(@Valid Customer customer) {
        return customerRepository.save(customer);
    }

    @Transactional(readOnly = true)
    public Customer logIn(Long customerId) {
        Optional<Customer> customer = customerRepository.findById(customerId);

        return customer
                .orElseThrow(() -> new CustomerNotFoundByIdException(customerId));
    }

}
