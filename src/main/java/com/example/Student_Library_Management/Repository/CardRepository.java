package com.example.Student_Library_Management.Repository;

import com.example.Student_Library_Management.Models.Card;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CardRepository extends JpaRepository<Card, Integer> {
}
