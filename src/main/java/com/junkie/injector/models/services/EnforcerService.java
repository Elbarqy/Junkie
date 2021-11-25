package com.junkie.injector.models.services;

import com.junkie.injector.repository.JunkieRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class EnforcerService {
    @Autowired
    private JunkieRepo junkieRepo;
//    @Resource(name= "idApplicationScopedManger")
//    IDMangerData idMangerData;

    public EnforcerService( ) {}

    public void updateLastIds(){
        Long idCount = junkieRepo.countById();
//        idMangerData.setJunkiesCount(idCount);
    }
    //increase ID sequence and return it then update it in the idMangerData
    //TODO refactor by polymorphism

}
