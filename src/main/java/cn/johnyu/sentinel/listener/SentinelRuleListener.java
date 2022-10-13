package cn.johnyu.sentinel.listener;

import com.alibaba.csp.sentinel.slots.block.RuleConstant;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRule;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRuleManager;
import org.springframework.boot.availability.AvailabilityChangeEvent;
import org.springframework.boot.availability.ReadinessState;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextStartedEvent;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
public class SentinelRuleListener implements ApplicationListener<AvailabilityChangeEvent>{
//    在容器启动后，注册资源和规则的对应关系
    @Override
    public void onApplicationEvent(AvailabilityChangeEvent event) {
        if (ReadinessState.ACCEPTING_TRAFFIC == event.getState()){
            List<FlowRule> rules = new ArrayList<>();
            FlowRule rule = new FlowRule();
            rule.setResource("work");//本条规则怀资源（HelloWorld）进行绑定
//      Thread和QPS可选
            rule.setGrade(RuleConstant.FLOW_GRADE_QPS);
            // QPS==2次，本1秒周期的其余请求将被降级处理
            rule.setCount(2);
            rules.add(rule);
            FlowRuleManager.loadRules(rules);
        }
    }

}
