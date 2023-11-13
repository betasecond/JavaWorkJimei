package Library.Model;

import lombok.Getter;
import lombok.Setter;

import java.util.LinkedList;
@Getter
@Setter
public class Shelf {
    String Position;
    private LinkedList<Book> books;

    public Shelf(LinkedList<Book> books) {
        this.books = books;
    }
    public Shelf(){

    }

}
