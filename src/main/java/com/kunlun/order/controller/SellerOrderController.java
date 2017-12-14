package com.kunlun.order.controller;

import com.kunlun.order.service.SellerOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author by kunlun
 * @version <0.1>
 * @created on 2017/12/14.
 */
@RestController
@RequestMapping("/seller/order")
public class SellerOrderController {

    @Autowired
    private SellerOrderService sellerOrderService;

    @GetMapping("/findByCondition/{pageNo}/{pageSize}")
    public ModelMap findByCondition(@PathVariable Integer pageNo, @PathVariable Integer pageSize) {
        return sellerOrderService.findByCondition(pageNo, pageSize);
    }


}
