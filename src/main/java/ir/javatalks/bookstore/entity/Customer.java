package ir.javatalks.bookstore.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Email
    @Column(unique = true)
    private String email;

    private String password;

    public Customer(String email, String password) {
        this.email = email;
        this.password = password;
    }

}
