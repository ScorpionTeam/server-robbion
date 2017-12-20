package com.kunlun.order.service;

import com.alibaba.fastjson.JSONObject;
import com.kunlun.config.Constants;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;
import org.springframework.web.client.RestTemplate;


/**
 * @author by fk
 * @created on 2017/12/14.
 */
@Service
public class WxOrderServiceImpl implements WxOrderService {

    @Autowired
    private RestTemplate restTemplate;

    /**
     * 查询我的订单列表
     *
     * @param object
     * @return
     */
    @HystrixCommand(fallbackMethod = "objectFallback")
    @Override
    public ModelMap findByWxCode(JSONObject object) {
        String url = Constants.SERVER_NAME + Constants.WX_MODULE + "findByWxCode";
        return restTemplate.postForObject(url, object, ModelMap.class);
    }

    /**
     * 退款
     *
     * @param object
     * @return
     */
    @HystrixCommand(fallbackMethod = "objectFallback")
    @Override
    public ModelMap refund(JSONObject object) {
        String url = Constants.SERVER_NAME + Constants.WX_MODULE + "refund";
        return restTemplate.postForObject(url, object, ModelMap.class);
    }


    /**
     * 查询订单详情
     *
     * @param object
     * @return
     */
    @HystrixCommand(fallbackMethod = "objectFallback")
    @Override
    public ModelMap findByOrderId(JSONObject object) {
        String url = Constants.SERVER_NAME + Constants.WX_MODULE + "findByOrderId";
        return restTemplate.postForObject(url, object, ModelMap.class);
    }

    /**
     * 签收后评价
     *
     * @param object
     * @return
     */
    @HystrixCommand(fallbackMethod = "objectFallback")
    @Override
    public ModelMap estimate(JSONObject object) {
        String url = Constants.SERVER_NAME + Constants.WX_MODULE + "estimate";
        return restTemplate.postForObject(url, object, ModelMap.class);
    }

    /**
     * 取消订单
     *
     * @param object
     * @param ipAddress
     * @return
     */
    @HystrixCommand(fallbackMethod = "parameterFallback")
    @Override
    public ModelMap cancelOrder(JSONObject object, String ipAddress) {
        String url = Constants.SERVER_NAME + Constants.WX_MODULE + "cancelOrder";
        return restTemplate.postForObject(url, object, ModelMap.class);
    }

    /**
     * 确认收货
     *
     * @param object
     * @param ipAddress
     * @return
     */
//    @HystrixCommand(fallbackMethod = "fallback",
//            线程池配置
//            threadPoolProperties = {
//                核心线程池大小和线程池最大大小
//                @HystrixProperty(name = "coreSize", value = "30"),
//                队列最大长度
//                @HystrixProperty(name = "maxQueueSize", value = "100"),
//                限定当前队列大小 实际队列大小由该参数设置
//                @HystrixProperty(name = "queueSizeRejectionThreshold", value = "20")
//          },
//            命令属性配置
//            commandProperties = {
//                当隔离策略为THREAD时，当执行线程执行超时时，是否进行中断处理 默认为true  value值为毫秒
//                @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "3000"),
//                @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "3000") , fallbackMethod = "fallback"
//                熔断触发的最小个数/10s 默认值是20
//                @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "1")
//          }

    @HystrixCommand(fallbackMethod = "parameterFallback")
    @Override
    public ModelMap confirmByGood(JSONObject object, String ipAddress) {
        String url = Constants.SERVER_NAME + Constants.WX_MODULE + "confirmByGood";
        return restTemplate.postForObject(url, object, ModelMap.class);
    }


    /**
     * 方法错误回传
     *
     * @return
     */
    public ModelMap objectFallback(JSONObject object) {
        return new ModelMap("ERROR", "服务器开小差.....请稍后再试");
    }

    /**
     * 方法错误回传
     *
     * @return
     */
    public ModelMap parameterFallback(JSONObject object, String ipAddress) {
        return new ModelMap("ERROR", "服务器开小差.....请稍后再试");
    }
}
