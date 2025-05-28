package com.example.demo.student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import static java.time.Month.JANUARY;


@Configuration
public class StudentConfig {

    @Bean
    CommandLineRunner commandLineRunner(
            StudentRepository repository) {
        return args -> {
            Student kipruto = new Student(
                    "Kipruto",
                    "kipruto@gmail.com",
                    LocalDate.of(2000, JANUARY, 4)
            );

            Student mike = new Student(
                    "Mike",
                    "Mike@gmail.com",
                    LocalDate.of(2009, JANUARY, 14)
            );

            repository.saveAll(
                    List.of(kipruto, mike)
            );
        };
    }
}
