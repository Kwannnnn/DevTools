package org.saxion.devtools.week3.bookcase.core.model;

import org.saxion.devtools.week3.bookcase.core.model.exceptions.BookCaseOutOfRoomException;
import org.saxion.devtools.week3.bookcase.core.model.exceptions.BookNotFoundException;

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
    @Test
    public void checkIfBookCaseHasNoSpace() {
        BookCase bookCase = new BookCase(-1);

        assertFalse((bookCase.hasSpace()));
    }

    @Test
    public void findBookByAuthorNamesDoNotMatch() throws BookCaseOutOfRoomException {
        BookCase bookCase = new BookCase(1);

        bookCase.addBook(sampleBook);

        assertThrows(BookNotFoundException.class, () -> {
            bookCase.findBooksByAuthor("Not a matching name");
        });
    }

    @Test
    public void findBookByTitleExists() throws BookNotFoundException, BookCaseOutOfRoomException {
        BookCase bookCase = new BookCase(1);

        bookCase.addBook(this.sampleBook);

        Book foundBook = bookCase.findBookByTitle(this.sampleBook.getTitle());

        assertEquals(foundBook.getTitle(), this.sampleBook.getTitle());
    }

    @Test
    public void findBookByTitleNotMatching() throws BookCaseOutOfRoomException {
        BookCase bookCase = new BookCase(1);

        bookCase.addBook(this.sampleBook);

        assertThrows(BookNotFoundException.class, () -> {
            bookCase.findBookByTitle("Not a matching title");
        });
    }

    @Test
    public void findBookByTitleNotExists() {
        BookCase bookCase = new BookCase(1);

        // Not adding the book.

        assertThrows(BookNotFoundException.class, () -> {
            bookCase.findBookByTitle(this.sampleBook.getTitle());
        });
    }

    @Test
    public void removeBookByTitleExists() throws BookNotFoundException, BookCaseOutOfRoomException {
        BookCase bookCase = new BookCase(1);

        bookCase.addBook(this.sampleBook);

        bookCase.removeBookByTitle(this.sampleBook.getTitle());
    }

    @Test
    public void removeBookByTitleNotExists() {
        BookCase bookCase = new BookCase(1);

        // Not adding the book.

        assertThrows(BookNotFoundException.class, () -> {
            bookCase.removeBookByTitle(this.sampleBook.getTitle());
        });
    }

    @Test
    public void toStringNoBooks() {
        BookCase bookCase = new BookCase(1);

        String expectedResult = "";

        assertEquals(bookCase.toString(), expectedResult);
    }

    @Test
    public void toStringOneBook() throws BookCaseOutOfRoomException {
        BookCase bookCase = new BookCase(1);

        bookCase.addBook(this.sampleBook);
        String expectedResult = this.sampleBook.toString() + System.lineSeparator();

        assertEquals(bookCase.toString(), expectedResult);
    }

    @Test
    public void toStringMultipleBooks() throws BookCaseOutOfRoomException {
        BookCase bookCase = new BookCase(2);

        bookCase.addBook(this.sampleBook);
        bookCase.addBook(this.sampleBook);

        String expectedResult = this.sampleBook.toString()
                                + System.lineSeparator()
                                + this.sampleBook.toString()
                                + System.lineSeparator();

        assertEquals(bookCase.toString(), expectedResult);
    }

}
