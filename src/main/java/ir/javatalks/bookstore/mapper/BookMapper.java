package ir.javatalks.bookstore.mapper;

import ir.javatalks.bookstore.dto.BookDto;
import ir.javatalks.bookstore.entity.Book;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BookMapper {
    BookDto mapToDto(Book book);

    Book mapToModel(BookDto bookDto);
}
