package com.bigpao.com.dao;

import com.bigpao.com.model.Teach;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * Created by chen wang on 2017/3/1.
 */
@Mapper
public interface TeachDao {
    String TABLE_NAME="teach";
    String INSERT_FIELDS="teach_name,teach_email,teach_introduce,teach_headurl";
    String SELECT_FIELDS="teach_id,"+INSERT_FIELDS;

    @Select({"select ",SELECT_FIELDS," from ",TABLE_NAME})
    List<Teach> selectTeachs();


    @Insert({"insert into ",TABLE_NAME," (",INSERT_FIELDS,")",
            "values(#{teachName},#{teachEmail},#{teachIntroduce},#{teachHeadurl})"})
    int insertTeach(Teach teach);

    @Delete({"delete from ",TABLE_NAME," where teach_id=#{teachId}"})
    int deleteTeach(Teach teach);


    @Update({"update ",TABLE_NAME,
             " set teach_name=#{teachName},teach_email=#{teachEmail},teach_introduce=#{teachIntroduce},teach_headurl=#{teachHeadurl}",
             "where teach_id=#{teachId}"})
    int updateTeach(Teach teach);
}
