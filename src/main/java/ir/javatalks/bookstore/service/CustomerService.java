package ir.javatalks.bookstore.service;

import ir.javatalks.bookstore.dto.CustomerDto;
import ir.javatalks.bookstore.entity.Customer;
import ir.javatalks.bookstore.exception.CustomerNotFoundException;
import ir.javatalks.bookstore.mapper.CustomerMapper;
import ir.javatalks.bookstore.repository.CustomerRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;


@Service
public class CustomerService {

    private final CustomerRepository customerRepository;
    private final CustomerMapper customerMapper;

    public CustomerService(CustomerRepository customerRepository, CustomerMapper customerMapper) {
        this.customerRepository = customerRepository;
        this.customerMapper = customerMapper;
    }

    @Transactional
    public Customer signUp(CustomerDto customerDto) {
        Customer customer = customerMapper.mapToModel(customerDto);
        return customerRepository.save(customer);
    }

    @Transactional(readOnly = true)
    public Customer logIn(CustomerDto customerDto) {
        Optional<Customer> customer = customerRepository.findByEmailAndPassword(
                customerDto.getEmail(),
                customerDto.getPassword());
        return customer
                .orElseThrow(
                        () -> new CustomerNotFoundException(customerDto.getEmail(), customerDto.getPassword()));
    }


    public Optional<Customer> findByEmail(String email) {
        return customerRepository.findByEmail(email);
    }
}
