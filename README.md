# 📚 Oracle Books 📚
![Badge]

Aplicação backend Java/Spring Boot para amantes de livros. Esta aplicação permite buscar livros, listar livros registrados, listar autores, e outras funcionalidades em relação a organização de livros proposta pela <a href="https://www.alura.com.br/challenges/challenge-one-logica/sprint01-construa-decodificador-texto-com-javascript">Oracle Next Education + Alura</a>, utilizando o aprendizado em lógica de programação, POO e requisições de API do segundo módulo com JAVA.


## ✔Requisitos concluídos

- Buscar livros pelo título: Consulta a API Gutendex para buscar livros pelo título.
- Listar livros registrados: Exibe todos os livros registrados no banco de dados.
- Listar autores registrados: Exibe todos os autores dos livros registrados.
- Listar autores vivos em um determinado ano: Lista autores que estavam vivos em um ano especificado.
- Listar livros em um determinado idioma: Lista livros registrados no banco de dados em um idioma especificado.
- Encerrar a aplicação: Encerra o programa.

## 📚Bibliotecas utilizadas
- Nenhuma devido a pré-requisito da Oracle One

## 🛠Tecnologias utilizadas
- Maven: Ferramenta de gerenciamento de dependências e construção de projeto.
- Gutendex-API: API utilizada para recuperar os livros em busca por nome.
- <a href="https://www.java.com" target="_blank" rel="noreferrer"> <img src="https://raw.githubusercontent.com/devicons/devicon/master/icons/java/java-original.svg" alt="logo do java" width="30" height="40"/> </a>  
- **Spring Boot**
- **Hibernate**
- **PostgreSQL**

## 💻Como rodar o projeto localmente

1. Clone o repositório:
   ```bash
   git clone https://github.com/seu-usuario/literalura.git
   cd literalura
   ```

2. Configure o banco de dados no arquivo `application.properties`:
   ```properties
    spring.datasource.url=jdbc:postgresql://${DB_HOST}:${DB_PORT}
    spring.datasource.username=${DB_USER}
    spring.datasource.password=${DB_PASSWORD}
    spring.datasource.driver-class-name=org.postgresql.Driver
    hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect
    spring.jpa.hibernate.ddl-auto=update
    spring.jpa.show-sql=true
   ```

3. Execute o projeto:
   ```bash
   mvn spring-boot:run
   ```

## Estrutura do Projeto

- `br.com.oracle.apiLivraria`:
    - `controller`: Contém as classes que gerenciam interações com usuário e as execuções em service.
    - `main`: Contém a classe `MainRun`, que gerencia a execução da aplicação.
    - `model`: Contém as classes de modelo como: `Book`, `Author`, `BookData`, `AuthorData`).
    - `repository`: Contém as interfaces de repositório Spring Data JPA.
    - `service`: Contém as classes de serviço como: `ConsultAPI`, `Converter`, `AuthorService`).

### Exemplo de Uso

1. **Buscar livros pelo título**:
    - Digite `1` e pressione Enter.
    - Insira o título do livro que deseja buscar.
    - A aplicação fará uma consulta à API Gutendex e exibirá os resultados encontrados.

2. **Listar livros registrados no banco de dados**:
    - Digite `2` e pressione Enter.
    - A aplicação listará todos os livros registrados no banco de dados.

3. **Listar autores registrados no banco de dados**:
    - Digite `3` e pressione Enter.
    - A aplicação listará todos os autores dos livros registrados.

4. **Listar autores no banco de dados que estavam vivos em um determinado ano**:
    - Digite `4` e pressione Enter.
    - Insira o ano desejado.
    - A aplicação listará os autores que estavam vivos naquele ano.

5. **Listar livros em um determinado idioma**:
    - Digite `5` e pressione Enter.
    - Insira o número do idioma desejado (por exemplo, 1 para Inglês).
    - A aplicação listará todos os livros registrados no banco de dados naquele idioma.

6. **Encerrar a aplicação**:
    - Digite `0` e pressione Enter.
    - A aplicação será encerrada.

## 👩🏻‍💻 Equipe desenvolvedora
<a href="https://github.com/JilMayumiMoutinho"><img style="border-radius: 50%;" src="https://avatars.githubusercontent.com/u/104766367?v=4" width="100px;" alt="Foto da desenvolvedora com linkque encaminha ao github pessoal"/><br /><b>Jil Mayumi Moutinho</b></a>

## ✍️Contribuição

Se você deseja contribuir para o projeto, siga os passos abaixo:

1. Fork o repositório.
2. Crie uma nova branch: `git checkout -b minha-feature`.
3. Faça suas alterações e commite-as: `git commit -m 'Minha nova feature'`.
4. Envie para o repositório original: `git push origin minha-feature`.
5. Abra um Pull Request.

---
