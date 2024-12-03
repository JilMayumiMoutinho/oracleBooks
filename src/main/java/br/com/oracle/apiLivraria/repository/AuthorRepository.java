package br.com.oracle.apiLivraria.repository;

import br.com.oracle.apiLivraria.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface AuthorRepository extends JpaRepository<Author, Long> {
    @Query("SELECT a FROM Author a WHERE a.birthYear <= :yearToSearch AND a.deathYear >= :yearToSearch")
    List<Author> findAliveAuthors(int yearToSearch);
}
