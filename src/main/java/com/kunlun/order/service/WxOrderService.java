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
     * @param object
     * @return
     */
    ModelMap findByWxCode(JSONObject object);

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
     * @param object
     * @return
     */
    ModelMap findByOrderId(JSONObject object);

    /**
     * 签收后评价
     *
     * @param object
     * @return
     */
    ModelMap estimate(JSONObject object);

    /**
     * 取消订单
     *
     * @param object
     * @param ipAddress
     * @return
     */
    ModelMap cancelOrder(JSONObject object, String ipAddress);

    /**
     * 确认收货
     *
     * @param object
     * @param ipAddress
     * @return
     */
    ModelMap confirmByGood(JSONObject object, String ipAddress);
}
