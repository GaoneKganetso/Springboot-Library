package model;

import javax.annotation.processing.Generated;
import javax.persistence.*;
import java.util.*;


@Entity
public class Book {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)

    private long id;
    public String title;
    public String isbn;

    @ManyToOne
    private Publisher publisher;


    @ManyToMany
    @JoinTable(name= "author_book",joinColumns = @JoinColumn(name = "book_id"),inverseJoinColumns = @JoinColumn(name = "author_id"))

    private Set<Author> authors = new HashSet<>();


    public Book(){

    }

    public Publisher getPublisher() {
        return publisher;
    }

    public void setPublisher(Publisher publisher) {
        this.publisher = publisher;
    }

    public Book(String title, String isbn) {
        this.title = title;
        this.isbn = isbn;
    }



    public String getTitle() {
        return title;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }



    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", isbn='" + isbn + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return id == book.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public Collection<Author> getAuthors() {
        return authors;
    }
}
