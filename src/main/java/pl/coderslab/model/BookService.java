package pl.coderslab.model;


import java.util.List;
import java.util.Optional;

public interface BookService {

    List<Book> getBooks();
    void add(Book book);
    Optional<Book> showById(Long id);
    void deleteById(Long id);

}
