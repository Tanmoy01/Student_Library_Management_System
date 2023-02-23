package com.example.Student_Library_Management.Controllers;

import com.example.Student_Library_Management.DTOs.IssueBookReqDto;
import com.example.Student_Library_Management.Service.TransactionService;
import jakarta.persistence.GeneratedValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/transaction")
public class TransactionController {

    @Autowired
    TransactionService transactionService;

    @PostMapping("issueBook")
    public String issueBook(@RequestBody IssueBookReqDto issueBookReqDto){
        try {
            return transactionService.issueBook(issueBookReqDto);
        }catch (Exception e){
            return e.getMessage();
        }
        
    }

    @GetMapping("/getTxnInfo")
    public String getTransactionEntry(@RequestParam("bookId") Integer bookId,
                                      @RequestParam("cardId") Integer cardId){
        return transactionService.getTransactions(bookId, cardId);
    }
}
