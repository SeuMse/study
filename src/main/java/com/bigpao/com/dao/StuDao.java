package com.bigpao.com.dao;

import com.bigpao.com.model.Stu;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * Created by hzdmm on 2017/3/1.
 */
@Mapper
public interface StuDao {
    String TABLE_NAME = "stu";
    String INSERT_FIELDS="stu_name,stu_password,stu_email,stu_headurl";
    String SELECT_FIELDS="stu_id,"+INSERT_FIELDS;

    @Insert({"insert into",TABLE_NAME,"(",INSERT_FIELDS,")values","(#{stuName},#{stuPassword},#{stuEmail},#{stuHeadurl})"})
    int addStu(Stu stu);

    @Update({"update",TABLE_NAME,"set stu_password=#{stuPassword} where stu_id=#{stuId}"})
    void updateStupasswordById(int stuId);

    @Delete({"delete from",TABLE_NAME,"where stu_id=#{stuId}"})
    void deleteStuById(int stuId);

    @Select({"select",SELECT_FIELDS,"from",TABLE_NAME})
    List<Stu> seleceAllStu();
}
