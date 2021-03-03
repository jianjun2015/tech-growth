package com.base._2_algorithm;

import cn.hutool.core.date.DateField;
import cn.hutool.core.date.DatePattern;
import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;
import org.assertj.core.util.Lists;
import org.springframework.util.CollectionUtils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author jianjun1.wang
 * @version 1.0
 * @description: 给定时间 年月日 时分 给定延迟 小时:分钟 算出最终的工作日 年月日 时分秒
 * @date 2021/3/3 17:40
 */
public class MainClass {

    public static void main(String[] args) {

        String cur = "2021-03-03 17:33:12";
        String delayTime = "10:23";

//        String result = calcDate(cur, delayTime);
        System.out.println(DateUtil.format(DateUtil.parse("10:11:00"), "hh:mm:ss"));
    }

    private static String calcDate(String cur, Integer delayHourMinutes) {

        String startDate = DateUtil.format(DateUtil.parse(cur), "hh:mm:ss");
        //开始时间的配置
        Integer delayDays = 0;
        final DateConfig curDateConfig = getConfig(startDate);

        Integer sumHourMinutes = 0;
        //计算当天剩余的工作小时分钟数
        final String[] wordSegments = curDateConfig.getWorkTime().split(",");

        Boolean firstSegFlag = true;
        List<Integer> needAddHourMinutes = Lists.newArrayList();
        for (String segment : wordSegments) {
            DateTime segments = DateUtil.parse(curDateConfig.getDate()+" "+segment.split(":")[0]);
            DateTime segmente = DateUtil.parse(curDateConfig.getDate()+" "+segment.split(":")[0]);
            if (DateUtil.parse(startDate).before(segments)){
                if (firstSegFlag) {
                    sumHourMinutes = curDateConfig.getWorkHourMinutes();
                    break;
                }
                needAddHourMinutes.add(calcSegmentHourMinutes(segments, segmente));
                firstSegFlag = false;
                continue;
            }
            firstSegFlag = false;
            //在区间内 计算当前区间剩余时间数
            if (DateUtil.parse(startDate).isAfter(segments) && DateUtil.parse(startDate).isBefore(segmente)){
                needAddHourMinutes.add(calcSegmentHourMinutes(DateUtil.parse(startDate), segmente));
            }
        }

        if (sumHourMinutes == 0) {
            final long sum = needAddHourMinutes.stream().collect(Collectors.summarizingInt(value -> value)).getSum();
            if (sum > delayHourMinutes){
                //可以计算最终值
                return null;
            }
        }

        if (sumHourMinutes > delayHourMinutes) {
            //可以计算最终值
            return null;
        }

        //继续延后一天计算
        return null;
    }


    /**
     *
     * @param sumHourMinutes
     * @param delayHourMinutes
     * @return
     */
    private static Boolean compareHourMinutes(String sumHourMinutes, String delayHourMinutes) {

        final String[] sums = sumHourMinutes.split(":");
        final String[] delays = delayHourMinutes.split(":");

        //需要继续延迟
        if (Integer.valueOf(sums[0])*60+Integer.valueOf(sums[1]) < Integer.valueOf(sums[0])*60+Integer.valueOf(sums[1])){
            return false;
        }

        //已经找到
        return true;
    }

    /**
     * 计算第一天剩余的工作 小时分钟数
     * @param firstHourMinutes
     * @param needAddHourMinutes
     * @return
     */
    private static String calcFisrtSegmentsHourMinutes(String firstHourMinutes, List<String> needAddHourMinutes) {

        if (CollectionUtils.isEmpty(needAddHourMinutes)){
            return firstHourMinutes;
        }


        return null;
    }

    /**
     * 计算每个工作段的 小时分钟数
     * @param segments
     * @param segmente
     * @return
     */
    private static Integer calcSegmentHourMinutes(DateTime segments, DateTime segmente) {

        final int ms = segments.getField(DateField.MINUTE);
        final int me = segmente.getField(DateField.MINUTE);
        final int hs = segments.getField(DateField.HOUR);
        int he = segmente.getField(DateField.HOUR);

        int m = 0;
        if (ms > me){
            m = me+60-ms;
            he = he - 1;
        }else {
            m = me - ms;
        }

        if (hs > he){
            return -1;
        }
        int h = he - hs;
        return h*60+m;
    }

    private static DateConfig getConfig(String startDate) {
        //初始化配置数据 初始会计算每日的工作小时分钟数
        List<DateConfig> dateConfigs = Arrays.asList(
                DateConfig.builder().date("2021-03-02").workTime("09:30-12:00,14:12-17:00").workHourMinutes(5*60+18).build(),
                DateConfig.builder().date("2021-03-03").workTime("09:30-12:00,14:12-17:00").workHourMinutes(5*60+18).build(),
                DateConfig.builder().date("2021-03-04").workTime("10:30-12:00,14:12-17:00").workHourMinutes(4*60+18).build(),
                DateConfig.builder().date("2021-03-05").workTime("09:30-11:00,14:12-17:00").workHourMinutes(5*60+18).build(),
                DateConfig.builder().date("2021-03-06").workTime(null).build(),
                DateConfig.builder().date("2021-03-07").workTime("09:30-12:00,13:12-17:00").workHourMinutes(5*60+18).build(),
                DateConfig.builder().date("2021-03-08").workTime("09:34-12:00,15:12-17:04").workHourMinutes(5*60+18).build(),
                DateConfig.builder().date("2021-03-09").workTime(null).build(),
                DateConfig.builder().date("2021-03-10").workTime("09:20-12:40,14:12-17:40").workHourMinutes(5*60+18).build(),
                DateConfig.builder().date("2021-03-11").workTime("09:50-12:03,14:12-17:40").workHourMinutes(5*60+41).build()
        );

        final DateConfig config = dateConfigs.stream().filter(dateConfig -> (DateUtil.parse(dateConfig.getDate()).isAfter(DateUtil.parse(startDate)) && null != dateConfig.getWorkTime())).findFirst().orElse(null);
        return config;
    }

}
