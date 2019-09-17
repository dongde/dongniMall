package com.dongni.dongnimall;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @author cengshuai on 2019-09-05.
 * @version 1.0
 */
@Configuration
public class MyWebMvcConfigurerAdapter extends WebMvcConfigurerAdapter {
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        super.addResourceHandlers(registry);
        registry.addResourceHandler("/**.jpg")
                .addResourceLocations("file:/Users/cengshuai/intellij_workspace/bannerImages/")
                .addResourceLocations("file:/Users/cengshuai/intellij_workspace/smallImages/")
                .addResourceLocations("file:/Users/cengshuai/intellij_workspace/videoCovers/")
                .addResourceLocations("file:/Users/cengshuai/intellij_workspace/codeImage/");

    }
}
