package com.junkfoood;

import com.junkfoood.model.entity.AccountEntity;
import com.junkfoood.reponsitory.AccountReponsitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@SpringBootApplication
public class JunkFooodApplication {

	public static void main(String[] args) {
		SpringApplication.run(JunkFooodApplication.class, args);
	}

}
