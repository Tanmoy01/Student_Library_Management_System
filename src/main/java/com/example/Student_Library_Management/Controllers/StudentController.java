package com.example.Student_Library_Management.Controllers;

import com.example.Student_Library_Management.DTOs.StudentUpdateMobRequestDto;
import com.example.Student_Library_Management.Models.Student;
import com.example.Student_Library_Management.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping


public class StudentController {

    @Autowired
    StudentService studentService;

    @PostMapping("/add")
    public String createStudent(@RequestBody Student student){

        return studentService.createStudent(student);
    }

    @GetMapping("/get_user")
    public String getNameByEmail(@RequestParam("email") String email){
        return studentService.findNameByEmail(email);
    }

    @PutMapping("/update_mob")
    public String updateMob(@RequestBody StudentUpdateMobRequestDto studentReqtDto){
        return studentService.updateMob(studentReqtDto);
    }
}
