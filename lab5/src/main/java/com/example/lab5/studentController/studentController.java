package com.example.lab5.studentController;

import com.example.lab5.API.ApiResponse;
import com.example.lab5.StudentModel.Student;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/student")
public class studentController {

    ArrayList<Student> students = new ArrayList<>();

    @GetMapping("/get")
    public ArrayList<Student> DisplayStudents(){
        return students;
    }

    @PutMapping("/update/{index}")
    public ApiResponse updateStudent(@RequestBody Student student, @PathVariable int index){
        students.set(index, student);

        return new ApiResponse("Student Updated Successfully", "200");
    }

    @GetMapping("/delete/{index}")
    public ApiResponse deleteStudent(@PathVariable int index){
        students.remove(index);
        return new ApiResponse("Student Deleted Successfully", "200");
    }

    @PostMapping("/add")
    public ApiResponse addStudent(@RequestBody Student student){
        students.add(student);
        return new ApiResponse("Student Added Successfully", "200");
    }


    @GetMapping("/honors/{index}")
    public ArrayList<Student> honorsStudentList(@PathVariable int index){
        ArrayList<ArrayList<Student>> allStudentsWithHonors = new ArrayList<>();
        ArrayList<Student> firstHonor = new ArrayList<>();
        ArrayList<Student> secondHonor = new ArrayList<>();


        for(Student s : students){

            if (s.getGPA() >= 4.75){
                firstHonor.add(s);
            }
            else if (s.getGPA() >= 4.50 && s.getGPA() < 4.75){
                secondHonor.add(s);
            }
        }
        allStudentsWithHonors.add(firstHonor);
        allStudentsWithHonors.add(secondHonor);

        return allStudentsWithHonors.get(index);
    }

    @GetMapping("/greaterthanaverage")
    public ArrayList<Student>  greaterThanAverage(){
        ArrayList<Student> greaterThanAverage = new ArrayList<>();
        double sum = 0;
        int count = 0;

        for(Student s : students){
            sum += s.getGPA();
            count++;
        }
        double average = sum/count;

        for(Student s : students){
            if(s.getGPA() > average){
                greaterThanAverage.add(s);
            }
        }
        return greaterThanAverage;
    }



}
