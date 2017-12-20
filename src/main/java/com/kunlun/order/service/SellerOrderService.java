package com.kunlun.order.service;


import com.alibaba.fastjson.JSONObject;
import org.springframework.ui.ModelMap;

/**
 * @author by kunlun
 * @version <0.1>
 * @created on 2017/12/14.
 */
public interface SellerOrderService {

    /**
     * 订单列表
     *
     * @param object
     * @return
     */
    ModelMap findByCondition(JSONObject object);
}
