package com.base._4_lambda;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Lists;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @author jianjun1.wang
 * @version 1.0
 * @description:
 * @date 2021/3/9 15:20
 */
public class MainClass {

    public static void main(String[] args) {
        List<A> aList = Lists.newArrayList(
                A.builder().addr("addr1").age(10).build(),
                A.builder().addr("addr2").age(20).build(),
                A.builder().addr("addr3").age(40).build(),
                A.builder().addr("addr2").age(11).build()
        );

        List<A> bList = Lists.newLinkedList();
        List<A> cList = Lists.newArrayList(
                A.builder().addr("addr3").age(40).build(),
                A.builder().addr("addr2").age(11).build()
        );

        aList.removeAll(cList);
        System.out.println(JSONObject.toJSONString(aList));

        bList.removeAll(bList);
        System.out.println(JSONObject.toJSONString(bList));

//        final Map<String, List<A>> stringListMap = bList.stream().collect(Collectors.groupingBy(A::getAddr));
//        System.out.println(JSONObject.toJSONString(stringListMap));
//        System.out.println(JSONObject.toJSONString(aList.stream().collect(Collectors.groupingBy(A::getAddr))));
//        System.out.println(JSONObject.toJSONString(aList.stream().collect(Collectors.toMap(A::getAddr, Function.identity(), (key1,key2)->key2))));
    }
}

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
class A{
    private Integer age;
    private String addr;
}