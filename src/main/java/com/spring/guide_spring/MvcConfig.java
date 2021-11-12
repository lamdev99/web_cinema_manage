package com.spring.guide_spring;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
@Configuration
public class MvcConfig implements WebMvcConfigurer {
  @Override
  public void addResourceHandlers(ResourceHandlerRegistry registry) {
    registry.addResourceHandler("/resources/bootstrap/**")
        .addResourceLocations("classpath:/META-INF/resources/webjars/bootstrap/5.1.3/");
    registry.addResourceHandler("/resources/css/**").addResourceLocations("classpath:/static/css/");
  }
}