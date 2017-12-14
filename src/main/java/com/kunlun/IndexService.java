package com.kunlun;

import com.kunlun.result.BaseResult;
import com.kunlun.result.SuccessResult;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.ModelMap;

/**
 * @author by kunlun
 * @version <0.1>
 * @created on 2017/12/13.
 */
public interface IndexService {

    ModelMap hello();

    ModelMap hello1(String test);
}
