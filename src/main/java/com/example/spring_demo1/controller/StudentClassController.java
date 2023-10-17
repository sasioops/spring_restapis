package com.example.spring_demo1.controller;
import com.example.spring_demo1.dao.StudentDetailsDao;
import com.example.spring_demo1.bean.Students;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;


@RestController
public class StudentClassController {

    @Autowired
    StudentDetailsDao studentDetailsDao;




    @GetMapping("/get")
    public List <Students> getAllStudents(){
        return studentDetailsDao.getAllStudents();
    }

    @GetMapping("/getstudentsbyname")
    public List<Students> getStudentsByName(){
        return studentDetailsDao.getStudentsByName();
    }

    @GetMapping("/getStudentByUserName")
    public Students getStudentsByUserName(@RequestParam String userName){
        return studentDetailsDao.getStudentsByUserName(userName);
    }


    @GetMapping("/getstudents")
    public List<Map<String, Object>> getStudents(){
        return studentDetailsDao.getStudents();
    }

    @PostMapping("/insertstudent")
    public int addStudents(@RequestBody Students students){
        return studentDetailsDao.addStudents(students);
    }

    @PutMapping("/updatestudent/{rollNo}")
    public int updateStudent(@PathVariable int rollNo,@RequestBody Students students){
        return studentDetailsDao.updateStudent(rollNo,students);
    }

    @DeleteMapping("/deletestudent/{rollNo}")
    public int deleteStudent(@PathVariable int rollNo){
        return studentDetailsDao.deleteStudent(rollNo);
    }
}

