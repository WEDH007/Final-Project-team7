package com.bookstore.browsing.Publisher;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class PublisherService {

    private final PublisherRepository publisherRepository;

    @Autowired
    public PublisherService(PublisherRepository publisherRepository) {
        this.publisherRepository = publisherRepository;
    }

    public List<Publisher> getAllPublishers() {
        return publisherRepository.findAll();
    }

//    public Optional<Publisher> getPublisherById(int id) {
//        return publisherRepository.findById(id);
//    }
    
    public Publisher getPublisherById(int publisherId) {
        return publisherRepository.findById(publisherId).orElse(null);
    }

    public Publisher savePublisher(Publisher publisher) {
        return publisherRepository.save(publisher);
    }

    public void deletePublisher(int id) {
        publisherRepository.deleteById(id);
    }
}
