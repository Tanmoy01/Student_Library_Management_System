package com.example.Student_Library_Management.Service;

import com.example.Student_Library_Management.DTOs.IssueBookReqDto;
import com.example.Student_Library_Management.Repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransactionService {

    @Autowired
    TransactionRepository transactionRepository;

    public String issueBook(IssueBookReqDto issueBookReqDto){
        return "";
    }
}
