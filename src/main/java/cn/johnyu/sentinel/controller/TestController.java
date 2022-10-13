package cn.johnyu.sentinel.controller;

import cn.johnyu.sentinel.service.WorkService;
import com.alibaba.csp.sentinel.slots.block.RuleConstant;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRule;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRuleManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class TestController {
    @Autowired
    private WorkService workService;
    @RequestMapping(value = "test1/{time}")
    public String test1(@PathVariable long time){
        String info=workService.work(time);
        return info;
    }
}
