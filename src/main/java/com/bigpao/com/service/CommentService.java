package com.bigpao.com.service;

import com.bigpao.com.dao.CommentDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

/**
 * Created by chen wang on 2017/3/3.
 */
@Service
public class CommentService {
    @Autowired
    CommentDao commentDao;

    /**
     * 查询全部评论的数量
     * @return int
     */
    public int findCommentNumber(){
        return commentDao.getCommentNumber();
    }


    /**
     * 分页查询评论
     * @param offset  偏移值
     * @return List<Comment>
     */
    public List<HashMap> findLimitComment(int offset){
        int limit=10;
        return commentDao.selectLimitComment(offset*limit,limit);
    }
}
