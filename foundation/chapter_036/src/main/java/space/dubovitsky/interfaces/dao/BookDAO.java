package space.dubovitsky.interfaces.dao;

import space.dubovitsky.entity.Book;

import java.util.List;

public interface BookDAO {

    int insert(Book book);

    void insertList(List<Book> list);

    Book getById(int id);

}
