package ir.javatalks.bookstore.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Book {
    @Id
    private Long id;
    private String title;
    private String author;
    @Enumerated(EnumType.STRING)
    private BookSubject subject;
    @PositiveOrZero
    private int quantity;
}
