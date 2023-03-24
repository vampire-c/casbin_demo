package com.example.casbindemo.controller;

import com.example.casbindemo.entity.Policy;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.casbin.jcasbin.main.Enforcer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CasbinController {

    @Autowired
    Enforcer enforcer;

    @Autowired
    ObjectMapper objectMapper;

    /**
     * Enforce 决定“主体”是否能够用“动作”操作访问“对象”，输入参数通常是: (sub, obj, act)。
     *
     * @param policy
     * @return
     * @throws Exception
     */
    @PostMapping("/enforce")
    public Object enforce(@RequestBody Policy policy) throws Exception {
        return enforcer.enforce(policy.getSub(), policy.getObj(), policy.getAct());
    }

    /**
     * GetPolicy 获取策略中的所有授权规则。
     *
     * @param policy
     * @return
     * @throws Exception
     */
    @PostMapping("/getPolicy")
    public Object getPolicy(@RequestBody Policy policy) throws Exception {
        return objectMapper.writeValueAsString(enforcer.getPolicy());
    }


    @PostMapping("/getAllSubjects")
    public Object getAllSubjects(@RequestBody Policy policy) throws Exception {
        return objectMapper.writeValueAsString(enforcer.getAllSubjects());

    }


    /**
     * GetGroupingPolicy 获取策略中的所有角色继承规则。
     *
     * @param policy
     * @return
     * @throws Exception
     */
    @PostMapping("/getGroupingPolicy")
    public Object getGroupingPolicy(@RequestBody Policy policy) throws Exception {
        return objectMapper.writeValueAsString(enforcer.getGroupingPolicy());
    }

    /**
     * GetFilteredPolicy 获取策略中的所有授权规则，可以指定字段筛选器。
     *
     * @param policy
     * @return
     * @throws Exception
     */
    @PostMapping("/getFilteredPolicy")
    public Object getFilteredPolicy(@RequestBody Policy policy) throws Exception {
        return enforcer.getFilteredPolicy(policy.getIndex(), policy.getSub(), policy.getObj(), policy.getAct());
    }

    /**
     * AddPolicy 向当前策略添加授权规则。 如果规则已经存在，函数返回false，并且不会添加规则。 否则，函数通过添加新规则并返回true。
     *
     * @param policy
     * @return
     * @throws Exception
     */
    @PostMapping("/addPolicy")
    public Object addPolicy(@RequestBody Policy policy) throws Exception {
        return enforcer.addPolicy(policy.getSub(), policy.getObj(), policy.getAct());
    }

    /**
     * AddNamedPolicy 向当前命名策略添加授权规则。 如果规则已经存在，函数返回false，并且不会添加规则。 否则，函数通过添加新规则并返回true。
     *
     * @param policy
     * @return
     * @throws Exception
     */
    @PostMapping("/addNamedPolicy")
    public Object addNamedPolicy(@RequestBody Policy policy) throws Exception {
        return enforcer.addNamedPolicy(policy.getName(), policy.getSub(), policy.getObj(), policy.getAct());
    }

    /**
     * AddGroupingPolicy 向当前策略添加角色继承规则。 如果规则已经存在，函数返回false，并且不会添加规则。 否则，函数通过添加新规则并返回true。
     *
     * @param policy
     * @return
     * @throws Exception
     */
    @PostMapping("/addGroupingPolicy")
    public Object addGroupingPolicy(@RequestBody Policy policy) throws Exception {
        return enforcer.addGroupingPolicy(policy.getSub(), policy.getObj());
    }


}
