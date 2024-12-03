package br.com.oracle.apiLivraria.model;

import jakarta.persistence.*;

import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "authors")
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String name;
    private Integer birthYear;
    private Integer deathYear;
    @OneToMany(mappedBy = "author")
    private List<Book> books;

    public Author(){}

    public Author(AuthorData authorData){
        this.birthYear = authorData.birthYear();
        this.deathYear = authorData.deathYear();
        this.name = authorData.name();
    }

    public String getName() {
        return name;
    }

    public Integer getBirthYear() {
        return birthYear;
    }

    public Integer getDeathYear() {
        return deathYear;
    }

    @Override
    public String toString() {
        return "Author{" +
                "name='" + name + '\'' +
                ", birthYear=" + birthYear +
                ", deathYear=" + deathYear +
                '}';
    }

    /*@Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Author author = (Author) obj;
        return Objects.equals(birthYear, author.birthYear) &&
                Objects.equals(deathYear, author.deathYear) &&
                name.equals(author.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, birthYear, deathYear);
    }*/
}
