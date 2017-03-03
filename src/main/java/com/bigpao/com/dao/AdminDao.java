package com.bigpao.com.dao;

import com.bigpao.com.model.Admin;
import com.bigpao.com.model.Stu;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * Created by hzdmm on 2017/3/1.
 */
@Mapper
public interface AdminDao {
    String TABLE_NAME = "admin";
    String INSERT_FIELDS="admin_name,admin_password";
    String SELECT_FIELDS="admin_id,"+INSERT_FIELDS;

    @Insert({"insert into",TABLE_NAME,"(",INSERT_FIELDS,")values (#{adminName},#{adminPassword})"})
    int addAdmin(Admin admin);

    @Update({"update",TABLE_NAME,"set admin_password=#{adminPassword} where admin_id=#{adminId}"})
    void updateAdminPasswordById(@Param("adminPassword") String adminPassword,@Param("adminId") String admin_id);

    @Delete({"delete from ",TABLE_NAME,"where admin_Id=#{adminId}"})
    void deleteAdminById(int adminId);

    @Select({"select",SELECT_FIELDS,"from",TABLE_NAME})
    List<Admin> seleceAllAdmin();

   /* @Select({"select",SELECT_FIELDS,"from",TABLE_NAME,"where admin_name=#{adminName} and admin_password=#{adminPassword}"})
    List<Admin> findAdminByadminNameAndadminPassword(String adminName,String adminPassword);*/
   @Select({"select",SELECT_FIELDS,"from",TABLE_NAME,"where admin_name=#{adminName} and admin_password=#{adminPassword}"})
   List<Admin> findAdminByadminNameAndadminPassword(@Param("adminName") String adminName,@Param("adminPassword") String adminPassword);//多个参数用@param指明


}
