package com.wk.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

//声明为spring的配置类
@Configuration
//开启springMvc
@EnableWebMvc
//开启组件扫描，注意只扫描web相关的内容
@ComponentScan("com.wk.controller")
public class MvcConfig extends WebMvcConfigurerAdapter{
	/**
	 * 配置jsp的视图解析器
	 * @return InternalResourceViewResolver
	 */
	@Bean
	public ViewResolver viewResolver(){
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setPrefix("/WEB-INF/views");
		viewResolver.setSuffix(".jsp");
		viewResolver.setExposeContextBeansAsAttributes(true);
		return viewResolver;
	}

	/**
	 * 启用servlet容器对静态资源的处理
	 * @param configurer 配置
	 */
	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		configurer.enable();
	}
}
