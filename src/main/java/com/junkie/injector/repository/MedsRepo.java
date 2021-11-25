package com.junkie.injector.repository;

import com.junkie.injector.models.meds.MedsModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface MedsRepo extends MongoRepository<MedsModel,Long> {
    @Query(value="{}",count = true)
    Long countById();

}
