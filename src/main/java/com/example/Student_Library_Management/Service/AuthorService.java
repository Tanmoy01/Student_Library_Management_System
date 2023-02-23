package com.example.Student_Library_Management.Service;

import com.example.Student_Library_Management.DTOs.AuthorEntryDto;
import com.example.Student_Library_Management.DTOs.AuthorResponseDto;
import com.example.Student_Library_Management.DTOs.BookResponseDto;
import com.example.Student_Library_Management.Models.Author;
import com.example.Student_Library_Management.Models.Book;
import com.example.Student_Library_Management.Repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service

public class AuthorService {

    @Autowired
    AuthorRepository authorRepository;
    public String createAuthor(AuthorEntryDto authorEntryDto){

        Author author= new Author();
        author.setName(authorEntryDto.getName());
        author.setAge(authorEntryDto.getAge());
        author.setCountry(authorEntryDto.getCountry());
        author.setRating(authorEntryDto.getRating());
        authorRepository.save(author);
        return "Author added successfully";
    }

    public AuthorResponseDto getAuthor(Integer authorId){

        Author author= authorRepository.findById(authorId).get();

        AuthorResponseDto authorResponseDto= new AuthorResponseDto();

        List<Book> bookList = author.getBooksWritten();

        List<BookResponseDto> booksWrittenDto= new ArrayList<>();

        for(Book b : bookList){
            BookResponseDto bookResponseDto= new BookResponseDto();
            bookResponseDto.setGenre(b.getGenre());
            bookResponseDto.setPages(b.getPages());
            bookResponseDto.setName(b.getName());

            booksWrittenDto.add(bookResponseDto);
        }

        authorResponseDto.setBooksWritten(booksWrittenDto);
        authorResponseDto.setName(author.getName());
        authorResponseDto.setAge(author.getAge());
        authorResponseDto.setRatings(author.getRating());

        return authorResponseDto;
    }
}
