package raisetech.StudentManagement.data;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class StudentsCourses {
    private String id;
    private int studentId;
    private String coursesName;
    private String startDate;
    private String endDate;

}