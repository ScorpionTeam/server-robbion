package com.kunlun.order.service;

import com.kunlun.entity.Order;
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
     * @param order
     * @return
     */
    ModelMap refund(Order order);

    /**
     * 查询订单详情
     *
     * @param orderId
     * @return
     */
    ModelMap findByOrderId(Long orderId);
}
