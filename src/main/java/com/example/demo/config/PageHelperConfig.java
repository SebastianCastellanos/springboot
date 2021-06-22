package com.example.demo.config;

import com.github.pagehelper.PageHelper;
import org.apache.ibatis.plugin.Interceptor;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Properties;

@Configuration
public class PageHelperConfig {

    @Bean
    public PageHelper pageHelper(){
        PageHelper pageHelper = new PageHelper();
        Properties p = new Properties();
        /**
         * 设置为true时，会将RowBounds第一个参数offset当成pageNum页码使用
         */
        p.setProperty("reasonable","true");
        p.setProperty("supportMethodsArguments","true");
        p.setProperty("returnPageInfo","check");
        p.setProperty("params", "count=countSql");
        pageHelper.setProperties(p);

        new SqlSessionFactoryBean().setPlugins(new Interceptor[]{pageHelper});
        return pageHelper;
    }
}
