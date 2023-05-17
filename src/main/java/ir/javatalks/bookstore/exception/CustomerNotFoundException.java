package ir.javatalks.bookstore.exception;

public class CustomerNotFoundException extends RuntimeException {

    public CustomerNotFoundException(String email, String password) {
        super("Customer by email: " + email + " And password: " + password + "not found");
    }

}
