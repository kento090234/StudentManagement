package raisetech.StudentManagement.repository;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import raisetech.StudentManagement.data.StudentsCourses;

import java.util.List;

@Mapper
public interface CourseRepository {

    /**
     * 指定されたキーワードを含むコース名を検索します。
     *
     * @param keyword 検索するキーワード
     * @return キーワードを含むコース情報のリスト
     */
    @Select("SELECT * FROM students_courses WHERE course_name LIKE CONCAT('%', #{keyword}, '%')")
    List<StudentsCourses> findByNameContaining(@Param("keyword") String keyword);
}