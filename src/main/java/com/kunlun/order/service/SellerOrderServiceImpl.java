package com.kunlun.order.service;

import com.alibaba.fastjson.JSONObject;
import com.kunlun.config.Constants;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;
import org.springframework.web.client.RestTemplate;

/**
 * @author by kunlun
 * @version <0.1>
 * @created on 2017/12/14.
 */
@Service
public class SellerOrderServiceImpl implements SellerOrderService {

    @Autowired
    private RestTemplate restTemplate;

    /**
     * 订单列表
     *
     * @param object
     * @return
     */
    @HystrixCommand(fallbackMethod = "objectFallback")
    @Override
    public ModelMap findByCondition(JSONObject object) {
        String url = Constants.SERVER_NAME + Constants.SELLER_MODULE + "findByCondition";
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
