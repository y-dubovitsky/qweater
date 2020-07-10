package space.dubovitsky.library.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.SelectBeforeUpdate;

import javax.persistence.*;

@Entity
@Table(name = "book", catalog = "library")
@Getter @Setter
@SelectBeforeUpdate
@DynamicUpdate
@DynamicInsert
@EqualsAndHashCode(of = "id")
public class Book {

    public Book() {
    }

    public Book(Long id, byte[] image) {
        this.id = id;
        this.image = image;
    }

    public Book(Long id, String name, int pageCount, String isbn, Genre genre, Author author, Publisher publisher, byte[] image, int publishYear, int avgRating, Long totalVoteCount, Long totalRating, Long viewCount, String descr) {
        this.id = id;
        this.name = name;
        this.pageCount = pageCount;
        this.isbn = isbn;
        this.genre = genre;
        this.author = author;
        this.publisher = publisher;
        this.image = image;
        this.publishYear = publishYear;
        this.avgRating = avgRating;
        this.totalVoteCount = totalVoteCount;
        this.totalRating = totalRating;
        this.viewCount = viewCount;
        this.descr = descr;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Lob
    @Column(name = "content", updatable = false)
    private byte[] content;

    @Column(name = "page_count")
    private int pageCount;

    private String isbn;

    @ManyToOne
    @JoinColumn
    private Genre genre;

    @ManyToOne
    @JoinColumn
    private Author author;

    @ManyToOne
    @JoinColumn
    private Publisher publisher;

    @Lob
    private byte[] image;

    @Column(name = "publish_year")
    private int publishYear;

    @Column(name = "avg_rating")
    private int avgRating;

    @Column(name = "total_vote_count")
    private Long totalVoteCount;

    @Column(name = "total_rating")
    private Long totalRating;

    @Column(name = "total_count")
    private Long viewCount;

    private String descr;


}
