package com.example.Student_Library_Management.Service;
import java.util.*;

import com.example.Student_Library_Management.DTOs.BookReqDto;
import com.example.Student_Library_Management.Models.Author;
import com.example.Student_Library_Management.Models.Book;
import com.example.Student_Library_Management.Repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

public class BookService {

    @Autowired
    AuthorRepository authorRepository;

    public String addBook(BookReqDto bookReqDto){
        int authorId= bookReqDto.getAuthorId();
        Author author = authorRepository.findById(authorId).get();

        Book book= new Book();

        book.setGenre(bookReqDto.getGenre());
        book.setIssued(false);
        book.setName(bookReqDto.getName());
        book.setPages(bookReqDto.getPages());

        book.setAuthor(author);
        List<Book> currentBooksWritten = author.getBooksWritten();
        currentBooksWritten.add(book);
        author.setBooksWritten(currentBooksWritten);

        authorRepository.save(author);
        return "Book added Successfully";
    }
}
