package Library.Model;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.Vector;

@Data
@EqualsAndHashCode
@ToString
public class Library {
    String LibraryName;
    Vector<Shelf> shelves;


}
