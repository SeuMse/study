package com.bigpao.com.dao;

import com.bigpao.com.StudyApplication;
import com.bigpao.com.model.Admin;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.HashMap;
import java.util.Map;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = StudyApplication.class)
@WebAppConfiguration
public class AdminTest {

	@Autowired
	private AdminDao adminDao;
	@Test
	public void contextLoads() {
		Admin admin=new Admin();
		admin.setAdminName("admin");
		admin.setAdminPassword("admin");
		adminDao.findAdminByadminNameAndadminPassword("admin","admin");
	}

	@Test
	public void testinsert(){
		Admin admin = new Admin();
		admin.setAdminPassword("111");
		admin.setAdminName("111");
		adminDao.addAdmin(admin);
	}
	@Test
	public void testSelect(){
		adminDao.seleceAllAdmin();
	}

	@Test
	public void testDelete(){
		adminDao.deleteAdminById(2);
	}


	@Test
	public void testUpdate(){
		adminDao.updateAdminPasswordById("1111","2");
	}
}
