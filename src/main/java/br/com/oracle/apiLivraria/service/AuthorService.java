package br.com.oracle.apiLivraria.service;

import br.com.oracle.apiLivraria.model.Author;
import br.com.oracle.apiLivraria.model.AuthorData;
import br.com.oracle.apiLivraria.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorService {
    @Autowired
    private AuthorRepository authorRepository;

    public Author getOrSaveAuthor(AuthorData authorData) {
        Author newAuthor = new Author(authorData);
            Example<Author> example = Example.of(newAuthor);
            Author newAuthorCopy = newAuthor;
            newAuthor = authorRepository.findOne(example).orElseGet(() -> {
                return authorRepository.save(newAuthorCopy);
            });
        return newAuthor;
    }

    public List<Author> getAuthors() {
        return authorRepository.findAll();
    }

    public List<Author> getAliveAuthorsByYear(int yearToSearch) {
        return authorRepository.findAliveAuthors(yearToSearch);
    }
}
