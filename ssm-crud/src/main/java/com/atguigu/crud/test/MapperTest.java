package com.atguigu.crud.test;

import java.util.UUID;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.atguigu.crud.bean.Department;
import com.atguigu.crud.bean.Employee;
import com.atguigu.crud.dao.DepartmentMapper;
import com.atguigu.crud.dao.EmployeeMapper;

/**
 * 
 * @author 李红辉
 * @ContextConfiguration：指定spring配置文件的位置
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext.xml" })
public class MapperTest {
	/*
	 * 测试部门departmentMapper
	 */
	@Autowired
	DepartmentMapper departmentMapper;

	@Autowired
	EmployeeMapper employeeMapper;

	@Autowired
	SqlSession SqlSession;

	@Test
	public void TestCRUD() {
		// ApplicationContext context = new
		// ClassPathXmlApplicationContext("classpath:applicationContext.xml");
		// DepartmentMapper departmentMapper =
		// context.getBean(DepartmentMapper.class);
		// System.out.println(departmentMapper);
		System.out.println(departmentMapper);
		// 1.插入几个部门
		Department department = new Department(null, "中宣部");
		departmentMapper.insertSelective(department);
		departmentMapper.insertSelective(new Department(null, "新闻部AAA"));
		System.out.println("输出测试：" + department);
		// 插入员工
		//employeeMapper.insertSelective(new Employee(null, "刘晨", "女", "2134546.163.com", 1));
		// 批量插入
		EmployeeMapper mapper = SqlSession.getMapper(EmployeeMapper.class);
		for (int i = 0; i < 1000; i++) {
			String username = UUID.randomUUID().toString().replace("-", "").toUpperCase().substring(0, 5) + "_" + i;
			// System.out.println(str);
			employeeMapper.insertSelective(new Employee(null, username, "女", username + "@163.com", 1));
		}
		System.out.println("批量完成。。。");
	}
}
