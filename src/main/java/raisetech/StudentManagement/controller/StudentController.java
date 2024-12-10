package raisetech.StudentManagement.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import raisetech.StudentManagement.controller.converter.StudentConverter;
import raisetech.StudentManagement.domain.StudentDetail;
import raisetech.StudentManagement.service.StudentService;
import raisetech.StudentManagement.data.Student;
import raisetech.StudentManagement.data.StudentsCourses;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class StudentController {

    private StudentService studentService;  // インスタンス変数として StudentService を宣言
    private StudentConverter converter;

    @Autowired
    public StudentController(StudentService studentService, StudentConverter converter) {
        this.studentService = studentService;
        this.converter = converter;
    }


    @GetMapping("/studentList")
    public String getStudentList(Model model) {
        List<Student> students = studentService.searchStudentList();
        List<StudentsCourses> studentsCourses = studentService.searchStudentsCoursesList();

        model.addAttribute("studentList" , converter.convertStudentDetails(students, studentsCourses));
        return "studentList";
//    public List<Student> getStudentList() {
//        return studentService.searchStudentList();
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

