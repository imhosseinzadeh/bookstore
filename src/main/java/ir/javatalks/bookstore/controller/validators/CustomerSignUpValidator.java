package ir.javatalks.bookstore.controller.validators;

import ir.javatalks.bookstore.dto.CustomerDto;
import ir.javatalks.bookstore.service.CustomerService;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
@RequiredArgsConstructor
public class CustomerSignUpValidator implements Validator {

    private final CustomerService customerService;

    @Override
    public boolean supports(@NotNull Class<?> clazz) {
        return CustomerDto.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(@NotNull Object target, @NotNull Errors errors) {
        CustomerDto customerDto = (CustomerDto) target;
        if (customerService.findByEmail(customerDto.getEmail()).isPresent()) {
            errors.reject("email", "Email already exists");
        }
    }
}
