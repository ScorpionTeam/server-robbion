package com.kunlun.order.service;

import com.kunlun.config.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;
import org.springframework.web.client.RestTemplate;

/**
 * @author by fk
 * @created on 2017/12/14.
 */
@Service
public class WxOrderServiceImpl implements WxOrderService {

    @Autowired
    private RestTemplate restTemplate;

    /**
     * 查询我的订单列表
     *
     * @param pageNo
     * @param pageSize
     * @param wxCode
     * @param orderStatus
     * @return
     */
    @Override
    public ModelMap findByUserId(int pageNo, int pageSize, String wxCode, String orderStatus) {
        String url = Constants.WX_ORDER + pageNo + "/" + pageSize + "/" + wxCode + "/" + orderStatus;
        return restTemplate.getForObject(url, ModelMap.class);
    }
}
