package com.bigpao.com.service;

import com.bigpao.com.dao.StuDao;
import com.bigpao.com.model.Stu;
import com.bigpao.com.model.Teach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by chen wang on 2017/3/3.
 */
@Service
public class StuService {
    @Autowired
    StuDao stuDao;

    /**
     * 分页查询学生
     * @param offset  偏移值
     * @return List<Stu>
     */
    public List<Stu> findLimitStu(int offset){
        int limit=10;
        return stuDao.selectLimitStu(offset*limit,limit);
    }

    /**
     * 查询学生的数量
     * @return int
     */
    public int findStuNumber(){
        return stuDao.getStuNumber();
    }


    /**
     * 删除学生
     * @return int
     */
    public int deleteStuById(int id){
        int result;
        try{
            result=stuDao.deleteStuById(id);
        }catch (Exception e){
            result=-1;
        }
        return result;
    }
}
