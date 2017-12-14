package com.kunlun.config;

/**
 * @author by kunlun
 * @version <0.1>
 * @created on 2017/12/14.
 */
public class Constants {

    /**
     * 商户订单url
     */
    public static final String SELLER_ORDER = "http://service-order/seller/order/";

    /**
     * 商户查找所有订单
     */
    public static final String ORDER_FIND_CONDITION = SELLER_ORDER + "findByCondition/";

    /**
     * 微信 查询我的订单列表
     */
    public static final String WX_ORDER = "http://service-order/wx/order/";
}
