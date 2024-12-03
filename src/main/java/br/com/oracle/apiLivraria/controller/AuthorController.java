package br.com.oracle.apiLivraria.controller;

import br.com.oracle.apiLivraria.model.Author;
import br.com.oracle.apiLivraria.repository.AuthorRepository;
import br.com.oracle.apiLivraria.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static br.com.oracle.apiLivraria.main.MainRun.terminal;

@RestController
public class AuthorController {
    @Autowired
    private static AuthorRepository authorRepository;
    @Autowired
    private AuthorService service = new AuthorService();

    public void getAuthors() {
        System.out.println("Searching for authors in our database...");
        List<Author> authorList = service.getAuthors();
        if(authorList.isEmpty()) {
            System.out.println("There are no authors in DB");
        } else{
            authorList.forEach(System.out::println);
        }
    }

    public void getAliveAuthorsByYear() {
        System.out.println("Which year do you want to search?");
        int yearToSearch = terminal.nextInt();
        terminal.nextLine();
        System.out.println("Searching for living authors in " + yearToSearch + "in our database...");
        List<Author> authorList = service.getAliveAuthorsByYear(yearToSearch);
        if (authorList.isEmpty()) {
            System.out.println("There are no authors in DB that were live in " + yearToSearch);
        } else {
            authorList.forEach(System.out::println);
        }
    }


}