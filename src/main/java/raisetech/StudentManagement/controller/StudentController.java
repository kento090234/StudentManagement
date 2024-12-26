package raisetech.StudentManagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import raisetech.StudentManagement.controller.converter.StudentConverter;
import raisetech.StudentManagement.domain.StudentDetail;
import raisetech.StudentManagement.service.StudentService;
import raisetech.StudentManagement.data.Student;
import raisetech.StudentManagement.data.StudentsCourses;

import java.util.Arrays;
import java.util.List;

@Controller
public class StudentController {

    @Autowired
    private StudentService service;

    @Autowired
    private StudentConverter converter;

    // 学生一覧を取得するエンドポイント
    @GetMapping("/studentList")
    public String getStudentList(Model model) {
        List<Student> students = service.searchStudentList();
        List<StudentsCourses> studentCourses = service.searchStudentsCoursesList();
        model.addAttribute("studentList", converter.convertStudentDetails(students, studentCourses));
        return "studentList"; // HTMLテンプレートの名前を返す
    }

    // IDで特定の学生を取得するエンドポイント
    @GetMapping("/student/{id}")
    public String getStudent(@PathVariable String id, Model model) {
        StudentDetail studentDetail = service.searchStudent(id);
        model.addAttribute("studentDetail", studentDetail);
        return "updateStudent"; // HTMLテンプレートの名前を返す
    }

    // 新しい学生の登録フォーム
    @GetMapping("/newStudent")
    public String newStudent(Model model) {
        StudentDetail studentDetail = new StudentDetail();
        studentDetail.setStudentsCourses(Arrays.asList(new StudentsCourses()));
        model.addAttribute("studentDetail", studentDetail);
        return "registerStudent";
    }

    // 学生情報の更新
    @PostMapping("/updateStudent")
    public String updateStudent(@ModelAttribute StudentDetail studentDetail, BindingResult result) {
        if (result.hasErrors()) {
            return "updateStudent";
        }
        service.updateStudent(studentDetail);
        return "redirect:/studentList";
    }

    @PostMapping("/registerStudent")
    public String registerStudent(@ModelAttribute StudentDetail studentDetail, BindingResult result) {
        if (result.hasErrors()) {
            return "registerStudent";
        }
        service.registerStudent(studentDetail);
        return "redirect:/studentList";
    }
}
