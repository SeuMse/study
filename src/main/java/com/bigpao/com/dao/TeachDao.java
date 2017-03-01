package com.bigpao.com.dao;

import com.bigpao.com.model.Teach;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * Created by chen wang on 2017/3/1.
 */

/**
 * Teach的dao接口
 */
@Mapper
public interface TeachDao {
    String TABLE_NAME="teach";
    String INSERT_FIELDS="teach_name,teach_email,teach_introduce,teach_headurl";
    String SELECT_FIELDS="teach_id,"+INSERT_FIELDS;

    /**
     * 查询全部的Teach实例
     * @return List<Teach>
     */
    @Select({"select ",SELECT_FIELDS," from ",TABLE_NAME})
    List<Teach> selectTeachs();


    /**
     * 插入Teach实例
     * @param teach Teach实例
     * @return int  更新数据库的行数
     */
    @Insert({"insert into ",TABLE_NAME," (",INSERT_FIELDS,")",
            "values(#{teachName},#{teachEmail},#{teachIntroduce},#{teachHeadurl})"})
    int insertTeach(Teach teach);


    /**
     * 根据teachId删除Teach实体
     * @param teach Teach实例
     * @return int  更新数据库的行数
     */
    @Delete({"delete from ",TABLE_NAME," where teach_id=#{teachId}"})
    int deleteTeach(Teach teach);


    /**
     * 根据teachId更新Teach实体
     * @param teach Teach实例
     * @return int  更新数据库的行数
     */
    @Update({"update ",TABLE_NAME,
             " set teach_name=#{teachName},teach_email=#{teachEmail},teach_introduce=#{teachIntroduce},teach_headurl=#{teachHeadurl}",
             "where teach_id=#{teachId}"})
    int updateTeach(Teach teach);
}
