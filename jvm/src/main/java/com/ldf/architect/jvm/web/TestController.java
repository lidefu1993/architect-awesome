package com.ldf.architect.jvm.web;

import com.ldf.architect.jvm.bean.HeapBean;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author lidefu
 * @date 2019/2/14 10:51
 */
@RestController
@RequestMapping("test")
public class TestController {

    @ApiOperation("测试")
    @GetMapping("/")
    public String test(){
        return "success";
    }

    @ApiOperation("堆溢出")
    @GetMapping("heap")
    public void heapTest(boolean flag){
        List<HeapBean> list = new ArrayList<>();
        while (flag){
            list.add(new HeapBean());
        }
    }

}
