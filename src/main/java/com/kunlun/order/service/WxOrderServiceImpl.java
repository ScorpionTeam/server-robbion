package com.kunlun.order.service;

import com.github.pagehelper.util.StringUtil;
import com.kunlun.config.Constants;
import com.kunlun.entity.Order;
import com.kunlun.result.BaseResult;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
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
    @HystrixCommand(fallbackMethod = "fallback")
    @Override
    public ModelMap findByUserId(int pageNo, int pageSize, String wxCode, String orderStatus) {
        String url = Constants.SERVER_NAME + Constants.WX_MODULE + "findByUserId/" + pageNo + "/" + pageSize + "/" + wxCode + "/" + orderStatus;
        return restTemplate.getForObject(url, ModelMap.class);
    }

    /**
     * 退款
     *
     * @param order
     * @return
     */
    @HystrixCommand(fallbackMethod = "fallback")
    @Override
    public ModelMap refund(Order order) {
        ModelMap modelMap = new ModelMap();
        Long id = order.getId();
        if (StringUtil.isEmpty(id.toString())) {
            return modelMap.addAttribute("0003", "查无结果");
        }
        String url = Constants.SERVER_NAME + Constants.WX_MODULE + "refund";
        return restTemplate.postForObject(url, order, ModelMap.class);
    }

    /**
     * 查询订单详情
     *
     * @param orderId
     * @return
     */
    @Override
    public ModelMap findByOrderId(Long orderId) {
        ModelMap modelMap = new ModelMap();
        if (orderId == null) {
            return modelMap.addAttribute("002", "参数错误");
        }
        String url = Constants.SERVER_NAME + Constants.WX_MODULE + "findByOrderId/" + orderId;
        return restTemplate.getForObject(url, ModelMap.class);
    }

    /**
     * 方法错误回传
     *
     * @return
     */
    public ModelMap fallback() {
        return new ModelMap("ERROR", "服务器开小差.....请稍后再试");
    }
}
