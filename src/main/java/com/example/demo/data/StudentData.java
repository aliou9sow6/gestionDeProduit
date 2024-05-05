package com.example.demo.data;

import com.example.demo.models.Student;
import com.example.demo.repositories.StudentRepository;
import com.example.demo.services.StudentService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class StudentData {

  @Bean
  CommandLineRunner commandLineRunner(StudentRepository studentRepository){
    return args -> {
      Student moussa = new Student(
              1L,
              "Moussa",
              "moussa@gmail.com",
              LocalDate.of(2000, Month.JANUARY, 12),
              24
      );
      Student ousmane = new Student(
              2L,
              "ousmane",
              "ousmane@gmail.com",
              LocalDate.of(2004, Month.APRIL, 30),
              20
      );
      Student awa = new Student(
              3L,
              "awa",
              "awa@gmail.com",
              LocalDate.of(2005, Month.APRIL, 30),
              23
      );
      studentRepository.saveAll(
              List.of(moussa, ousmane, awa)
      );
    };
  }
}
