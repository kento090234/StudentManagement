package raisetech.StudentManagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import raisetech.StudentManagement.data.Student;
import raisetech.StudentManagement.service.StudentService;
import raisetech.StudentManagement.data.StudentsCourses;

import java.util.List;


@RestController
@RequestMapping("/students")
public class StudentController {

    private  StudentService studentService;  // インスタンス変数として StudentService を宣言

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }


    @GetMapping("/studentList")
    public List<Student> getStudentList() {
        return studentService.searchStudentList();
    }


    @GetMapping("/studentsCoursesList")
    public List<StudentsCourses> getStudentsCoursesList() {
        return studentService.searchStudentsCoursesList();
    }


    @GetMapping("/student")
    public List<Student> getStudentsInTheirThirtiesOrOlder() {
        return studentService.searchStudentsInTheirThirtiesOrOlder();
    }


    @GetMapping("/courses/java")
    public List<StudentsCourses> getJavaCourses() {
        return studentService.findByCourseNameContaining("Java");
    }

}
