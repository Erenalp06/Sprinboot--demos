package com.teksen.studentcruddemo.service;

import com.teksen.studentcruddemo.entity.Student;
import com.teksen.studentcruddemo.repository.StudentRepository;
import com.teksen.studentcruddemo.rest.StudentNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService{

    private final StudentRepository theStudentRepository;

    public StudentServiceImpl(StudentRepository theStudentRepository) {
        this.theStudentRepository = theStudentRepository;
    }

    @Override
    public List<Student> findAll() {
        return theStudentRepository.findAll();
    }

    @Override
    public Student findById(Integer theId) {
        Optional<Student> studentOptional = theStudentRepository.findById(theId);
        Student theStudent = null;
        if(studentOptional.isPresent()){
            theStudent = studentOptional.get();
        }else{
            throw new StudentNotFoundException("student with id not found - " + theId);
        }
        return theStudent;
    }

    @Override
    public Student save(Student theStudent) {
        return theStudentRepository.save(theStudent);
    }

    @Override
    public void deleteById(Integer theId) {
        theStudentRepository.deleteById(theId);

    }

    @Override
    public Student findByFirstname(String firstname) {
        Optional<Student> studentOptional = theStudentRepository.findByFirstname(firstname);
        Student theStudent = null;
        if(studentOptional.isPresent()){
            theStudent = studentOptional.get();
        }else{
            throw new StudentNotFoundException("student not found with firstname - " + firstname);
        }
        return theStudent;
    }




}
