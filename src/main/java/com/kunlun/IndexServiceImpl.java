package com.kunlun;

import com.alibaba.fastjson.JSON;
import com.kunlun.entity.Seller;
import com.kunlun.result.BaseResult;
import com.kunlun.result.SuccessResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;
import org.springframework.web.client.RestTemplate;

/**
 * @author by kunlun
 * @version <0.1>
 * @created on 2017/12/13.
 */
@Service
public class IndexServiceImpl implements IndexService {

    private static final Logger LOGGER = LoggerFactory.getLogger(IndexServiceImpl.class);


    @Autowired
    private RestTemplate restTemplate;


    /**
     * 使用ModelMap接收参数
     * @return
     */
    //    @HystrixCommand(fallbackMethod = "fallback")
    @Override
    public ModelMap hello() {
        ModelMap map = restTemplate.getForObject("http://service-order/hello",ModelMap.class);
        return map;
    }

    @Override
    public ModelMap hello1(String test) {
        ModelMap map = restTemplate.getForObject("http://service-order/hello1/param",ModelMap.class,test);
        return map;
    }

    public ModelMap fallback() {
        return new ModelMap("error","RibbonError");
    }
}
