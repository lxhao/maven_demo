package me.gacl.action;

import java.util.Date;
import java.util.UUID;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.springframework.beans.factory.annotation.Autowired;

import me.gacl.model.User;
import me.gacl.service.UserServiceI;

@ParentPackage("basePackage")
@Action(value = "strust2Test") // 使用convention-plugin插件提供的@Action注解将一个普通java类标注为一个可以处理用户请求的Action
@Namespace("/") // 使用convention-plugin插件提供的@Namespace注解为这个Action指定一个命名空间
public class TestAction extends BaseAction {
	private static final long serialVersionUID = -8894234365005545175L;
	/**
	 * 注入userService
	 */
	@Autowired
	private UserServiceI userService;
	

	/**
	 * http://localhost:8080/SSHE/strust2Test!test.action MethodName: test
	 * Description: * 
	 * @author xudp
	 */
	public void test() {
		System.out.println("进入TestAction");
		userService.test();
	}

	/**
	 * http://localhost:8080/SSHE/strust2Test!saveUser.action
	 */
	public void saveUser() {
		User user = new User();
		user.setId(UUID.randomUUID().toString().replaceAll("-", ""));
		user.setName("xdp孤傲苍狼");
		user.setPwd("123456");
		user.setCreatedatetime(new Date());
		userService.save(user);
		this.writeJson(user);
	}
}