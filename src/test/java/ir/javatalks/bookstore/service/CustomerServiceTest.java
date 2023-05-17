package ir.javatalks.bookstore.service;

import ir.javatalks.bookstore.entity.Customer;
import ir.javatalks.bookstore.exception.CustomerNotFoundException;
import ir.javatalks.bookstore.repository.CustomerRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CustomerServiceTest {

    @Mock
    CustomerRepository customerRepository;

    @InjectMocks
    CustomerService customerService;

    private static final String email = "sample@gmail.com";
    private static final String password = "sample&Password1234";

    @Test
    void signUp_returnCustomer_whenEmailAndPasswordValid() {
        Customer customer = new Customer(email, password);

        customerService.signUp(customer);

        verify(customerRepository, times(1)).save(customer);
    }

/*
    @Test
    void signUp_throwException_whenEmailAndPasswordNotValid() {

        Customer customer = new Customer("bademail", "badPassword");

        assertThrows(ConstraintViolationException.class, () -> customerService.signUp(customer));

        verify(customerRepository, never()).save(any());
    }
*/

    @Test
    void logIn() {

        when(customerRepository.findByEmailAndPassword(email, password))
                .thenReturn(Optional.of(new Customer(email, password)));

        Customer logedCustomer = customerService.logIn(email, password);

        assertNotNull(logedCustomer);
        assertDoesNotThrow(() -> new CustomerNotFoundException(email, password));

        verify(customerRepository, times(1))
                .findByEmailAndPassword(email, password);
    }

}