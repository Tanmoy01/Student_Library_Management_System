package com.example.Student_Library_Management.Repository;

import com.example.Student_Library_Management.Models.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface BookRepository extends JpaRepository<Book, Integer> {
}
