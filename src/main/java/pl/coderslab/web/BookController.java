package pl.coderslab.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import pl.coderslab.model.Book;
import pl.coderslab.model.BookService;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {
    private static final LocalDateTime localDateTime = LocalDateTime.now();
    private static final Logger logger = LoggerFactory.getLogger(BookController.class);
    private BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }


    @RequestMapping("/helloBook")
    public Book helloBook() {
        return new Book(1L, "9788324631766", "Thinking in Java",
                "Bruce Eckel", "Helion", "programming");
    }

    @GetMapping("")
    @ResponseBody
    public List<Book> getBooks() {
        logger.info(localDateTime + " Print books");
        return bookService.getBooks();


    }

    @PostMapping("")
    @ResponseBody
    public void addBook(@RequestBody Book book) {
        logger.info(localDateTime + " Add book to database");
        bookService.add(book);
    }

    @GetMapping("/{id}")
    @ResponseBody
    public Book showById(@PathVariable Long id) {
        return bookService.showById(id).orElseThrow(() -> {
            logger.info(localDateTime + "Show book id: " + id);
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "number not found");

        });
    }

    @DeleteMapping("/{id}")
    @ResponseBody
    public void deleteById(@PathVariable Long id) {
        logger.error(localDateTime + "Delete book: "+id);
        bookService.deleteById(id);
    }
    @PutMapping("")
    @ResponseBody
    public void update(@RequestBody Book book){
        logger.info(localDateTime + " : Update"+ book);
        bookService.edit(book);
    }
}


