package ir.javatalks.bookstore.controller;

import ir.javatalks.bookstore.controller.validators.CustomerSignUpValidator;
import ir.javatalks.bookstore.dto.CustomerDto;
import ir.javatalks.bookstore.entity.Customer;
import ir.javatalks.bookstore.mapper.CustomerMapper;
import ir.javatalks.bookstore.service.CustomerService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    private final CustomerService customerService;
    private final CustomerSignUpValidator customerSignUpValidator;

    private final CustomerMapper customerMapper;

    public CustomerController(CustomerService customerService, CustomerSignUpValidator customerSignUpValidator, CustomerMapper customerMapper) {
        this.customerService = customerService;
        this.customerSignUpValidator = customerSignUpValidator;
        this.customerMapper = customerMapper;
    }

    @InitBinder("customerDto")
    private void initBinder(WebDataBinder binder) {
        binder.setValidator(customerSignUpValidator);
    }

    @PostMapping("/sign-up")
    public Customer signUp(@Valid CustomerDto customerDto) {
        return customerService.signUp(customerMapper.mapToModel(customerDto));
    }

    @PostMapping("/login")
    public Customer logIn(@RequestBody CustomerDto customerDto) {
        return customerService.logIn(customerDto.getEmail(), customerDto.getPassword());
    }


    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public Map<String, String> handleValidationException(MethodArgumentNotValidException ex) {
        BindingResult result = ex.getBindingResult();
        Map<String, String> errors = new HashMap<>();
        result.getFieldErrors().forEach(error -> {
            String fieldName = error.getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return errors;
    }
}

