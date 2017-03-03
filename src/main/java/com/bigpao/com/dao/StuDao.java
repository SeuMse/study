package com.bigpao.com.dao;

import com.bigpao.com.model.Admin;
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
    String ADMIN_SELECT_FIELDS="stu_id,stu_name,stu_email";

    @Insert({"insert into",TABLE_NAME,"(",INSERT_FIELDS,")values","(#{stuName},#{stuPassword},#{stuEmail},#{stuHeadurl})"})
    int addStu(Stu stu);

    @Update({"update",TABLE_NAME,"set stu_password=#{stuPassword} where stu_id=#{stuId}"})
    void updateStupasswordById(int stuId);

    @Delete({"delete from",TABLE_NAME,"where stu_id=#{stuId}"})
    void deleteStuById(int stuId);

    @Select({"select",SELECT_FIELDS,"from",TABLE_NAME})
    List<Stu> seleceAllStu();

    /**
     * 查询学生的数量
     * @return int
     */
    @Select({"select count(stu_id) from",TABLE_NAME})
    int getStuNumber();


    /**
     * 分页查询学生
     * @param offset 偏移值
     * @param limit   一页学生数量
     * @return List<Stu>
     */
    @Select({"select",ADMIN_SELECT_FIELDS,"from",TABLE_NAME,"limit #{offset},#{limit}"})
    List<Stu> selectLimitStu(@Param("offset") int offset, @Param(value = "limit") int limit);
}
