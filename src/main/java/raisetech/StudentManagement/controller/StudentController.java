package raisetech.studentmanagement.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import raisetech.studentmanagement.controller.converter.Studentconverter;
import raisetech.studentmanagement.domain.StudentDetail;
import raisetech.studentmanagement.service.StudentService;
import raisetech.studentmanagement.data.Student;
import raisetech.studentmanagement.data.StudentsCourses;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/students")
public class StudentController {

    private StudentService studentService;  // インスタンス変数として StudentService を宣言
    private Studentconverter converter;

    @Autowired
    public StudentController(StudentService studentService, Studentconverter converter) {
        this.studentService = studentService;
        this.converter = converter;
    }


    @GetMapping("/studentList")
    public List<StudentDetail> getStudentList() {
        List<Student> students = studentService.searchStudentList();
        List<StudentsCourses> studentsCourses = studentService.searchStudentsCoursesList();

        return converter.convertStudentDetails(students, studentsCourses);
    }


}

//    @GetMapping("/studentsCoursesList")
//    public List<StudentsCourses> getStudentsCoursesList() {
//        return studentService.searchStudentsCoursesList();
//    }

//    @GetMapping("/student")
//    public List<Student> getStudentsInTheirThirtiesOrOlder() {
//    return studentService.searchStudentsInTheirThirtiesOrOlder();
//
//    }
//
//    @GetMapping("/courses")
//    public List<StudentsCourses> getsearchByName() {
//        return studentService.searchByName("Python");
//    }

