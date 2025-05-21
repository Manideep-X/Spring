package com.sixthjava.project.restfulapi.rest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.sixthjava.project.restfulapi.entity.Student;

import jakarta.annotation.PostConstruct;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class BasicRest {
    
    // @PostConstruct marks a method to run after all beans are created and all dependencies are injected.
    // @PreDestroy marks the method to run before the Spring container destroys the beans.
    @PostConstruct
    private List<Student> allDetails() {

        List<Student> allStudents = new ArrayList<>();
    
        allStudents.add(new Student("Manideep", "Bhattacharyya"));
        allStudents.add(new Student("Todoroki", "Yaomi"));
        allStudents.add(new Student("Saito", "Yamada"));
        allStudents.add(new Student("Tenkuji", "Kenji"));

        return allStudents;        
    }

    @GetMapping("/rest")
    public String getMethodName() {
        return "<h1 style=\"text-align:center;\">Rest controller is working as expected</h1>";
    }
    
    @GetMapping("/students")
    public List<Student> getStudents() {
        return allDetails();
    }

    @GetMapping("/students/{studentId}") // inside the curly braces it is path variable placeholder.
    public Student getStudentById(@PathVariable int studentId) {
        // @PathVariable binds the parameter with the path variable placeholder.
        // Placeholder name should be equal to the parameter name.
        // Alternate approach: (@PathVariable("studentId") int id)

        Student theStudent;
        try {
            theStudent = allDetails().get(studentId-1);
        } catch (Exception e) {
            throw new StudentNotFoundException("Student is NOT FOUND ! [ID: "+studentId+"]", e);
        }

        return theStudent;

    }
    

    @GetMapping("/database")
    public String getStudentsDB() {
        return "Not yet updated";
    }
    
}
