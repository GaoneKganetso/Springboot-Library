package bootstrap;


import model.Author;
import model.Book;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import repositories.AuthorRepository;
import repositories.BookRepository;

@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        Author gaone = new Author("soar","divine");
        Book soar = new Book( "good","123");
        gaone.getBooks().add(soar);
        soar.getAuthors().add(gaone);

        authorRepository.save(gaone);
        bookRepository.save(soar);
    }
}

