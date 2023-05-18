package ir.javatalks.bookstore.controller.validators;

import ir.javatalks.bookstore.dto.CustomerDto;
import ir.javatalks.bookstore.service.CustomerService;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class CustomerSignUpValidator  implements Validator {
  private CustomerService customerService;

  @Override
  public boolean supports(Class<?> clazz) {
    return CustomerDto.class.isAssignableFrom(clazz);
  }

  @Override
  public void validate(Object target, Errors errors) {
    CustomerDto customerDto = (CustomerDto) target;
    if (customerService.findByEmail(customerDto.getEmail()).isPresent()) {
      errors.reject("email",  "Email already exists");
    }
   }
}
