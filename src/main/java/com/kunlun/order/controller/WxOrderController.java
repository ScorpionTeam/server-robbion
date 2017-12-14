package com.kunlun.order.controller;

import com.kunlun.entity.Order;
import com.kunlun.order.service.WxOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

/**
 * @author by fk
 * @created on 2017/12/14.
 */
@RestController
@RequestMapping("/wx/order")
public class WxOrderController {

    @Autowired
    private WxOrderService wxOrderService;

    /**
     * 查询我的订单列表
     *
     * @param pageNo      当前页
     * @param pageSize    当前页数
     * @param wxCode      微信Code
     * @param orderStatus 订单状态
     * @return
     */
    @GetMapping("/findByUserId/{pageNo}/{pageSize}/{wxCode}/{orderStatus}")
    public ModelMap findByUserId(@PathVariable int pageNo,
                                 @PathVariable int pageSize,
                                 @PathVariable String wxCode,
                                 @PathVariable String orderStatus) {
        return wxOrderService.findByUserId(pageNo, pageSize, wxCode, orderStatus);
    }

    /**
     * 退款
     *
     * @param order 订单
     * @return
     */
    @PostMapping("/refund")
    public ModelMap refund(@RequestBody Order order) {
        return wxOrderService.refund(order);
    }

    /**
     * 查询订单详情
     *
     * @param orderId 订单id
     * @return
     */
    @GetMapping("/findByOrderId/{orderId}")
    public ModelMap findByOrderId(@PathVariable Long orderId) {
        return wxOrderService.findByOrderId(orderId);
    }

}
