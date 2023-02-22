package com.example.Student_Library_Management.Controllers;

import com.example.Student_Library_Management.DTOs.IssueBookReqDto;
import com.example.Student_Library_Management.Service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/transaction")
public class TransactionController {

    @Autowired
    TransactionService transactionService;

    @PostMapping("issueBook")
    public String issueBook(@RequestBody IssueBookReqDto issueBookReqDto){
        return transactionService.issueBook(issueBookReqDto);
    }
}
