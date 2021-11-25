package com.junkie.injector.controllers;

import com.junkie.injector.controllers.mangers.IdManger;
import com.junkie.injector.models.junkie.JunkieModel;
import com.junkie.injector.models.meds.MedsModel;
import com.junkie.injector.repository.JunkieRepo;
import com.junkie.injector.repository.MedsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.Instant;

@RestController
public class AddOps {
    @Autowired
    JunkieRepo junkieRep;
    @Autowired
    MedsRepo medsRepo;
    @Autowired
    IdManger idManger;

    @PostMapping("/junkie")
    JunkieModel newJunkie(@RequestBody JunkieModel newGuy){
        Long count = idManger.getJunkieCount();
        idManger.setJunkieCount(count+1);
        newGuy.setId(count+1);
        newGuy.setTimeStamp(Instant.now());
        junkieRep.save(newGuy);
        return newGuy;
    }

    @PostMapping("/addMeds")
    MedsModel newMed(@RequestBody MedsModel newMed){
        System.out.println("ww");
        Long count = idManger.getMedsCount() + 1;
        newMed.setId(count);
        medsRepo.save(newMed);
        idManger.setMedsCount(count);
        return newMed;
    }
}
