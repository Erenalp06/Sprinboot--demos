package com.teksen.studentcruddemo.repository;

import com.teksen.studentcruddemo.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {
    // no need to type more code :)

    Optional<Student> findByFirstname(String firstname);
}
