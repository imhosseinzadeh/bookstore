package ir.javatalks.bookstore.mapper;

import ir.javatalks.bookstore.dto.CustomerDto;
import ir.javatalks.bookstore.entity.Customer;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CustomerMapper {

    CustomerDto mapToDto(Customer customer);

    Customer mapToModel(CustomerDto customerDto);
}
