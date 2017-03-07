package com.bigpao.com.dao;

        import com.bigpao.com.model.Course;
        import org.apache.ibatis.annotations.*;

        import java.util.List;

/**
 * Created by hzdmm on 2017/3/1.
 */
@Mapper
public interface CourseDao {
    String TABLE_NAME = "course";
    String INSERT_FIELDS="course_name,teach_id,course_introduce,course_url,course_sort";
    String SELECT_FIELDS="course_id,"+INSERT_FIELDS;

    @Insert({"insert into",TABLE_NAME,"(",INSERT_FIELDS,")values","(#{courseName},#{courseIntroduce},#{courseUrl},#{courseSort})"})
    int addCourse(Course course);

    @Delete({"delete from",TABLE_NAME,"where course_id=#{courseId}"})
    void deleteCourseById(int courseId);

    @Select({"select",SELECT_FIELDS,"from",TABLE_NAME})
    List<Course> seleceAllCourse();

    @Select({"select",SELECT_FIELDS,"from",TABLE_NAME," where course_sort=#{courseSort}"})
    List<Course> findCourseListBySort(String courseSort);
}
