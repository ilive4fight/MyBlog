package com.blog.configuration;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * Created by semen on 12.04.2016.
 */
public class SpringMvcInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
    @Override
    protected Class<?>[] getRootConfigClasses(){
        return new Class[]{WebAppConfig.class};
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return null;
    }

    @Override
    protected String[] getServletMappings(){
        return new String[]{"/"};
    }
}
