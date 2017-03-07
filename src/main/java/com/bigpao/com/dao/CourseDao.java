package com.bigpao.com.dao;

        import com.bigpao.com.model.Course;
        import com.bigpao.com.model.Stu;
        import org.apache.ibatis.annotations.*;

        import java.util.HashMap;
        import java.util.List;

/**
 * Created by hzdmm on 2017/3/1.
 */
@Mapper
public interface CourseDao {
    String TABLE_NAME = "course";
    String INSERT_FIELDS="course_name,teach_id,course_introduce,course_url,course_sort";
    String SELECT_FIELDS="course_id,"+INSERT_FIELDS;
    String ADMIN_SELECT_FIELDS="course_id,course_name,teach.teach_name,course_introduce,course_sort";
    String TEACH_TABLE_NAME="teach";

    @Insert({"insert into",TABLE_NAME,"(",INSERT_FIELDS,")values","(#{courseName},#{courseIntroduce},#{courseUrl},#{courseSort})"})
    int addCourse(Course course);

    @Delete({"delete from",TABLE_NAME,"where course_id=#{courseId}"})
    void deleteCourseById(int courseId);

    @Select({"select",SELECT_FIELDS,"from",TABLE_NAME})
    List<Course> seleceAllCourse();

    /**
     * 查询课程的数量
     * @return int
     */
    @Select({"select count(course_id) from",TABLE_NAME})
    int getCourseNumber();


    /**
     * 分页查询课程
     * @param offset 偏移值
     * @param limit   一页课程数量
     * @return List<Course>
     */
   /* @Select({"select",ADMIN_SELECT_FIELDS,"from",TABLE_NAME,
            "join teach on",TEACH_TABLE_NAME,".teach_id=",TABLE_NAME,".teach_id",
            "limit #{offset},#{limit}"})*/
    List<HashMap> selectLimitCourse(@Param("offset") int offset, @Param(value = "limit") int limit);


    /**
     * 根据teachId查找教师的课程
     * @param teachId
     * @return List<Course>
     */
    @Select({"select",SELECT_FIELDS,"from",TABLE_NAME,"where teach_id=#{teachId}"})
    List<Course> selectCourseByTeachId(int teachId);

}
