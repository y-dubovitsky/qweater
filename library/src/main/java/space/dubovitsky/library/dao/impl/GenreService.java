package space.dubovitsky.library.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import space.dubovitsky.library.dao.GenreDao;
import space.dubovitsky.library.domain.Genre;
import space.dubovitsky.library.spring.repos.GenreRepository;

import java.util.List;
import java.util.Optional;

@Service
public class GenreService implements GenreDao {


    @Autowired
    private GenreRepository genreRepository;


    @Override
    public List<Genre> getAll() {
        return genreRepository.findAll();
    }

    public List<Genre> getAll(Sort sort) {
        return genreRepository.findAll(sort);
    }


    @Override
    public Page<Genre> getAll(int pageNumber, int pageSize, String sortField, Sort.Direction sortDirection) {
        return genreRepository.findAll(PageRequest.of(pageNumber, pageSize, Sort.by(sortDirection, sortField)));
    }


    @Override
    public List<Genre> search(String... searchString) {
        return genreRepository.findByNameContainingIgnoreCaseOrderByName(searchString[0]);
    }

    @Override
    public Page<Genre> search(int pageNumber, int pageSize, String sortField, Sort.Direction sortDirection, String... searchString) {
        return genreRepository.findByNameContainingIgnoreCaseOrderByName(searchString[0], PageRequest.of(pageNumber, pageSize, Sort.by(sortDirection)));
    }


    @Override
    public Genre save(Genre genre) {
        return genreRepository.save(genre);
    }

    @Override
    public void delete(Genre genre) {
        genreRepository.delete(genre);

    }

    @Override
    public Genre get(long id) {
        Optional<Genre> bookmark = genreRepository.findById(id); // Optional - обертка, в котором может быть значение или пусто (используется для исключение ошибки NullPointerException
        if (bookmark.isPresent()) { // если значение представлено - вернуть его
            return bookmark.get();
        } else {
            return null;
        }
    }
}
