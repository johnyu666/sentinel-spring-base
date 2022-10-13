package cn.johnyu.sentinel.service;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import org.springframework.stereotype.Service;

@Service
public class WorkService {
    /**
     * 定义了 work 资源，当规则指定的 QPS>2 时，请求会被 block,进而降级到 doBlockHandle();
     * 但如果不设置 blockHandler,会抛出异常，进而被 fallback 设置的方法所捕获
     */
    @SentinelResource(value = "work",blockHandler = "doBlockHandle",fallback = "doFallbackHandle")
    public String work(long time){
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "working "+time;
    }
// 中针对被阻塞的请求做异常的处理
    public String doBlockHandle(long time, BlockException ex){
        return "block "+time;
    }
//    针对work资源的一切异常做处理
    public String doFallbackHandle(long time,Throwable t){
        return "fallback "+time;
    }
}
