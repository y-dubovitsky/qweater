package space.dubovitsky.library.spring.repos;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import space.dubovitsky.library.domain.Book;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    List<Book> findByNameContainingIgnoreCaseOrAuthorFioContainingIgnoreCaseOrderByName(String name, String fio);

    @Query("select new space.dubovitsky.library.domain.Book(b.id, b.image) from Book as b") //* Извлекает данные из таблицы и создает объекты
    List<Book> findTopBooks(Pageable pageable);

    @Query("select new space.dubovitsky.library.domain.Book(b.id, b.name, b.pageCount, b.isbn, b.genre, b.author, b.publisher, b.image, b.publishYear, b.avgRating, b.totalVoteCount, b.totalRating, b.viewCount, b.descr) from Book as b")
    Page<Book> findAllBooksWithoutContent(Pageable pageable);

    /**
     * Обновляем контент книги
     * @param content - новый контент
     * @param id - id книги, которую будем обновлять
     */
    @Modifying(clearAutomatically = true)
    @Query("update Book b set b.content =: content where id =: id") //? where id =: id" и тут b.genre.id=:genreId... В чем разница?
    void updateContent(@Param("content") byte[] content, @Param("id") long id);

    /**
     * Поиск книг по жанру
     */
    @Query("select new space.dubovitsky.library.domain.Book(b.id, b.name, b.pageCount, b.isbn, b.genre, b.author, b.publisher, b.image, b.publishYear, b.avgRating, b.totalVoteCount, b.totalRating, b.viewCount, b.descr) from Book as b where b.genre.id=:genreId")
    Page<Book> findByGenre(@Param("genreId") long genreId, Pageable pageable);

    /**
     * Получение контента книги по id
     */
    @Query("select b.content from Book b where b.id =: id")
    byte[] getContent(@Param(value = "id") long id);

    Page<Book> findByNameContainingIgnoreCaseOrAuthorFioContainingIgnoreCaseOrderByName(String name, String fio, Pageable pageable);

    @Modifying
    @Query("update Book b set b.viewCount=:viewCount where b.id =:id")
    void updateViewCount(@Param("viewCount") long viewCount, @Param("id") long id);

    @Modifying
    @Query("update Book b set b.totalVoteCount=:totalVoteCount, b.totalRating=:totalRating, b.avgRating=:avgRating where b.id =:id")
    void updateRating(@Param("totalRating") long totalRating, @Param("totalVoteCount") long totalVoteCount,  @Param("avgRating") int avgRating, @Param("id") long id);

}
