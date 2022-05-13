package dev.ranieri.PleasantSpring;

import dev.ranieri.entities.Publisher;
import dev.ranieri.repos.PublisherRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class PublisherRepoTests {

    @Autowired
    PublisherRepo publisherRepo;

    @Test
    void createPublisher(){
        Publisher publisher = new Publisher(0,"Watermill production","FL");
        publisherRepo.save(publisher);
        Assertions.assertNotEquals(0,publisher.getId());

    }
}
