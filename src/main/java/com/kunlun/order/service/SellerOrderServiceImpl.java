package com.kunlun.order.service;

import com.kunlun.config.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;
import org.springframework.web.client.RestTemplate;

/**
 * @author by kunlun
 * @version <0.1>
 * @created on 2017/12/14.
 */
@Service
public class SellerOrderServiceImpl implements SellerOrderService {

    @Autowired
    private RestTemplate restTemplate;

    /**
     * 分页查询商家 订单列表
     *
     * @param pageNo
     * @param pageSize
     * @return
     */
    @Override
    public ModelMap findByCondition(Integer pageNo, Integer pageSize) {
        String url = Constants.ORDER_FIND_CONDITION + pageNo + "/" + pageSize;
        return restTemplate.getForObject(url, ModelMap.class);
    }


}
