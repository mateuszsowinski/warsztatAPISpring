package pl.coderslab.web;

import org.springframework.stereotype.Component;
import pl.coderslab.model.Book;
import pl.coderslab.model.BookService;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class MemoryBookService implements BookService {

    private static Long nextId = 4L;
    private List<Book> list;

    public MemoryBookService() {
        list = new ArrayList<>();
        list.add(new Book(1L, "9788324631766", "Thiniking	in	Java", "Bruce	Eckel", "Helion", "programming"));
        list.add(new Book(2L, "9788324627738", "Rusz	glowa	Java.", "Sierra	Kathy,	Bates	Bert", "Helion", "programming"));
        list.add(new Book(3L, "9780130819338", "Java	2.	Podstawy", "Cay	Horstmann,	Gary	Cornell", "Helion", "programming"));
    }

    public List<Book> getList() {
        return list;
    }

    public void setList(List<Book> list) {
        this.list = list;
    }


    @Override
    public List<Book> getBooks() {
        return list;
    }

    @Override
    public void add(Book book) {
        list.add(book);
        book.setId(nextId++);
    }

    @Override
    public Optional<Book> showById(Long id) {
        return list.stream().filter(i -> i.getId().equals(id)).findFirst();
    }

    @Override
    public void deleteById(Long id) {
        list.removeIf(i-> i.getId().equals(id));
    }

}
