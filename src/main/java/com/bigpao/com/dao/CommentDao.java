package com.bigpao.com.dao;

import com.bigpao.com.model.Comment;
import com.bigpao.com.model.Course;
import org.apache.ibatis.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.List;

/**
 * Created by chen wang on 2017/3/1.
 */

/**
 * Comment的dao接口
 */
@Mapper
public interface CommentDao {
    String TABLE_NAME="comment";
    String INSERT_FIELDS="course_id,stu_id,comment_date,comment_content";
    String SELECT_FIELDS="comment_id,stu_id,comment_date,comment_content";


    /**
     * 根据courseId查询全部的Comment
     * @param course Course实例
     * @return List<Comment>
     */
    @Select({"select",SELECT_FIELDS,"from",TABLE_NAME,"where course_id=#{courseId}"})
    List<Comment> selectCommentsByCourse(Course course);

    /**
     * 插入Comment实例
     * @param comment Comment实例
     * @return int  更新数据库的行数
     */
    @Insert({"insert into",TABLE_NAME,"(",INSERT_FIELDS,")",
            "values(#{courseId},#{stuId},#{commentDate},#{commentContent})"})
    int insertComment(Comment comment);


    /**
     * 删除Comment实例
     * @param comment Comment实例
     * @return int  更新数据库的行数
     */
    @Delete({"delete from",TABLE_NAME,"where comment_id=#{commentId}"})
    int deleteComment(Comment comment);

    /**
     * 查询全部评论的数量
     * @return int
     */
    @Select({"select count(comment_id) from",TABLE_NAME})
    int getCommentNumber();


    /**
     * 分页查询全部评论
     * @param offset 偏移值
     * @param limit   一页评论数量
     * @return List<Course>
     */
    List<HashMap> selectLimitComment(@Param("offset") int offset, @Param(value = "limit") int limit);

}
