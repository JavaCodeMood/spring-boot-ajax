package com.lhf.springboot.common;

import lombok.Data;

/**
 * @ClassName: ResultBean
 * @Description:
 * @Author: liuhefei
 * @Date: 2019/9/1
 * @blog: https://www.imooc.com/u/1323320/articles
 **/
@Data
public class ResultBean {

    private String data;

    public ResultBean(String data){
        this.setData(data);
    }

}
