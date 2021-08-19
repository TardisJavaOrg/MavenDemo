package com.huixiong.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.assertj.core.util.Lists;
import org.springframework.util.DigestUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.OptionalLong;
import java.util.concurrent.TimeUnit;

/**
 * 用户
 *
 * @author timothy.yang cloudwise
 * @since 2021-08-03 11:39
 */
@Data
@AllArgsConstructor
public class User {
    static List<User> empList = new ArrayList<>();

    private static void initEmp() {
        empList.add(new User("张三", null));
        empList.add(new User("张三1", null));
        empList.add(new User("张三2", null));
        empList.add(new User("张三3", null));
        empList.add(new User("张三4", null));
        empList.add(new User("张三5", null));
        empList.add(new User("张三6", null));
        empList.add(new User("张三7", null));
        empList.add(new User("张三8", null));
    }

    private String name;
    private Long age;

    //获取员工年龄的最大、最小、总和、平均值
    public static void main(String[] args) {
        System.out.println(ClassEnum.ABBB.name());
    }

    enum ClassEnum{
        ABBB,
        B
    }
    private static void process(List<String> ss) {
        for (int i = 0; i < 10; i++) {
            ss.add("a");
        }
    }

    public String getAlgorithmTaskId(String modelId, String metricKey, String targetName, String algorithmPrimaryId, String dimensionConditionJson) {
//        dimensionConditionJson = StringUtils.defaultIfBlank(dimensionConditionJson, "{}");
        StringBuilder taskIdSB = new StringBuilder(modelId).append('_').append(metricKey).append('_').append(targetName);
        taskIdSB.append('_').append(dimensionConditionJson).toString();
        taskIdSB.append('_').append(algorithmPrimaryId);
//        String md5 = DigestUtils.appendMd5DigestAsHex(taskIdSB);
//        log.debug("AlgorithmTaskService getAlgorithmTaskId taskId is [{}]", md5);
        return taskIdSB.toString();
    }
}
