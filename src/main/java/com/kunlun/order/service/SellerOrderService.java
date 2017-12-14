package com.kunlun.order.service;

import org.springframework.ui.ModelMap;

/**
 * @author by kunlun
 * @version <0.1>
 * @created on 2017/12/14.
 */
public interface SellerOrderService {

    /**
     * 条件查询商家 订单列表
     * @param pageNo
     * @param pageSize
     * @return
     */
    ModelMap findByCondition(Integer pageNo,Integer pageSize);


}
