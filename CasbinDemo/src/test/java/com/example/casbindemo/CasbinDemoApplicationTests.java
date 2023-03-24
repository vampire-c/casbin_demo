package com.example.casbindemo;

import org.casbin.adapter.JDBCAdapter;
import org.casbin.jcasbin.main.Enforcer;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;

@SpringBootTest()
// @TestPropertySource("classpath:pay.properties")
class CasbinDemoApplicationTests {

    @Autowired
    DataSource dataSource;

    // @Autowired
    // JDBCAdapter jdbcAdapter;

    @Test
    void contextLoads() throws Exception {
        // 数据源
        JDBCAdapter jdbcAdapter = new JDBCAdapter(dataSource);
        // 访问模型
        String path = this.getClass().getResource("/").getPath() + "rbac_model.conf";
        Enforcer e = new Enforcer(path, jdbcAdapter);

        // e.enforce("alice", "data1", "read");
        // e.addRoleForUser("alice", "data1_admin");
        e.addPolicy("eve", "data1", "read");
        // e.addPolicy(...);
        // e.removePolicy(...);
        // e.savePolicy();
        // List<List<String>> policyList = e.getPolicy();
        // policyList.forEach(System.out::println);
        String sub = "alice"; // 想要访问资源的用户
        String obj = "data1"; // 将要被访问的资源
        String act = "read"; // 用户对资源进行的操作
        //
        if (e.enforce(sub, obj, act)) {
            // 允许alice读取data1
            System.out.println("success");
        } else {
            // 拒绝请求，抛出异常
            System.out.println("error");
        }


    }

}

