package com.junkie.injector.repository;

import com.junkie.injector.models.operations.JunkieInjectionModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface JunkieInjectionRepo extends MongoRepository<JunkieInjectionModel, Long> {
    @Query(value="{}",count = true)
    Long countById();
}
