package com.kunlun.order.service;

import com.alibaba.fastjson.JSONObject;
import org.springframework.ui.ModelMap;

/**
 * @author by fk
 * @created on 2017/12/14.
 */
public interface WxOrderService {

    /**
     * 查询我的订单列表
     *
     * @param pageNo
     * @param pageSize
     * @param wxCode
     * @param orderStatus
     * @return
     */
    ModelMap findByUserId(int pageNo, int pageSize, String wxCode, String orderStatus);

    /**
     * 退款
     *
     * @param object
     * @return
     */
    ModelMap refund(JSONObject object);

    /**
     * 查询订单详情
     *
     * @param orderId
     * @return
     */
    ModelMap findByOrderId(Long orderId);
}
