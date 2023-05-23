package ir.javatalks.bookstore.entity;

import jakarta.persistence.*;
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
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String title;
    private String author;
    @Enumerated(EnumType.STRING)
    private BookSubject subject;
    @PositiveOrZero
    private int quantity;
}
