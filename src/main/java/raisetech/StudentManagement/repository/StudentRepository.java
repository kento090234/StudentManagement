package raisetech.StudentManagement.repository;
import org.apache.ibatis.annotations.*;
import raisetech.StudentManagement.data.Student;
import raisetech.StudentManagement.data.StudentsCourses;


import java.util.List;

/**
 *
 * 受講生情報を扱うリポジトリ。
 *
 * 全権検索や単一条件での検索、コース情報の検索が行えるクラスです。
 */

@Mapper
public interface StudentRepository {

    /**
     * 全件検索します。
     *
     * @return　全件検索した受講生情報の一覧
     */

    @Select("SELECT * FROM students WHERE id = #{id}")
    Student searchStudent(String id);

    @Select("SELECT * FROM students")
    List<Student> search();

    @Select("SELECT * FROM students_courses")
    List<StudentsCourses> searchStudentsCoursesList();

    @Select("SELECT * FROM students_courses WHERE student_id = #{studentId}")
    List<StudentsCourses> searchStudentsCourses(String  studentId);


    @Insert("INSERT INTO students(name, fullname, nickname, email_address, address, age, gender, remark, isDeleted) "
      + "VALUES(#{name}, #{fullname}, #{nickname}, #{emailAddress}, #{address}, #{age}, #{gender}, #{remark}, false )")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void
    registerStudent(Student student);

    @Insert("INSERT INTO students_courses(student_id,  courses_name,  start_date,  end_date)"
        + "VALUES(#{studentId}, #{coursesName}, #{startDate}, #{endDate})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void registerStudentsCourses(StudentsCourses studentsCourses);

    @Update("UPDATE students SET name = #{name}, fullname = #{fullname}, nickname = #{nickname}, email_address = #{emailAddress}, "
            + "address = #{address}, age = #{age}, gender = #{gender}, remark = #{remark}, isDeleted = #{isDeleted} WHERE id = #{id}")
    void updateStudent(Student student);

    @Update("UPDATE students_courses SET courses_name = #{coursesName} WHERE id = #{id}")
    void updateStudentsCourses(StudentsCourses studentsCourses);
}





//    /**
//     * 年齢が30代の受講生を取得します。
//     *
//     * @return 年齢が30代の受講生一覧
//     */
//    @Select("SELECT * FROM students WHERE age BETWEEN 30 AND 39")
//    List<Student> findStudentsInTheirThirties();
//
//    /**
//     * 指定されたキーワードを含むコース名を検索します。
//     *
//     * @param keyword 検索するキーワード
//     * @return キーワードを含むコース情報のリスト
//     */
//    @Select("SELECT * FROM students_courses WHERE courses_name LIKE CONCAT('%', #{keyword}, '%')")
//    List<StudentsCourses>searchByName(String keyword);
