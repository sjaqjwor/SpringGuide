package com.example.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

	private static final Logger log = LoggerFactory.getLogger(DemoApplication.class);

	public static void main(String[] args)
	{
		SpringApplication.run(DemoApplication.class, args);
	}
//	@Bean
//	public CommandLineRunner demo(CustomerRepository repository) {
//		return (args) -> {
//			repository.save(new Customer("Jack", "Bauer"));
//			repository.save(new Customer("Chloe", "O'Brian"));
//			repository.save(new Customer("Kim", "Bauer"));
//			repository.save(new Customer("David", "Palmer"));
//			repository.save(new Customer("Michelle", "Dessler"));
//
//			for (Customer customer : repository.findAll()) {
//				log.info(customer.toString());
//			}
//
//			repository.findById(1L)
//					.ifPresent(customer -> {
//						log.info(customer.toString());
//
//					});
//
//			repository.findByLastName("Bauer").forEach(bauer -> {
//				log.info(bauer.toString());
//			});
//		};
//	}

	@Autowired
	SawonRepository sawonRepository;

	@Autowired
	HobbyRepository hobbyrepositoty;

	@Transactional
	public void run(String ...agrs){
		System.err.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
		System.err.println();
		save();
		sawonRepository.flush();
		deleteSawon();
		sawonRepository.flush();
		updateSawon();
		sawonRepository.flush();
		deleteSawonHobby();
	}
	void save() {
		List<Hobby> list = new ArrayList<>();
		list.add(new Hobby("취미1"));
		list.add(new Hobby("취미2"));

		Sawon s1 = new Sawon("1길동", list);
		list=new ArrayList<>();
		list.add(new Hobby("취미3"));
		Sawon s2 = new Sawon("2길동",list);
		sawonRepository.save(s1);
		sawonRepository.save(s2);
		for(Sawon s : sawonRepository.findAll()) {
			System.err.println(s.toString());
		}
	}

	void deleteSawon(){
		Sawon s2 = sawonRepository.getOne(2L);
		log.info("삭제될 사원 => " + s2.toString());
		sawonRepository.delete(s2);
	}
	void updateSawon(){
		Sawon s1 = sawonRepository.getOne(1L);
		log.info("수정될 사원 => " +s1.toString());
		s1.getHobbies().add(new Hobby("취미4"));
		s1.setName("11길동");
		sawonRepository.save(s1);
	}
	void deleteSawonHobby(){
		Sawon s1 = sawonRepository.getOne(1L);
		Hobby h1 = hobbyrepositoty.getOne(1L);
		if (s1.getHobbies().contains(h1))
			s1.getHobbies().remove(h1);
		sawonRepository.save(s1);
	}
}
