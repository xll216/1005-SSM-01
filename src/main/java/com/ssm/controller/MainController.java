package com.ssm.controller;

import com.ssm.domain.Student;
import com.ssm.service.StudentService;
import com.ssm.shiro.CustomRealm;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;

/**
 * Created by 蓝鸥科技有限公司  www.lanou3g.com.
 */
@Controller
public class MainController {
    @Resource
    private StudentService studentService;

    /**
     * 配置起始页
     * http://localhost:8080
     * http://localhost:8080/
     * http://localhost:8080/index
     **/
    @RequestMapping(
            value = {"", "/", "/index"})
    public String index() {
        return "index";
    }

    @RequestMapping(value = "/pageLogin")
    public String pageLogin() {
        return "login";
    }


    @RequestMapping(value = "/pageSuccess")
    public String pageSuccess() {
        return "success";
    }

    @RequestMapping(value = "/pageRefuse")
    public String pageRefuse() {
        return "refuse";
    }

    /**
     * 表单登录认证，即跳转到登录界面，发起表单提交
     *
     * @param student 表单提交的参数
     * @param model   存储数据的模型
     * @return 返回视图模型对象
     **/
    @RequestMapping(value = "/login")
    public ModelAndView login(Student student, Model model) throws Exception {

        ModelAndView mv = new ModelAndView();

        /*提交的用户名和密码为空直接返回登录界面*/
        if (StringUtils.isEmpty(student.getUsername()) || StringUtils.isEmpty(student.getPassword())) {
            mv.setViewName("login");
        } else {
            /*表单提交的用户名和密码不为空则走认证*/
            Subject subject = SecurityUtils.getSubject();

            try {
                String pass = CustomRealm.md5(student.getPassword());
                UsernamePasswordToken token = new UsernamePasswordToken(
                        student.getUsername(),
                        pass);

                subject.login(token);//登录认证
                mv.setViewName("index");//成功返回首页

            } catch (AuthenticationException ae) {
                ae.printStackTrace();
                System.out.println("登陆失败: " + ae.getMessage());
                model.addAttribute("loginError", "登陆失败");
                mv.setViewName("login");
            }
        }
        return mv;
    }

    @RequestMapping(value = "/home")
    public String home() {
        return "home";
    }
}
