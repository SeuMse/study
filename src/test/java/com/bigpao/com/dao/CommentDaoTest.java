package com.bigpao.com.dao;

import com.bigpao.com.StudyApplication;
import com.bigpao.com.dao.CommentDao;
import com.bigpao.com.model.Comment;
import com.bigpao.com.model.Course;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;

/**
 * Created by chen wang on 2017/3/1.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = StudyApplication.class)
public class CommentDaoTest {
    @Autowired
    CommentDao commentDao;

    /**
     * CommentDao.selectCommentsByCourse测试
     */
    @Test
    public void selectTest(){
        Course course=new Course();
        course.setCourseId(1);
        commentDao.selectCommentsByCourse(course);
    }


    /**
     * CommentDao.insertComment(Comment comment)测试
     */
    @Test
    public void insertTest(){
        Comment comment=new Comment();
        comment.setCourseId(1);
        comment.setCommentContent("sfsdfd");
        comment.setCommentDate(new Date());
        comment.setStuId(1);
        commentDao.insertComment(comment);
    }


    /**
     * CommentDao.deleteComment(Comment comment)测试
     */
    @Test
    public void deleteTest(){
        Comment comment=new Comment();
        comment.setCommentId(1);
        commentDao.deleteComment(comment);
    }


}
