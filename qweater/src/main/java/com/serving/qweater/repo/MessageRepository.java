package com.serving.qweater.repo;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

import com.serving.qweater.entity.Message;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface MessageRepository extends CrudRepository<Message, Integer> {

    /**
     * https://docs.spring.io/spring-data/jpa/docs/current/reference/html/
     * Find messages by tag
     * @param tags - message tag
     * @return
     */
    List<Message> findByTags(String tags);

}