package com.example.Student_Library_Management.Repository;

import com.example.Student_Library_Management.Models.Transactions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TransactionRepository extends JpaRepository<Transactions, Integer> {

    @Query(value = "select * from transactions t where t.book_Id=:bookId and t.card_Id=:cardId and is_issue_operation=true",
    nativeQuery = true)
    List<Transactions>getTransactionForBookAndCard(int bookId, int cardId);
}
