package com.base._2_algorithm;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;

/**
 * @author jianjun1.wang
 * @version 1.0
 * @description:
 * @date 2021/3/3 17:38
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DateConfig {

    private String date;
    private String workTime;
    private Integer workHourMinutes;
}
