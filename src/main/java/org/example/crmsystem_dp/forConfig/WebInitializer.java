package org.example.crmsystem_dp.forConfig;

import org.example.crmsystem_dp.configuration.JdbcConfiguration;
import org.example.crmsystem_dp.configuration.RootConfiguration;
import org.example.crmsystem_dp.configuration.WebConfiguration;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class WebInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[0];
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{RootConfiguration.class, WebConfiguration.class, JdbcConfiguration.class};
    }

    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }
}
