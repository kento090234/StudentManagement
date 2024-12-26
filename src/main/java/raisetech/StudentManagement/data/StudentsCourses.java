package raisetech.StudentManagement.data;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter

public class StudentsCourses {
    private int id;
    private int studentId;
    private String coursesName;
    private LocalDateTime startDate;
    private LocalDateTime endDate;

}