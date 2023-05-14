package net.is.lms.project.instances;

public class User {
    private final String firstName;
    private final String lastName;
    private final String username;
    private final String email;
    private final String phoneNumber;
    private final String password;
//    private final int borrowedBooks;

    public User(String firstName, String lastName, String username, String email, String phoneNumber, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getPassword() {
        return password;
    }
}
