package com.kunlun;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author by kunlun
 * @version <0.1>
 * @created on 2017/12/13.
 */
@RestController
@RequestMapping("/balance")
public class IndexController {


    @Autowired
    private IndexService indexService;

    @GetMapping("/hello")
    public String hello(){
        return indexService.hello();
    }
}
