package com.lhf.springboot.common;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.AbstractJsonpResponseBodyAdvice;

/**
 * @ClassName: JsonpAdvice
 * @Description: jSONP
 * 使用JSONP解决跨域问题，只改前端不改后端报语法错误（如图中第二条错误）的原因：
 * JSONP是使用动态创建的一个script标签，而script标签返回的是JS代码，但是服务器后台代码没有做任何改动，返回的还是json对象。
 * 浏览器会把json对象和字符串当作是JS代码来解析所以就会报错了。
 * 解决方法：需要修改后台代码，新建一个类继承AbstractJsonpResponseBodyAdvice，然后在构造方法里写super("callback");
 * @Author: liuhefei
 * @Date: 2019/9/1
 * @blog: https://www.imooc.com/u/1323320/articles
 **/
@ControllerAdvice
public class JsonpAdvice extends AbstractJsonpResponseBodyAdvice {

    public JsonpAdvice() {
        // TODO Auto-generated constructor stub
        super("callback2");
    }

}
