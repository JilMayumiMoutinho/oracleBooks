package br.com.oracle.apiLivraria.model;

import jakarta.persistence.*;

import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String title;
    @ManyToOne(fetch = FetchType.EAGER)
    //@JoinColumn (name = "autor_id", nullable = false)
    private Author author;
    private List<String> language;
    private List<String> genre;

    public Book() {}

    public Book(BookData bookData){
        this.title = bookData.title();
        this.language = bookData.languages();
        this.genre = bookData.genre();
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public String getTitle() { return title; }

    public Author getAuthor() {
        return author;
    }

    public List<String> getLanguage() {
        return language;
    }

    public List<String> getGenre() {
        return genre;
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", author=" + author +
                ", language=" + language +
                ", genre=" + genre +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Book book = (Book) obj;
        return Objects.equals(title, book.title) &&
                Objects.equals(language, book.language) &&
                genre.equals(book.genre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, language, genre);
    }
}
