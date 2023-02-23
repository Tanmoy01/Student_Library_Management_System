package com.example.Student_Library_Management.Controllers;

import com.example.Student_Library_Management.DTOs.AuthorEntryDto;
import com.example.Student_Library_Management.DTOs.AuthorResponseDto;
import com.example.Student_Library_Management.Models.Author;
import com.example.Student_Library_Management.Service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("author")

public class AuthorController {

    @Autowired
    AuthorService authorService;


    @PostMapping("/add")
    public String addAuthor(@RequestBody AuthorEntryDto authorEntryDto){
      return authorService.createAuthor(authorEntryDto);

    }

    @GetMapping("/getAuthor")
    public AuthorResponseDto getAuthor(@RequestParam("authorId") Integer authorId){
        return authorService.getAuthor(authorId);
    }

}
