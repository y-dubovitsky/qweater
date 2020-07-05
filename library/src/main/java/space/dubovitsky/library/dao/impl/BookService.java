package space.dubovitsky.library.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import space.dubovitsky.library.dao.BookDao;
import space.dubovitsky.library.domain.Book;
import space.dubovitsky.library.spring.repos.BookRepository;

import java.util.List;
import java.util.Optional;

public class BookService implements BookDao {

    @Autowired
    private BookRepository bookRepository;

    @Override
    public List<Book> getAll() {
        return bookRepository.findAll();
    }

    @Override
    public List<Book> getAll(Sort sort) {
        return bookRepository.findAll(sort);
    }

    @Override
    public Page<Book> getAll(int pageNumber, int pageSize, String sortField, Sort.Direction sortDirection) {
        return bookRepository.findAllBooksWithoutContent(PageRequest.of(pageNumber, pageSize, Sort.by(sortDirection, sortField)));
    }

    @Override
    public List<Book> search(String... searchString) {
        return null;
    }


    @Override
    public Page<Book> search(int pageNumber, int pageSize, String sortField, Sort.Direction sortDirection, String... searchString) {
        return bookRepository.findByNameContainingIgnoreCaseOrAuthorFioContainingIgnoreCaseOrderByName(searchString[0], searchString[1], PageRequest.of(pageNumber, pageSize));
    }


    @Override
    public Book save(Book book) {

        // отдельно сохраняем данные книги
        bookRepository.save(book);

        if (book.getContent()!=null) {
            // отдельно сохраняем контент
            bookRepository.updateContent(book.getContent(), book.getId());
        }
        return book;
    }

    @Override
    public void delete(Book book) {
        bookRepository.delete(book);
    }

    @Override
    public Book get(long id) {
        Optional<Book> bookmark = bookRepository.findById(id); //! Optional - обертка, в котором может быть значение или пусто (используется для исключение ошибки NullPointerException
        if (bookmark.isPresent()) { // если значение представлено - вернуть его
            return bookmark.get();
        } else {
            return null;
        }
    }


    @Override
    public List<Book> findTopBook(int limit) {
        return bookRepository.findTopBooks(PageRequest.of(0,limit, Sort.by(Sort.Direction.DESC, "viewCount")));
    }

    @Override
    public byte[] getContent(long id) {
        return bookRepository.getContent(id);
    }

    @Override
    public Page<Book> findByGenre(int pageNumber, int pageSize, String sortField, Sort.Direction sortDirection, long genreId) {
        return bookRepository.findByGenre(genreId, PageRequest.of(pageNumber, pageSize, Sort.by(sortDirection, sortField)));
    }

    @Override
    public void updateViewCount(long viewCount, long id) {
        bookRepository.updateViewCount(viewCount, id);
    }

    @Override
    public void updateRating(long totalRating, long totalVoteCount, int avgCount, long id) {
        bookRepository.updateRating(totalRating, totalVoteCount, avgCount, id);
    }
}
