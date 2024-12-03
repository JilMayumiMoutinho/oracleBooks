package br.com.oracle.apiLivraria.repository;

import br.com.oracle.apiLivraria.model.Book;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface BookRepository extends JpaRepository<Book, Long> {
    //@Query("SELECT b FROM Book b WHERE EXISTS (SELECT 1 FROM UNNEST(b.language) AS lang WHERE lang LIKE %:languageToSearch%)")
    @Query(value = "SELECT * FROM books WHERE EXISTS (SELECT 1 FROM UNNEST(language) AS lang WHERE lang LIKE %:languageToSearch%)", nativeQuery = true)
    List<Book> findByLanguage(String languageToSearch);
}
