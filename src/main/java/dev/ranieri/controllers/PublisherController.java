package dev.ranieri.controllers;

import dev.ranieri.entities.Publisher;
import dev.ranieri.repos.PublisherRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin("*")
public class PublisherController {

    @Autowired
    PublisherRepo publisherRepo;

    @GetMapping("/publishers")
    public List<Publisher> getAllPublishers(){
        return  publisherRepo.findAll();
    }


}
