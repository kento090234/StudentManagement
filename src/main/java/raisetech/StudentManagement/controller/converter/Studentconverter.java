package raisetech.studentmanagement.controller.converter;

import org.springframework.stereotype.Component;
import raisetech.studentmanagement.data.Student;
import raisetech.studentmanagement.data.StudentsCourses;
import raisetech.studentmanagement.domain.StudentDetail;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class StudentConverter {
    public List<StudentDetail> convertStudentDetails(List<Student> students, List<StudentsCourses> studentsCourses) {
        List<StudentDetail> studentDetails = new ArrayList<>();
        students.forEach(student -> {
            StudentDetail studentDetail = new StudentDetail();
            studentDetail.setStudent(student);

            // 関連するコースをフィルタリング
            List<StudentsCourses> convertStudentCourses = studentsCourses.stream()
                    .filter(studentsCourse -> student.getId().equals(studentsCourse.getStudentId()))
                    .collect(Collectors.toList());
            studentDetail.setStudentsCourses(convertStudentCourses);

            // remark と isDeleted を設定
            studentDetail.setRemark(student.getRemark());        // remark をセット
//            studentDetail.setDeleted(student.isDeleted());       // isDeleted をセット

            studentDetails.add(studentDetail);
        });
        return studentDetails;
    }
}
