package Library.Service;

import Library.Model.Book;
import Library.Model.Library;
import Library.Model.Shelf;

import java.util.ListIterator;

public class LibraryService {
    private final Library library;

    public LibraryService(Library library) {
        this.library = library;
    }

    public boolean addBookToShelf(Book book, String shelfPosition) {

        for (Shelf shelf:library.getShelves() ) {
            if(shelf.getPosition().equals(shelfPosition)){
                shelf.getBooks().addLast(book);
                System.out.println("add "+book.toString()+" to shelf : "+ shelf);
                return true;
            }
        }
        System.out.println("faild in add");
        return false;
    }

    public boolean removeBookByISBN(String isbn) {
        for (Shelf shelf : library.getShelves()) {
            ListIterator<Book> iterator = shelf.getBooks().listIterator();
            while (iterator.hasNext()) {
                Book book = iterator.next();
                if (book.isbn().equals(isbn)) {
                    iterator.remove();
                    System.out.println("Removed book with ISBN " + isbn);
                    return true;
                }
            }
        }
        System.out.println("Book with ISBN " + isbn + " not found");
        return false;
    }

    public boolean updateBookByISBN(String isbn, Book updatedBook) {
        for (Shelf shelf : library.getShelves()) {
            ListIterator<Book> iterator = shelf.getBooks().listIterator();
            while (iterator.hasNext()) {
                Book book = iterator.next();
                if (book.isbn().equals(isbn)) {
                    iterator.set(updatedBook);
                    System.out.println("Updated book with ISBN " + isbn);
                    return true;
                }
            }
        }
        System.out.println("Book with ISBN " + isbn + " not found");
        return false;
    }
    public Book findBookByISBN(String isbn) {
        for (Shelf shelf : library.getShelves()) {
            for (Book book : shelf.getBooks()) {
                if (book.isbn().equals(isbn)) {
                    System.out.println("Found book: " + book);
                    return book;
                }
            }
        }
        System.out.println("Book with ISBN " + isbn + " not found");
        return null;
    }
    public void printAllBooks() {
        for (Shelf shelf : library.getShelves()) {
            for (Book book : shelf.getBooks()) {
                System.out.print(shelf);
                System.out.print(":");
                System.out.println(book);
            }
        }
    }

}
