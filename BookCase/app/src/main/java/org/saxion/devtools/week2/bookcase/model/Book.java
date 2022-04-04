package org.saxion.devtools.week2.bookcase.model;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

public class Book {

    private String isbn;
    private String title;
    private String subtitle;
    private String author;
    private LocalDate published;
    private String publisher;
    private int nrOfPages;
    private String description;
    private String website;

    public Book(String isbn, String title, String subtitle, String author, String published, String publisher, int nrOfPages, String description, String website) {
        this.isbn = isbn;
        this.title = title;
        this.subtitle = subtitle;
        this.author = author;
        this.publisher = publisher;
        this.nrOfPages = nrOfPages;
        this.description = description;
        this.website = website;

        // Some dirty tricks to convert the published date.
        Instant instant = Instant.parse(published);
        this.published = LocalDateTime.ofInstant(instant, ZoneOffset.UTC).toLocalDate();
    }

    @Override
    public String toString() {
        return "Book{" +
                "isbn=" + isbn +
                ", title='" + title + '\'' +
                ", subtitle='" + subtitle + '\'' +
                ", author='" + author + '\'' +
                ", published=" + published +
                ", publisher='" + publisher + '\'' +
                ", nrOfPages=" + nrOfPages +
                ", description='" + description + '\'' +
                ", website='" + website + '\'' +
                '}';
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }
}
