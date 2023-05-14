package net.is.lms.project.frames;

import net.is.lms.project.instances.Book;
import net.is.lms.project.instances.BorrowedBooks;
import net.is.lms.project.instances.User;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
public class FetchObjects {
    private ArrayList<Book> books = new ArrayList<>();
    private ArrayList<User> users = new ArrayList<>();
    private ArrayList<BorrowedBooks> borrowedBooks = new ArrayList<>();

    private JSONArray jsonArrayBooks = new JSONArray();
    private JSONArray jsonArrayBorrowedBooks = new JSONArray();
    private JSONArray jsonArrayUsers = new JSONArray();

    public void updateBookList() {
        File file = new File("src/main/resources/books.txt");
        if (file.length() != 0) {
            JSONParser jsonParser = new JSONParser();
            try (FileReader fileReader = new FileReader("src/main/resources/books.txt")) {
                Object obj = jsonParser.parse(fileReader);
                JSONArray jsonArrayBooks = (JSONArray) obj;
                books = new ArrayList<>();
                jsonArrayBooks.forEach(book -> parseBookObj((JSONObject) book));

            } catch (IOException | ParseException e) {
                e.printStackTrace();
            }
        }
    }

    public void updateBorrowedBookList() {
        File file = new File("src/main/resources/borrowedbooks.txt");
        if (file.length() != 0) {
            JSONParser jsonParser = new JSONParser();
            try (FileReader fileReader = new FileReader("src/main/resources/borrowedbooks.txt")) {
                Object obj = jsonParser.parse(fileReader);
                JSONArray jsonArrayBorrowedBooks = (JSONArray) obj;
                borrowedBooks = new ArrayList<>();
                jsonArrayBorrowedBooks.forEach(borrowedBook -> parseBorrowedBookObj((JSONObject) borrowedBook));

            } catch (IOException | ParseException e) {
                e.printStackTrace();
            }
        }
    }

    protected void parseBorrowedBookObj(JSONObject book) {
        JSONObject bookObj = (JSONObject) book.get("BorrowedBook");
        BorrowedBooks bb = new BorrowedBooks((String) bookObj.get("ISBN"), (String) bookObj.get("Username"), (String) bookObj.get("BorrowDate"), (String) bookObj.get("DueDate"));
        borrowedBooks.add(bb);
    }

    protected void parseBookObj(JSONObject book) {
        JSONObject bookObj = (JSONObject) book.get("Book");
        Book b = new Book((String) bookObj.get("Cover"), (String) bookObj.get("Title"), (String) bookObj.get("Author"), (String) bookObj.get("Pages"), (String) bookObj.get("ISBN"), (String) bookObj.get("Location"), (String) bookObj.get("Availability"));
        books.add(b);
    }

    public void updateUserList() {
        File file = new File("src/main/resources/users.txt");
        if (file.length() != 0) {
            JSONParser jsonParser = new JSONParser();
            try (FileReader fileReader = new FileReader("src/main/resources/users.txt")) {
                Object obj = jsonParser.parse(fileReader);
                JSONArray jsonArrayUsers = (JSONArray) obj;
                users = new ArrayList<>();
                jsonArrayUsers.forEach(user -> parseUserObj((JSONObject) user));

            } catch (IOException | ParseException e) {
                e.printStackTrace();
            }
        }
//        System.out.println("UpdateUserList");

    }

    protected void parseUserObj(JSONObject user) {
        JSONObject userObj = (JSONObject) user.get("User");
        User u = new User((String) userObj.get("FirstName"), (String) userObj.get("LastName"), (String) userObj.get("UserName"), (String) userObj.get("Email"), (String) userObj.get("PhoneNumber"), (String) userObj.get("Password"));
        users.add(u);
    }

    public JSONArray getJsonArrayBooks() {
        return jsonArrayBooks;
    }

    public JSONArray getJsonArrayBorrowedBooks() {
        return jsonArrayBorrowedBooks;
    }

    public JSONArray getJsonArrayUsers() {
        return jsonArrayUsers;
    }

    public ArrayList<Book> getBooks() {
        return books;
    }

    public ArrayList<BorrowedBooks> getBorrowedBooks() {
        return borrowedBooks;
    }

    public ArrayList<User> getUsers() {
        return users;
    }
}
