package ir.javatalks.bookstore.entity.security;

public enum Permission {
    BOOK_READ("BOOK:READ"),
    BOOK_WRITE("BOOK_WRITE"),
    BUY_BOOK("BUY:BOOK");

    private final String permissionName;

    Permission(String permissionName) {
        this.permissionName = permissionName;
    }

}
