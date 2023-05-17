package ir.javatalks.bookstore.exception;

public class BookSubjectNotFoundException extends RuntimeException {
    public BookSubjectNotFoundException(String subjectName) {
        super("The subject of the book with " + subjectName + " name was not found");
    }
}
