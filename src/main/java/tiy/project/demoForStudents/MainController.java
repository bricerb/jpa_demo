package tiy.project.demoForStudents;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
public class MainController {

    @Autowired
    StudentRepository students;

    @PostMapping(path = "/api")
    public String testApi() {
        System.out.println("hit endpoint");
        return "working endpoint";
    }

    @PostMapping(path = "/api/student/new")
    public String newStudent(@RequestBody Student student) {
        students.save(student);
        return "Ok";
    }

    @GetMapping(path = "/api/student")
    public Student findStudent(@RequestParam int id) {
        Student student = students.findOne(id);
        System.out.println(student);
        return student;
    }

    @GetMapping(path = "/api/students")
    public List<Student> findStudents() {
        List<Student> studentList = new ArrayList<>();
        students.findAll().forEach(student -> studentList.add(student));
        return studentList;
    }

}
