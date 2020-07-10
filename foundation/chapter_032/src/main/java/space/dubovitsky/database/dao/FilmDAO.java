package space.dubovitsky.database.dao;

import space.dubovitsky.entity.Film;

import java.util.List;

public interface FilmDAO {

    void insert(Film film);

    void delete(Film film);

    void insertList(List<Film> list);

    Film getFilmById(int id);

    List<Film> getListFilmByName(String name);

    List<Film> getListFilmByAuthor(String author);

}
