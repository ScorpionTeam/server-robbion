package com.kunlun.order.service;

import com.alibaba.fastjson.JSONObject;
import com.kunlun.config.Constants;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
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
//    @HystrixCommand(fallbackMethod = "fallback")
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
//    @HystrixCommand(fallbackMethod = "fallback")
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
    @Override
    public ModelMap cancelOrder(JSONObject object, String ipAddress) {
        String url = Constants.SERVER_NAME + Constants.WX_MODULE + "cancelOrder";
        return restTemplate.postForObject(url, object, ModelMap.class);
    }

    /**
     * 确认收货
     *
     * @param id
     * @param ipAddress
     * @return
     */
    @Override
    public ModelMap confirmReceipt(Long id, String ipAddress) {
        String url = Constants.SERVER_NAME + Constants.WX_MODULE + id;
        return restTemplate.getForObject(url, ModelMap.class);
    }


    /**
     * 方法错误回传
     *
     * @return
     */
    public ModelMap fallback(JSONObject object) {
        return new ModelMap("ERROR", "服务器开小差.....请稍后再试");
    }
}
