package com.example.Student_Library_Management.Service;
import java.util.*;
import com.example.Student_Library_Management.Models.Author;
import com.example.Student_Library_Management.Models.Book;
import com.example.Student_Library_Management.Repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

public class BookService {

    @Autowired
    AuthorRepository authorRepository;

    public String addBook(Book book){
        int authorId= book.getAuthor().getId();
        Author author = authorRepository.findById(authorId).get();
        book.setAuthor(author);
        List<Book> currentBooksWritten = author.getBooksWritten();
        currentBooksWritten.add(book);
        author.setBooksWritten(currentBooksWritten);

        authorRepository.save(author);
        return "Book added Successfully";
    }
}
