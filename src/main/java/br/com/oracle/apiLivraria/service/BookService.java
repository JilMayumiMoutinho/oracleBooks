package br.com.oracle.apiLivraria.service;

import br.com.oracle.apiLivraria.model.Author;
import br.com.oracle.apiLivraria.model.Book;
import br.com.oracle.apiLivraria.model.BookData;
import br.com.oracle.apiLivraria.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private AuthorService authorService;

    public void processBookData(List<BookData> booksListData) {
        List<Book> booksListOfSearch = new ArrayList<>();

        booksListData.forEach(bookData -> {
            // Verify if this author already exist in DB
            Author newAuthor = authorService.getOrSaveAuthor(bookData.author().getFirst());

            Book newBook = new Book(bookData);
            if (!booksListOfSearch.contains(newBook)) {
                newBook.setAuthor(newAuthor);

                // Verify if this book already exist in DB, if not, salves it
                Example<Book> exampleBook = Example.of(newBook);
                if (bookRepository.findOne(exampleBook).isEmpty()) {
                    bookRepository.save(newBook);
                }

                booksListOfSearch.add(newBook);
                System.out.println("Title found:");
                System.out.println(newBook + "\n");
            }
        });
    }

    public List<Book> getBooksInDB(){
        return bookRepository.findAll();
    }

    public List<Book> getBookByLanguage(String languageToSearch){
        return bookRepository.findByLanguage(languageToSearch);
    }
}
