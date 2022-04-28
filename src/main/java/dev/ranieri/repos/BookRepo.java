package dev.ranieri.repos;

import dev.ranieri.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@Component
@Repository// stereotype that says what this component is
// a repository component is sued to perform crud operations with the database
// <entity,primary-key type>
public interface BookRepo extends JpaRepository<Book,Integer> {

    // Spring data will use reflection to create implementation of custom methods
    List<Book> findBooksByTitle(String title);
    List<Book> findBooksByAuthor(String author);

}
