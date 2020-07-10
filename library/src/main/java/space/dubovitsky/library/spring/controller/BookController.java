package space.dubovitsky.library.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import space.dubovitsky.library.domain.Book;
import space.dubovitsky.library.spring.repos.BookRepository;

import java.util.List;
import java.util.Map;

@Controller
public class BookController {

    @Autowired
    private BookRepository bookRepository;

    @GetMapping("/all-books")
    public String allBooks(Map<String, Object> map) {
        List<Book> books = bookRepository.findByNameContainingIgnoreCaseOrAuthorFioContainingIgnoreCaseOrderByName("Лол", "ли");
        map.put("books", books);
        System.out.println("Hello");
        return "books";
    }

    @GetMapping("/book-without")
    public String bookWithoutContent(Map<String, Object> model) {
        Page<Book> books = bookRepository.findAllBooksWithoutContent(PageRequest.of(1, 5, Sort.by("id")));
        model.put("booksWithout", books);
        return "books";
    }

    @GetMapping("/book-genre")
    public String bookByGenre(Map<String, Object> model) {
        Page<Book> byGenre = bookRepository.findByGenre(15L, PageRequest.of(0, 5, Sort.by(Sort.Direction.ASC, "id")));
        model.put("byGenre", byGenre);
        return "books";
    }

}
