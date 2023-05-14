package net.is.lms.project.instances;

public class BorrowedBooks {
    private String isbn;
    private String username;
    private String borrowDate;
    private String dueDate;

    public BorrowedBooks(String isbn, String username, String borrowDate, String dueDate) {
        this.isbn = isbn;
        this.username = username;
        this.borrowDate = borrowDate;
        this.dueDate = dueDate;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getUsername() {
        return username;
    }

    public String getBorrowDate() {
        return borrowDate;
    }

    public String getDueDate() {
        return dueDate;
    }
}
