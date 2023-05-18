package ir.javatalks.bookstore.dto;

import ir.javatalks.bookstore.entity.BookSubject;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BookDto {

    private String title;
    private String author;
    private BookSubject subject;
}
