package com.base.controller;

import com.base.common.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author jianjun1.wang
 * @version 1.0
 * @description:
 * @date 2021/2/22 15:10
 */
@Api(tags = "Demo API", value = "d")
@RestController
public class DemoControl {

    @ApiOperation(value = "demoGet")
    @GetMapping("get")
    public Result demoGet(){
        return Result.SUCCESS();
    }

    @ApiOperation(value = "demoPost")
    @PostMapping("post")
    public Result demoPost(){
        return Result.SUCCESS("OK");
    }
}
