package br.com.oracle.apiLivraria.controller;

import br.com.oracle.apiLivraria.model.Book;
import br.com.oracle.apiLivraria.model.BookResultData;
import br.com.oracle.apiLivraria.repository.BookRepository;
import br.com.oracle.apiLivraria.service.BookService;
import br.com.oracle.apiLivraria.service.ConsultAPI;
import br.com.oracle.apiLivraria.service.DataConverter;
import br.com.oracle.apiLivraria.util.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static br.com.oracle.apiLivraria.main.MainRun.terminal;

@RestController
public class BookController {

    @Autowired
    private BookService service;
    private static final ConsultAPI consultWeb = new ConsultAPI();
    private static final DataConverter converter = new DataConverter();

    public void getBookByTitle() {
        System.out.println("Inform the book title:");
        String bookTitle = terminal.nextLine();
        System.out.println("Searching for books with the name: " + bookTitle + "...");

        var json = consultWeb.getData(Constants.addressURL + bookTitle.trim().replace(" ", "%20"));
        BookResultData booksResults = converter.convertData(json, BookResultData.class);

        service.processBookData(booksResults.bookDataList());
    }

    public void getBookInDB() {
        System.out.println("Searching for books in our database...");
        List<Book> bookList = service.getBooksInDB();
        if(bookList.isEmpty()) {
            System.out.println("There are no books in DB");
        } else{
            bookList.forEach(System.out::println);
        }
    }

    public void getBookByLanguage() {
        System.out.println("Which language do you want to search?");
        System.out.println(Constants.languagesOptions);
        int chosenLanguage = terminal.nextInt();
        terminal.nextLine();
        String languageToSearch = Constants.languagesTranslator.get(chosenLanguage - 1);
        System.out.println("Searching for books in: " + languageToSearch + "...");
        List<Book> bookList = service.getBookByLanguage(languageToSearch);
        if (bookList.isEmpty()) {
            System.out.println("There are no books in DB in " + languageToSearch);
        } else {
            bookList.forEach(System.out::println);
        }
    }
}
