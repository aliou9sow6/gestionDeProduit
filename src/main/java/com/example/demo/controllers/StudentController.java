package com.example.demo.controllers;

import com.example.demo.models.Student;
import com.example.demo.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@RestController
@RequestMapping(path = "/api/v1/student")
public class StudentController {
  private final StudentService studentService;

  @Autowired
  public StudentController(StudentService studentService) {
    this.studentService = studentService;
  }

  @GetMapping("/")
  public List<Student> getStudents(){
    return studentService.getStudents();
  }
  @GetMapping("/students-page")
  public Page<Student> getStudentsByPage(@RequestParam(defaultValue = "0") int page,
                                         @RequestParam(defaultValue = "2") int size){
    return studentService.getAllStudents(page, size);
  }

  @PostMapping("/students")
  public Student addStudent(@RequestBody Student student){
    if (student != null){
      return new ResponseEntity<>(studentService.saveStudent(student), HttpStatus.ACCEPTED).getBody();
    } else {
      return new ResponseEntity<Student>(HttpStatus.INTERNAL_SERVER_ERROR).getBody();
    }
  }
}
