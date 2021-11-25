package com.junkie.injector.repository;
import com.junkie.injector.models.junkie.JunkieModel;
import com.junkie.injector.models.operations.JunkieInjectionModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.time.Instant;
import java.util.*;

@Repository
public class JunkieInjectionCustomRepo  {
    @Autowired
    MongoTemplate mongoTemplate;

    public List<String> getAllOrOneJunkiesOpsInfo(Long junkieID,int skip,int limit){
        HashSet<Long> totalIds = new HashSet<Long>();
        HashMap<Long,JunkieModel> myJunkies = new HashMap<Long, JunkieModel>();
        Query query = new Query();
        if(junkieID != -1L){
            query.addCriteria(
                    Criteria.where("injectorID").is(junkieID)
                            .orOperator(Criteria.where("injectedID").is(junkieID)));
        }
        List<JunkieInjectionModel> injections = mongoTemplate
                .find(new Query()
                        .skip(skip)
                        .limit(limit)
                        , JunkieInjectionModel.class);
        for( JunkieInjectionModel item: injections){
            totalIds.add(item.getInjectedID());
            totalIds.add(item.getInjectorID());
        }
        List<Long> idList = new ArrayList<>(totalIds);
        Query getJunkiesFromList = new Query();
        getJunkiesFromList.addCriteria(Criteria.where("_id").in(idList));
        List<JunkieModel> junkies = mongoTemplate
                .find(getJunkiesFromList,JunkieModel.class);
        for(JunkieModel junkie : junkies){
            myJunkies.put(junkie.getId(),junkie);
        }
        List<String> response = new ArrayList<>();
        for(JunkieInjectionModel injection : injections){
            final Long injectorID = injection.getInjectorID();
            final Long injectedID = injection.getInjectedID();
            final Instant timestamp = injection.getTimeStamp();
            if(Objects.equals(injectedID, injectorID)){
                //Self injection
                response.add("\"" + myJunkies.get(injectedID).getName() +
                        "\" has injected himself by the time of " +
                        timestamp);
            }else{
                response.add("\""+myJunkies.get(injectorID).getName() +
                        "\" has injected \""+ myJunkies.get(injectedID).getName() +
                        "\" by the time of "+ timestamp);
            }
        }
        return response;
    }

}
