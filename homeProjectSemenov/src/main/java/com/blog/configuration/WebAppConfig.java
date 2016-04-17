package com.blog.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.BeanNameViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

/**
 * Created by semen on 12.04.2016.
 */
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.blog")
public class WebAppConfig extends WebMvcConfigurerAdapter {

    @Autowired
    RoleToUserProfileConverter roleToUserProfileConverter;

    @Bean(name="WebApp")
    public ViewResolver viewResolver(){
        InternalResourceViewResolver resolver =new InternalResourceViewResolver();
        resolver.setViewClass(JstlView.class);
        resolver.setPrefix("/WEB-INF/views/");
        resolver.setSuffix(".jsp");
        return resolver;
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry resourceHandlerRegistration){
        resourceHandlerRegistration.addResourceHandler("/static/**").addResourceLocations("/static/");
    }



    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addConverter(roleToUserProfileConverter);
    }

}
