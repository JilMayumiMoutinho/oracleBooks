package br.com.oracle.apiLivraria;

import br.com.oracle.apiLivraria.controller.AuthorController;
import br.com.oracle.apiLivraria.controller.BookController;
import br.com.oracle.apiLivraria.main.MainRun;
import br.com.oracle.apiLivraria.repository.AuthorRepository;
import br.com.oracle.apiLivraria.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ApiLivrariaApplication implements CommandLineRunner {
	@Autowired
	private static BookRepository bookRepository;

	@Autowired
	private static AuthorRepository authorRepository;

	@Autowired
	private BookController bookController;
	@Autowired
	private AuthorController authorController;

	public static void main(String[] args){
		SpringApplication.run(ApiLivrariaApplication.class, args);
	}

	public void run(String... args) throws Exception {
		try {
			System.out.println("Hello world");
			MainRun mainRun = new MainRun(bookRepository, authorRepository, bookController, authorController);
			mainRun.startApp();
		} catch (Exception e) {
			throw new RuntimeException("ERRO ENCONTRADO:" + e);
		}
	}
}
