package ir.javatalks.bookstore.exception;

public class CustomerNotFoundByIdException extends RuntimeException {

    public CustomerNotFoundByIdException(Long customerId) {
        super("Customer by id " + customerId + "not found");
    }

}
