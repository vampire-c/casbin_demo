package com.example.casbindemo.config;

import org.casbin.adapter.JDBCAdapter;
import org.casbin.jcasbin.main.Enforcer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class Config {

    @Autowired
    DataSource dataSource;

    @Value("${data.config}")
    private String resPath;

    @Bean
    public Enforcer enforcer() throws Exception {
        JDBCAdapter jdbcAdapter = new JDBCAdapter(dataSource);
        System.out.println("================================================================================================================================");
        return new Enforcer(resPath + "rbac_model.conf", jdbcAdapter);
    }
}
