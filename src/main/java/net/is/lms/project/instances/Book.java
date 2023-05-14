package net.is.lms.project.instances;

public class Book {

    private final String coverLocation;
    private final String title;
    private final String author;
    private final String pages;
    private final String isbn;
    private final String location;
    private final String availability;


    public Book(String coverLocation, String title, String author, String pages, String isbn, String location, String availability) {
        this.coverLocation = coverLocation;
        this.title = title;
        this.author = author;
        this.pages = pages;
        this.isbn = isbn;
        this.location = location;
        this.availability = availability;
    }

    public String getCoverLocation() {
        return coverLocation;
    }

    ;

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getPages() {
        return pages;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getLocation() {
        return location;
    }

    public String getAvailability() {
        return availability;
    }
}
