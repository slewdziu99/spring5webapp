package pl.adam.guru.springframework.spring5webapp.domain;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by aslazinski on 2020-03-14.
 */
@Getter
@Setter
@Entity
public class Book {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    private String title;
    private String isbn;

    @ManyToOne
    private Publisher publisher;

    @ManyToMany
    @JoinTable(name = "author_book", joinColumns = @JoinColumn(name="book_id"),inverseJoinColumns = @JoinColumn(name="author_id") )
    private Set<Author> authors = new HashSet<Author>();

    public Book() {
    }

    public Book(String title, String isbn/*, Set<Author> authors*/) {
        this.title = title;
        this.isbn = isbn;
        //this.authors = authors;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", isbn='" + isbn + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Book book = (Book) o;

        return !(id != null ? !id.equals(book.id) : book.id != null);

    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}
