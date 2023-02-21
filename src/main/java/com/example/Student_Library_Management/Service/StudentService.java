package com.example.Student_Library_Management.Service;

import com.example.Student_Library_Management.Enums.CardStatus;
import com.example.Student_Library_Management.Models.Card;
import com.example.Student_Library_Management.Models.Student;
import com.example.Student_Library_Management.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    @Autowired
    StudentRepository studentRepository;
    public String createStudent(Student student){

        Card card= new Card();
        card.setCardStatus(CardStatus.ACTIVATED);
        card.setStudentVariableName(student);

        student.setCard(card);

        studentRepository.save(student);//By cascading here saving the student, card is also saved.

        return "Student and card added";
    }

    public String findNameByEmail(String email){
        Student student = studentRepository.findByEmail(email);
        return student.getName();
    }

    public String updateMob(Student newStudent){
        Student originalStudent = studentRepository.findById(newStudent.getId()).get();
        originalStudent.setMobNo(newStudent.getMobNo());
        studentRepository.save(originalStudent);
        return "Student has been Update Successfully";
    }
}
