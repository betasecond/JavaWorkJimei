package LibraryTest;

import Library.Model.Book;
import Library.Model.Library;
import Library.Model.Shelf;
import Library.Service.LibraryService;
import java.util.LinkedList;
import java.util.Vector;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LibraryServiceTest {

    private Library library;
    private LibraryService libraryService;

    @BeforeEach
    public void setup() {
        library = new Library();
        libraryService = new LibraryService(library);

        // Initialize the library with 10 shelves
        Vector<Shelf> shelves = new Vector<>();
        for (int i = 1; i <= 10; i++) {

            Shelf shelf = new Shelf(new LinkedList<>());
            shelf.setPosition("Shelf " + i);
            shelves.add(shelf);
        }
        library.setShelves(shelves);

        // Add 10 books to each shelf
        for (Shelf shelf : library.getShelves()) {
            for (int i = 1; i <= 10; i++) {
                Book book = new Book("ISBN" + i, "Title " + i, "Author " + i, 100 + i);
                shelf.getBooks().add(book);
            }
        }
    }

    @Test
    public void testAddBookToShelf() {
        Book newBook = new Book("ISBN123", "New Book", "New Author", 250);
        boolean result = libraryService.addBookToShelf(newBook, "Shelf 1");
        assertTrue(result);
        // Additional assertions can check if the book was really added to the shelf
    }

    @Test
    public void testRemoveBookByISBN() {
        boolean result = libraryService.removeBookByISBN("ISBN1");
        assertTrue(result);
        // Additional assertions can check if the book was really removed
    }

    @Test
    public void testUpdateBookByISBN() {
        Book updatedBook = new Book("ISBN2", "Updated Title", "Updated Author", 150);
        boolean result = libraryService.updateBookByISBN("ISBN2", updatedBook);
        assertTrue(result);
        // Additional assertions can check if the book was really updated
    }

    @Test
    public void testFindBookByISBN() {
        Book book = libraryService.findBookByISBN("ISBN3");
        assertNotNull(book);
        assertEquals("Title 3", book.title());
        // Additional assertions can verify the details of the found book
    }

    @Test
    public void testPrintAllBooks() {
        // This test might simply run the method to ensure it doesn't throw exceptions
        assertDoesNotThrow(() -> libraryService.printAllBooks());
    }

    // ... Additional tests ...
}
