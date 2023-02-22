package com.example.Student_Library_Management.Repository;

import com.example.Student_Library_Management.Models.Transactions;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Transactions, Integer> {
}
