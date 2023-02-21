package com.example.Student_Library_Management.Repository;

import com.example.Student_Library_Management.Models.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.*;

public interface StudentRepository extends JpaRepository<Student, Integer> {

    Student findByEmail(String email);

    List<Student> findByCountry(String country);
}
