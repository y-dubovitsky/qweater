package space.dubovitsky.library.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import space.dubovitsky.library.dao.PublisherDao;
import space.dubovitsky.library.domain.Publisher;
import space.dubovitsky.library.spring.repos.PublisherRepository;

import java.util.List;

@Service
public class PublisherService implements PublisherDao {

    @Autowired
    private PublisherRepository publisherRepository;

    @Override
    public Publisher get(long id) {
        return publisherRepository.getOne(id);
    }

    @Override
    public Publisher save(Publisher p) {
        if (p != null) {
            return publisherRepository.save(p);
        } else { //TODO Реализовать иначе
            throw new RuntimeException("Exception in public Publisher save(Publisher p)");
        }
    }

    @Override
    public void delete(Publisher p) {
        publisherRepository.delete(p);
    }

    @Override
    public List<Publisher> getAll() {
        return publisherRepository.findAll();
    }

    @Override
    public List<Publisher> search(String... searchString) {
        return publisherRepository.findByNameContainingIgnoreCaseOrderByName(searchString[0]);
    }

    @Override
    public List<Publisher> getAll(Sort sort) {
        List<Publisher> all = publisherRepository.findAll(sort);
        return all;
    }

    @Override
    public Page<Publisher> getAll(int pageNumber, int pageSize, String sortField, Sort.Direction sortDirection) {
        Page<Publisher> all = publisherRepository.findAll(PageRequest.of(pageNumber, pageSize, sortDirection, sortField));
        return all;
    }

    @Override
    public Page<Publisher> search(int pageNumber, int pageSize, String sortField, Sort.Direction sortDirection, String... searchString) {
        Page<Publisher> byNameContainingIgnoreCaseOrderByName = publisherRepository.findByNameContainingIgnoreCaseOrderByName(PageRequest.of(pageNumber, pageSize), Sort.by(sortDirection), searchString);
        return byNameContainingIgnoreCaseOrderByName;
    }
}
