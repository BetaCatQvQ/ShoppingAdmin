package com.shopping.controller;

import java.io.IOException;
import java.lang.ProcessBuilder.Redirect;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.context.annotation.SessionScope;

import com.shopping.entity.User;
import com.shopping.service.UserService;
import com.shopping.util.HttpVal;

@Controller
@RequestMapping("/user")
public class UserController {
	@Resource
	private UserService uService;

	@RequestMapping("/login")
	public String commonLogin(HttpSession session, User user) {
		User newUser = uService.commonUserLogin(user.getUserName(), user.getUserPwd());
		System.out.println(newUser);
		return null;
	}
	@RequestMapping("/goToAdminLogin")
	public String goToAdmin(Model model) {
		model.addAttribute("user", new User());
		return "login";
	}
	@RequestMapping("/adminLogin")
	public String login(Model model, HttpSession session, @ModelAttribute("user") User user) throws IOException {
		User newUser = uService.adminUserLogin(user.getUserName(), user.getUserPwd());
		System.out.println(user);
		if (user != null) {
			System.out.println("��½�ɹ�");
			// ��¼�ɹ�����userInfo�������õ�HttpSession���÷�Χ����;
			return "redirect:/categoryOne/list.action";

		} else {
			System.out.println("��½ʧ��");
			// ��¼ʧ�ܣ�����ʧ����Ϣ������ת����¼ҳ��
			session.setAttribute("error", "�˺��������");
			return "login";
		}
	}

	
}
