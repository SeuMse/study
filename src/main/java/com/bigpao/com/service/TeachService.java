package com.bigpao.com.service;

import com.bigpao.com.dao.TeachDao;
import com.bigpao.com.model.Admin;
import com.bigpao.com.model.Course;
import com.bigpao.com.model.Teach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by chen wang on 2017/3/2.
 */
@Service
public class TeachService {

    @Autowired
    TeachDao teachDao;


    /**
     * 分页查询教师
     * @param offset  偏移值
     * @return List<Teach>
     */
    public List<Teach> findLimitTeach(int offset){
        int limit=10;
        return teachDao.selectLimitTeach(offset*limit,limit);
    }

    /**
     * 查询教师的数量
     * @return int
     */
    public int findTeachNumber(){
        return teachDao.getTeachNumber();
    }

    /**
     * 查询全部教师
     * @return  List<Teach>
     */
    public List<Teach> findTeach(){
        return teachDao.selectTeachs();
    }

    /**
     * 根据教师id查找
     * @param teachId
     * @return Teach
     */
    public Teach selectTeachById(int teachId){
        return teachDao.selectTeachById(teachId);
    }



}
