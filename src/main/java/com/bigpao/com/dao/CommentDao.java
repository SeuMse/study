package com.bigpao.com.dao;

import com.bigpao.com.model.Comment;
import com.bigpao.com.model.Course;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by chen wang on 2017/3/1.
 */
@Mapper
public interface CommentDao {
    String TABLE_NAME="comment";
    String INSERT_FIELDS="course_id,stu_id,comment_date,comment_content";
    String SELECT_FIELDS="comment_id,stu_id,comment_date,comment_content";


    @Select({"select",SELECT_FIELDS,"from",TABLE_NAME,"where course_id=#{courseId}"})
    List<Comment> selectCommentsByCourse(Course course);

    @Insert({"insert into",TABLE_NAME,"(",INSERT_FIELDS,")",
            "values(#{courseId},#{stuId},#{commentDate},#{commentContent})"})
    int insertComment(Comment comment);

    @Delete({"delete from",TABLE_NAME,"where comment_id=#{commentId}"})
    int deleteComment(Comment comment);
}
