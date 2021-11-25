package com.junkie.injector.controllers;

import com.junkie.injector.controllers.mangers.IdManger;
import com.junkie.injector.models.operations.JunkieInjectionModel;
import com.junkie.injector.repository.JunkieInjectionRepo;
import com.junkie.injector.repository.JunkieRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.Instant;


@RestController
public class UserOps {
    @Autowired
    JunkieRepo junkieRep;
    @Autowired
    JunkieInjectionRepo junkieInjectionRepo;


    @Autowired
    IdManger idManger;
    @PostMapping("/inject")
    ResponseEntity<?> inject(@RequestBody JunkieInjectionModel junkieInjection){
        if(junkieInjection.getInjectedID() == null){
            return ResponseEntity.status(500).body("Missing Injected");
        }
        if(junkieInjection.getInjectorID() == null){
            junkieInjection.setInjectedID(junkieInjection.getInjectorID());
        }
        try{
            final Long temp;
            try{
                temp = idManger.getJunkieInjectionCount() + 1;
            }catch(Exception e){
                return ResponseEntity.status(505).body("Couldn't read data");
            }
            junkieInjection.setId(temp);
            junkieInjection.setTimeStamp(Instant.now());
            idManger.setJunkieInjectionCount(temp);
            junkieInjectionRepo.save(junkieInjection);
        }catch(Exception e){
            return ResponseEntity.status(505).body("Couldn't process the operation");
        }
        return ResponseEntity.status(200).body("OK");
    }
}
