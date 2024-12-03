package br.com.oracle.apiLivraria.main;

import br.com.oracle.apiLivraria.controller.AuthorController;
import br.com.oracle.apiLivraria.controller.BookController;
import br.com.oracle.apiLivraria.repository.AuthorRepository;
import br.com.oracle.apiLivraria.repository.BookRepository;
import br.com.oracle.apiLivraria.util.Constants;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Scanner;

public class MainRun {
    public static final Scanner terminal = new Scanner(System.in);
    private static final Constants constants = new Constants();
    private static BookRepository bookRepository;
    private static AuthorRepository authorRepository;
    @Autowired
    private static BookController bookController;
    @Autowired
    private static AuthorController authorController;

    public MainRun(BookRepository receivedBookRepository, AuthorRepository receivedAuthorRepository, BookController bookController, AuthorController authorController){
        MainRun.bookRepository = receivedBookRepository;
        MainRun.authorRepository = receivedAuthorRepository;
        MainRun.bookController = bookController;
        MainRun.authorController = authorController;
    }

    public void startApp() {
        var option = -1;

        while(option != 0 ) {
            System.out.println(constants.menu);
            option = terminal.nextInt();
            terminal.nextLine();

            switch (option){
                case 1:
                    bookController.getBookByTitle();
                    break;
                case 2:
                    bookController.getBookInDB();
                    break;
                case 3:
                    authorController.getAuthors();
                    break;
                case 4:
                    authorController.getAliveAuthorsByYear();
                    break;
                case 5:
                    bookController.getBookByLanguage();
                    break;
                default:
                    System.out.println("Invalid option");
            }
        }
    }
}
