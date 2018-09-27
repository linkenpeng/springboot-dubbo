package com.intesec.core.controller;

import com.alibaba.csp.sentinel.Entry;
import com.alibaba.csp.sentinel.SphU;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.alibaba.csp.sentinel.slots.block.RuleConstant;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRule;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRuleManager;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: 限流系统
 * @author: peter.peng
 * @create: 2018-09-27 11:21
 **/
@Controller
@RequestMapping("/sentinel")
@Slf4j
public class SentinelController {

    @GetMapping("/hello")
    @ResponseBody
    public void hello() {
        initFlowRules();

        for(int i = 0; i < 50; i++) {
            Entry entry = null;
            try {
                entry = SphU.entry("HelloWorld");
                log.info("hello world: " + i);
            } catch (BlockException e) {
                log.info("block! : " + i);
                e.printStackTrace();
            } finally {
                if(entry != null) {
                    entry.exit();
                }
            }
        }
    }

    private void initFlowRules() {
        List<FlowRule> rules = new ArrayList<>();
        FlowRule rule = new FlowRule();
        rule.setResource("HelloWorld");
        rule.setGrade(RuleConstant.FLOW_GRADE_QPS);
        rule.setCount(20);
        rules.add(rule);
        FlowRuleManager.loadRules(rules);
    }
}
