package com.base.enums;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author jianjun1.wang
 * @version 1.0
 * @description:
 * @date 2021/2/24 16:11
 */

@Getter
@NoArgsConstructor
@AllArgsConstructor
public enum ResultCode {

    SUCCESS(10000, "成功"),
    FAILURE(9999, "失败"),

    ;

    private Integer code;
    private String desc;
}
