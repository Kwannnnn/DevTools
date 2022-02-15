package org.saxion.devtools.week2.bookcase.model;

import org.saxion.devtools.week2.bookcase.model.exceptions.BookCaseOutOfRoomException;
import org.saxion.devtools.week2.bookcase.model.exceptions.BookNotFoundException;

import java.util.List;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BookCaseTest {

    Book sampleBook = new Book("9781593275846",
            "Eloquent JavaScript, Second Edition",
            "A Modern Introduction to Programming",
            "Marijn Haverbeke",
            "2014-12-14T00:00:00.000Z",
            "No Starch Press",
            472,
            "JavaScript lies at the heart of almost every modern web application, " +
                    "from social apps to the newest browser-based games. Though simple for beginners " +
                    "to pick up and play with, JavaScript is a flexible, complex language that " +
                    "you can use to build full-scale applications.",
            "http://eloquentjavascript.net/");

    @Test
    public void addBookSuccesfull() throws BookCaseOutOfRoomException {
        BookCase bookCase = new BookCase(1);

        bookCase.addBook(sampleBook);
    }

    @Test
    public void addBookToFullCase() {
        BookCase bookCase = new BookCase(0);


        assertThrows(BookCaseOutOfRoomException.class, () -> {
            bookCase.addBook(sampleBook);
        });
    }

    @Test
    public void checkIfBookCaseHasSpace() {
        BookCase bookCase = new BookCase(2);

        assertTrue((bookCase.hasSpace()));
    }

    @Test
    public void findBookByAuthorExists() throws BookNotFoundException, BookCaseOutOfRoomException {
        BookCase bookCase = new BookCase(1);

        bookCase.addBook(sampleBook);

        List<Book> foundBooks = bookCase.findBooksByAuthor(sampleBook.getAuthor());

        assertEquals(foundBooks.size(), 1);
        assertEquals(foundBooks.get(0).getAuthor(), sampleBook.getAuthor());
    }

    public void findBookByAuthorNotExists() throws BookNotFoundException {
        BookCase bookCase = new BookCase(1);

        // Not adding the book.

        assertThrows(BookNotFoundException.class, () -> {
            bookCase.findBooksByAuthor(sampleBook.getAuthor());
        });
    }

    // Obviously we're far from done! But you get the idea..
}
