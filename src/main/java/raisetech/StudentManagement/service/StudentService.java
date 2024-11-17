package raisetech.StudentManagement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import raisetech.StudentManagement.data.Student;
import raisetech.StudentManagement.data.StudentsCourses;
import raisetech.StudentManagement.repository.CourseRepository;
import raisetech.StudentManagement.repository.StudentRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentService {

    private final StudentRepository repository;
    private final CourseRepository courseRepository;

    @Autowired
    public StudentService(StudentRepository repository, CourseRepository courseRepository) {
        this.repository = repository;
        this.courseRepository = courseRepository;
    }


    public List<Student> searchStudentList() {
        //ここで何かしらの処理を行う
        return repository.search();
    }

    public List<StudentsCourses> searchStudentsCoursesList() {
        return repository.searchStudentsCourses();

    }

    /**
     * 年齢が30代の受講生を取得します。
     *
     * @return 年齢が30代の受講生一覧
     */

    // 30代以上の学生を抽出するメソッド
    public List<Student> searchStudentsInTheirThirtiesOrOlder() {
        // 全学生を取得し、年齢が30歳以上の学生のみを抽出
        return repository.search().stream()
                .filter(student -> student.getAge() >= 30)  // 年齢が30歳以上の学生をフィルタリング
                .collect(Collectors.toList());              // フィルタリング後のリストを返す
    }

    // "Java" を含むコースを抽出
    public List<StudentsCourses> findByCourseNameContaining(String keyword) {
        return courseRepository.findByNameContaining(keyword);
    }

}