package com.base.common;

import com.base.enums.ResultCode;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author jianjun1.wang
 * @version 1.0
 * @description:
 * @date 2021/2/24 15:53
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Result<T> {

    private Integer code;
    private String desc;

    private T data;

    public static Result SUCCESS(){
        return new Result(ResultCode.SUCCESS.getCode(), ResultCode.SUCCESS.getDesc(), null);
    }

    public static <T> Result SUCCESS(T data){
        return new Result(ResultCode.SUCCESS.getCode(), ResultCode.SUCCESS.getDesc(), data);
    }
}
