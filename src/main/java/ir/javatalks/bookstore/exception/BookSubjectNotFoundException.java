package ir.javatalks.bookstore.exception;

public class BookSubjectNotFoundException extends RuntimeException {
    public BookSubjectNotFoundException(String subjectName) {
        super("Book subject with name of " + subjectName + " was not found");
    }
}
