package bootstrap;


import model.Author;
import model.Book;
import model.Publisher;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import repositories.AuthorRepository;
import repositories.BookRepository;
import repositories.PublisherRepository;

@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        Author gaone = new Author("td","jakes");
        Book soar = new Book( "good","123");

        Publisher publisher = new Publisher();
        publisher.setName("black");

        gaone.getBooks().add(soar);
        soar.getAuthors().add(gaone);

        soar.setPublisher(publisher);
        publisher.getBooks().add(soar);

        authorRepository.save(gaone);
        bookRepository.save(soar);
        publisherRepository.save(publisher);

        //Chinua
        Author chinua = new Author("Chinua", "Achebe");
        Book fallapart = new Book ("things fall apart", "88880" );
        chinua.getBooks().add(fallapart);

        //noEJB.setPublisher(publisher);
        // publisher.getBooks().add(noEJB);

        //authorRepository.save(noEJB);
        System.out.println("Number of books:" + bookRepository.count());
        System.out.println("Publisher number of books:" + publisher.getBooks().size());

    }
}

