package com.atguigu.crud.test;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.atguigu.crud.bean.Employee;
import com.github.pagehelper.PageInfo;

/**
 * 使用spring测试模块提供的测试请求功能，测试CRUD的正确性
 * 
 * @author 李红辉
 *
 */

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations = { "classpath:applicationContext.xml",
		"file:src/main/webapp/WEB-INF/dispatcherServlet-servlet.xml" })

public class MvcTest {
	@Autowired
	WebApplicationContext context;
	// 虚假的MVC请求
	MockMvc mocMvc;

	@Before
	public void initMocMvc() {
		mocMvc = MockMvcBuilders.webAppContextSetup(context).build();
	}

	// 测试分页的方法
	@Test
	public void testPage() throws Exception {
		// 模拟请求，拿到返回值
		MvcResult result = mocMvc.perform(MockMvcRequestBuilders.get("/emps").param("pn", "5")).andReturn();
		// 请求成功后，请求域中会有PageInfo
		MockHttpServletRequest request = result.getRequest();
		PageInfo pageInfo = (PageInfo) request.getAttribute("pageInfo");
		System.out.println("当前页码：" + pageInfo.getPageNum());
		System.out.println("总页码：" + pageInfo.getPages());
		System.out.println("总记录数：" + pageInfo.getTotal());
		System.out.println("在页面需要连续显示的页码");
		int[] nums = pageInfo.getNavigatepageNums();
		for (int i : nums) {
			System.out.print(" " + i);
		}
		System.out.println();
		// 获取员工数据
		List<Employee> list = pageInfo.getList();

		for (Employee employee : list) {
			System.out.println("员工信息：" + employee);
		}

		for (Employee employee : list) {
			System.out.println("ID:" + employee.getEmpId() + "  ===>姓名: " + employee.getEmpName());
		}

	}
}
