package com.kunlun.order.service;

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
}
