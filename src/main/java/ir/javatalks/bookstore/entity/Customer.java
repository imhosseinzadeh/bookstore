package ir.javatalks.bookstore.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
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
    private Long id;

    @Email
    private String email;

    private String password;

    public Customer(String email, String password) {
        this.email = email;
        this.password = password;
    }

}
