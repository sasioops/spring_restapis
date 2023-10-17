package com.example.spring_demo1.dao;

import com.example.spring_demo1.bean.Students;

import java.util.List;
import java.util.Map;

public interface StudentDetailsDao {
    List<Students> getAllStudents();

    List<Students> getStudentsByName();



    Students getStudentsByUserName(String userName);

    List<Map<String, Object>> getStudents();


    int addStudents(Students students);

    int updateStudent(int rollNo,Students students);

    int deleteStudent(int rollNo);
}
