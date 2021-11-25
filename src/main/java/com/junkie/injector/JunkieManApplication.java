package com.junkie.injector;

import com.junkie.injector.controllers.mangers.IdManger;
import com.junkie.injector.models.services.EnforcerService;
import com.junkie.injector.repository.JunkieInjectionRepo;
import com.junkie.injector.repository.JunkieRepo;
import com.junkie.injector.repository.MedsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JunkieManApplication implements CommandLineRunner {
	@Autowired
	private EnforcerService junkieService;
	public static void main(String[] args) {
		SpringApplication.run(JunkieManApplication.class, args);
	}

	@Autowired
	IdManger idManger;
	@Autowired
	JunkieRepo junkieRepo;
	@Autowired
	MedsRepo medsRepo;
	@Autowired
	JunkieInjectionRepo junkieInjectionRepo;
	@Override
	public void run(String[] args){
		Long count = junkieRepo.countById();
		idManger.setJunkieCount(count);
		count = medsRepo.countById();
		idManger.setMedsCount(count);
		count = junkieInjectionRepo.countById();
		idManger.setJunkieInjectionCount(count);
	}
}
