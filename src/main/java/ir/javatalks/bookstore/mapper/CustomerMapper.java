package ir.javatalks.bookstore.mapper;

import ir.javatalks.bookstore.dto.CustomerDto;
import ir.javatalks.bookstore.entity.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CustomerMapper {

  CustomerMapper MAPPER = Mappers.getMapper(CustomerMapper.class);

  CustomerDto mapToCustomerDto(Customer customer);

  Customer mapToCustomer(CustomerDto customerDto);
}
