package space.dubovitsky.library.spring.controller;

import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import space.dubovitsky.library.domain.Genre;
import space.dubovitsky.library.spring.repos.GenreRepository;

import java.util.List;
import java.util.Map;
import java.util.logging.Level;

@Controller
@Log
public class GenreController {

    @Autowired
    private GenreRepository genreRepository;

    @GetMapping("/all-genre")
    public String allGenre(Map<String, Object> map) {
        List<Genre> genres = genreRepository.findAll();
        log.log(Level.WARNING, "@GetMapping(all-authors)");
        map.put("genres", genres);
        return "genre";
    }

}
