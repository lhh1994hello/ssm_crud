package com.atguigu.crud.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.atguigu.crud.bean.Msg;

@Controller
public class AjaxDemo {
	@ResponseBody
	@RequestMapping("/ajaxTest")
	public String ajaxTest(){
		System.out.println("ajaxTest方法.............");
		return "adf";
	}
}
 