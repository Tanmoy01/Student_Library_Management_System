package com.example.Student_Library_Management.Repository;

import com.example.Student_Library_Management.Models.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface AuthorRepository extends JpaRepository<Author, Integer> {
}
