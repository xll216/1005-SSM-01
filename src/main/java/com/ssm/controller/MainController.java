package com.ssm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by 蓝鸥科技有限公司  www.lanou3g.com.
 */
@Controller
public class MainController {

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

}
