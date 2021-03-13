package com.lhf.springboot.controller;

import com.lhf.springboot.common.ResultBean;
import com.lhf.springboot.model.User;
import org.springframework.web.bind.annotation.*;

/**
 * @ClassName: TestController
 * @Description:
 * @Author: liuhefei
 * @Date: 2019/9/1
 * @blog: https://www.imooc.com/u/1323320/articles
 **/
@RestController
@RequestMapping("/test")
//@CrossOrigin  //通过@CrossOrigin注解解决跨域问题
public class TestController {

    @GetMapping("/get1")
    public ResultBean get1(){
        System.out.println("请求成功！......");
        return new ResultBean("get1 Ok!");
    }

    /**
     * JSONP跨域
     * @param user
     * @return
     */
    @PostMapping("/postJson")
    public ResultBean postJson(@RequestBody User user) {
        System.out.println("TestController.postJson()");

        return new ResultBean("postJson " + user.getName());
    }

    /**
     * 带cookie的跨域
     * @param cookie1
     * @return
     */
    @GetMapping("/getCookie")
    public ResultBean getCookie(@CookieValue(value = "cookie1") String cookie1) {
        System.out.println("TestController.getCookie()");
        return new ResultBean("getCookie " + cookie1);
    }

    /**
     * 自定义请求头跨域
     * @param header1
     * @param header2
     * @return
     */
    @GetMapping("/getHeader")
    public ResultBean getHeader(@RequestHeader("x-header1") String header1,
                                @RequestHeader("x-header2") String header2) {
        System.out.println("TestController.getHeader()");

        return new ResultBean("getHeader " + header1 + " " + header2);
    }
}
