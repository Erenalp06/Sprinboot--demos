package com.teksen.studentcruddemo.service;

import com.teksen.studentcruddemo.entity.Student;

import java.util.List;
import java.util.Optional;

public interface StudentService {
    List<Student> findAll();

    Student findById(Integer theId);

    Student save(Student theStudent);

    void deleteById(Integer theId);

    Student findByFirstname(String firstname);
}
