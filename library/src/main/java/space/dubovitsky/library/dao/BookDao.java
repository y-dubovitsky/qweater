package space.dubovitsky.library.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import space.dubovitsky.library.domain.Book;

import java.util.List;

public interface BookDao extends AbstractDao<Book>{

    List<Book> findTopBook(int limit);

    byte[] getContent(long id);

    Page<Book> findByGenre(int pageNumber, int size, String sortField, Sort.Direction direction, long genreId);

    void updateViewCount(long viewCount, long id);

    void updateRating(long totalRating, long totalVoteCount, int avgCount, long id);
}
