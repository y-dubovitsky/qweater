package space.dubovitsky.library.spring.controller;

import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import space.dubovitsky.library.domain.Author;
import space.dubovitsky.library.spring.repos.AuthorRepository;

import java.util.List;
import java.util.Map;
import java.util.logging.Level;

@Controller
@Log
public class AuthorController {

    @Autowired
    private AuthorRepository authorRepository;

    @GetMapping("/all-authors")
    public String allAuthors(Map<String, Object> map) {
        List<Author> authors = authorRepository.findAll();
        log.log(Level.WARNING, "@GetMapping(all-authors)");
        map.put("authors", authors);
        return "main";
    }

    @GetMapping("/pageable-author")
    public String pageableAuthor(Map<String, Object> model) {
        Page<Author> pageableAuthor = authorRepository.findByFioContainingIgnoreCaseOrderByFio(
                "д",
                PageRequest.of(1, 5, Sort.by(Sort.Direction.ASC, "fio"))
        );
        List<Author> content = pageableAuthor.getContent();
        model.put("content", content);
        return "pageable-author";
    }

}
