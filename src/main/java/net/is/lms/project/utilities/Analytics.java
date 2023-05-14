package net.is.lms.project.utilities;

import net.is.lms.project.instances.Book;
import net.is.lms.project.instances.BorrowedBooks;
import net.is.lms.project.instances.User;
import net.is.lms.project.frames.FetchObjects;

import static net.is.lms.project.frames.AdminView.checkDeadlineExceed; // todo rework

public class Analytics {
    private int bookAmount = 0;
    private int userAmount = 0;
    private int availableBooks = 0;
    private int borrowedBooks = 0;
    private int borrowedBooksOverDeadline = 0;
    FetchObjects objects = new FetchObjects();
    private int userAmountBorrowedBooks = 0;
    private String viewName;

    public Analytics(String viewName) {
        this.viewName = viewName;
    }

    public Analytics() {

    }

    // Todo sollte check für welche Klasse haben
    public void getAnalytics(String username) {
        objects.updateBookList();
        objects.updateUserList();
        objects.updateBorrowedBookList();

        bookAmount = 0;
        userAmount = 0;
        availableBooks = 0;
        borrowedBooks = 0;
        borrowedBooksOverDeadline = 0;
        userAmountBorrowedBooks = 0;

/*        if(viewName.equals("Standard")) {

        } else if(viewName.equals("User")) {

        } else if(viewName.equals("Admin"))*/

        for (Book book : objects.getBooks()) {
            bookAmount++;
        }

        for (Book avBook : objects.getBooks()) {
            if (avBook.getAvailability().equals("Available")) availableBooks++;
        }

        for (User user : objects.getUsers()) {
            userAmount++;
        }

        for (BorrowedBooks bowBook : objects.getBorrowedBooks()) {
            if (checkDeadlineExceed(bowBook.getBorrowDate(), bowBook.getDueDate())) borrowedBooksOverDeadline++;
            borrowedBooks++;
        }

        if (!username.equals("")) {
            for (BorrowedBooks bowBook : objects.getBorrowedBooks()) {
                if (bowBook.getUsername().equals(username)) userAmountBorrowedBooks++;
            }
        }

    }

    public int getBookAmount() {
        return bookAmount;
    }

    public int getUserAmount() {
        return userAmount;
    }

    public int getAvailableBooks() {
        return availableBooks;
    }

    public int getBorrowedBooks() {
        return borrowedBooks;
    }

    public int getBorrowedBooksOverDeadline() {
        return borrowedBooksOverDeadline;
    }

    public int getUserAmountBorrowedBooks() {
        return userAmountBorrowedBooks;
    }
}
