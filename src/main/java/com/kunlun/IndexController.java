package com.kunlun;

import com.kunlun.entity.Seller;
import com.kunlun.result.BaseResult;
import com.kunlun.result.SuccessResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

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
    public ModelMap hello() {
        return indexService.hello();
    }

    @GetMapping("/hello/param/{test}")
    public ModelMap hello1(@PathVariable String test) {
        return indexService.hello1(test);
    }

}
