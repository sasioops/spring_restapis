package com.example.spring_demo1.bean;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;
import org.springframework.stereotype.Component;

@Table(name = "students")

public class Students {
    @Id
    private static String firstName;
    private static String lastName;

    private static int rollNo;

    public static int getRollNo() {
        return rollNo;
    }

    public static void setRollNo(int rollNo) {
        Students.rollNo = rollNo;
    }

    public static String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public static String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
