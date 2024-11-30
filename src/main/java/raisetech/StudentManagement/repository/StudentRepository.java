package raisetech.studentmanagement.repository;
import org.apache.ibatis.annotations.*;
import raisetech.studentmanagement.data.Student;
import raisetech.studentmanagement.data.StudentsCourses;


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


    @Select("SELECT * FROM students")
    List<Student> search();

    @Select("SELECT * FROM students_courses")
    List<StudentsCourses> searchStudentsCourses();

    /**
     * 年齢が30代の受講生を取得します。
     *
     * @return 年齢が30代の受講生一覧
     */
    @Select("SELECT * FROM students WHERE age BETWEEN 30 AND 39")
    List<Student> findStudentsInTheirThirties();

    /**
     * 指定されたキーワードを含むコース名を検索します。
     *
     * @param keyword 検索するキーワード
     * @return キーワードを含むコース情報のリスト
     */
    @Select("SELECT * FROM students_courses WHERE courses_name LIKE CONCAT('%', #{keyword}, '%')")
    List<StudentsCourses>searchByName(String keyword);
}