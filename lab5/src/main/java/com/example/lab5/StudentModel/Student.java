package com.example.lab5.StudentModel;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Student {
    private int ID;
    private String name;
    private int age;
    private String degree;
    private double GPA;
}
