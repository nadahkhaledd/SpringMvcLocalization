package com.vodafone.config;

import com.vodafone.model.User;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.springframework.beans.factory.config.PropertiesFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.core.io.ClassPathResource;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import java.util.Locale;

@EnableWebMvc
@Configuration
@ComponentScan(basePackages = "com.vodafone")
public class MvcConfig implements WebMvcConfigurer {

  @Bean
  public InternalResourceViewResolver internalResourceViewResolver() {
    InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
    viewResolver.setPrefix("/WEB-INF/pages/");
    viewResolver.setSuffix(".jsp");
    return viewResolver;
  }

  @Bean
  public LocaleResolver localeResolver(){
    CookieLocaleResolver resolver = new CookieLocaleResolver();
    resolver.setDefaultLocale(new Locale("en"));
    resolver.setCookieName("myLocaleCookie");
    resolver.setCookieMaxAge(4800);
    return resolver;
  }

  public void addInterceptors(InterceptorRegistry registry) {
    LocaleChangeInterceptor interceptor = new LocaleChangeInterceptor();
    interceptor.setParamName("mylocale");
    registry.addInterceptor(interceptor);
  }

  @Bean
  public PropertiesFactoryBean propertiesfilemapping() {
    PropertiesFactoryBean factoryBean = new PropertiesFactoryBean();
    factoryBean.setFileEncoding("UTF-8");
    factoryBean.setLocation(new ClassPathResource("messages_ar_EG.properties"));
    return factoryBean;
  }

  @Bean(name = "messageSource")
  public ResourceBundleMessageSource messageSource() {
    ResourceBundleMessageSource resourceBundleMessageSource = new ResourceBundleMessageSource();
    resourceBundleMessageSource.setBasenames("messages", "errors");
    resourceBundleMessageSource.setFallbackToSystemLocale(true);
    resourceBundleMessageSource.setDefaultLocale(new Locale("en_US"));
    resourceBundleMessageSource.setDefaultEncoding("UTF-8");
    resourceBundleMessageSource.setCacheSeconds(3600);
    return resourceBundleMessageSource;
  }

  @Bean
  public SessionFactory getSessionFactory(){

    return new MetadataSources(
            new StandardServiceRegistryBuilder().configure().build())
            .buildMetadata()
            .buildSessionFactory();
  }


}
