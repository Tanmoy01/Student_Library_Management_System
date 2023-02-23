package com.example.Student_Library_Management.Service;

import com.example.Student_Library_Management.DTOs.IssueBookReqDto;
import com.example.Student_Library_Management.Enums.CardStatus;
import com.example.Student_Library_Management.Enums.TransactionStatus;
import com.example.Student_Library_Management.Models.Book;
import com.example.Student_Library_Management.Models.Card;
import com.example.Student_Library_Management.Models.Transactions;
import com.example.Student_Library_Management.Repository.BookRepository;
import com.example.Student_Library_Management.Repository.CardRepository;
import com.example.Student_Library_Management.Repository.TransactionRepository;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class TransactionService {

    @Autowired
    TransactionRepository transactionRepository;

    @Autowired
    BookRepository bookRepository;

    @Autowired
    CardRepository cardRepository;

    public String issueBook(IssueBookReqDto issueBookReqDto) throws Exception{

        int bookId= issueBookReqDto.getBookId();
        int cardId= issueBookReqDto.getCardId();

        Book book= bookRepository.findById(bookId).get();
        Card card= cardRepository.findById(cardId).get();

        Transactions transactions= new Transactions();

        //setting the attribute
        transactions.setBook(book);
        transactions.setCard(card);
        transactions.setTransactionId(UUID.randomUUID().toString());
        transactions.setIssueOperation(true);
        transactions.setTransactionStatus(TransactionStatus.PENDING);

        //attribute left is success/fail
        //Check for validation
        if(book == null || book.isIssued()== true){
            transactions.setTransactionStatus(TransactionStatus.FAILED);
            transactionRepository.save(transactions);
            throw new Exception("Book is not available");
        }
       if(card == null || card.getCardStatus() != CardStatus.ACTIVATED){
           transactions.setTransactionStatus(TransactionStatus.FAILED);
           transactionRepository.save(transactions);
           throw new Exception("Card is not valid");
       }

       transactions.setTransactionStatus(TransactionStatus.SUCCESS);

       //set the attributed of book
        book.setIssued(true);
        //bw the book and transaction
        List<Transactions> listOfTransactionForBook = book.getListOfTransaction();
        listOfTransactionForBook.add(transactions);
        book.setListOfTransaction(listOfTransactionForBook);

        //need to make changes in the card
        //book and the card
        List<Book> issuedBooksForCard = card.getBooksIssued();
        issuedBooksForCard.add(book);
        card.setBooksIssued(issuedBooksForCard);

        //bw card and the transaction
        List<Transactions> transactionListForCard= card.getTransactionsList();
        transactionListForCard.add(transactions);
        card.setTransactionsList(transactionListForCard);

        //save parent
        cardRepository.save(card);

        return "Book issued succefully";
    }

    public String getTransactions(int bookId, int cardId){
        List<Transactions> transactionsList= transactionRepository.getTransactionForBookAndCard(bookId,cardId);
        String transactionId= transactionsList.get(0).getTransactionId();
        return transactionId;
    }
}
