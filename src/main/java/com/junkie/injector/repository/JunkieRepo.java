package com.junkie.injector.repository;

import com.junkie.injector.models.junkie.JunkieModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface JunkieRepo extends MongoRepository<JunkieModel , Long> {
    @Query(value="{}",count = true)
    Long countById();
}
