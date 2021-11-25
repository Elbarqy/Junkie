package com.junkie.injector.controllers;

import com.junkie.injector.models.junkie.JunkieModel;
import com.junkie.injector.models.meds.MedsModel;
import com.junkie.injector.repository.JunkieInjectionCustomRepo;
import com.junkie.injector.repository.JunkieInjectionRepo;
import com.junkie.injector.repository.JunkieRepo;
import com.junkie.injector.repository.MedsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class info {
    @Autowired
    JunkieRepo junkieRep;
    @Autowired
    MedsRepo medsRep;
    @Autowired
    JunkieInjectionRepo junkieInjectionRepo;
    @Autowired
    JunkieInjectionCustomRepo junkieInjectionCustomRepo;


    @GetMapping("/junkies")
    List<JunkieModel> AllJunkies(){
        return junkieRep.findAll();
    }
    @GetMapping("/junkie/{id}")
    Optional<JunkieModel> OneJunkie(@PathVariable Long id){
        return junkieRep.findById(id);
    }
    @GetMapping("/meds")
    List<MedsModel> AllMeds(){
        return medsRep.findAll();
    }
    @GetMapping("/meds/{id}")
    Optional<MedsModel> OneMed(@PathVariable Long id){return medsRep.findById(id);}
    @GetMapping("/injectionLogs/{skip}")
    List<String> allInjections(@PathVariable int skip){
        return junkieInjectionCustomRepo.getAllOrOneJunkiesOpsInfo(-1L,skip,10);
    }
    @GetMapping("/injectionLogOf/{id}")
    List<String> injectionOf(@PathVariable Long id, @RequestParam int skip){
        return junkieInjectionCustomRepo.getAllOrOneJunkiesOpsInfo(id, skip, 10);
    }
}
