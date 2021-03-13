package com.lhf.springboot;

import com.lhf.springboot.common.CrosFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringBootAjaxServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootAjaxServerApplication.class, args);
	}

	/**
	 * 注册Filter,  被调用方实现Filter跨域方案
	 * 当通过nginx或apache来解决跨域问题时，需要注释以下代码
	 * @return
	 */
	@Bean
	public FilterRegistrationBean registerFilter() {

		FilterRegistrationBean bean = new FilterRegistrationBean();

		bean.addUrlPatterns("/*");  //让所有的请求都经过filter
		bean.setFilter(new CrosFilter());

		return bean ;
	}

}
