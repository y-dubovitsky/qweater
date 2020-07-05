package space.dubovitsky.interfaces.dao.impl;

import space.dubovitsky.entity.Book;
import space.dubovitsky.interfaces.dao.BookDAO;

import java.util.List;

public class BookDAOImpl implements BookDAO {



    @Override
    public int insert(Book book) {
        return 0;
    }

    @Override
    public void insertList(List<Book> list) {

    }

    @Override
    public Book getById(int id) {
        return null;
    }
}
