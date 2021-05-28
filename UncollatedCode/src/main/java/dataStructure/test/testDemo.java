package dataStructure.test;

import com.alibaba.fastjson.JSON;

/**
 * @author timothy
 * @data 2021年05月26日 4:23 下午
 */
public class testDemo {
    public static void main(String[] args) {
        String s = JSON.toJSONString(true + "");
        System.out.println(s);
    }
}
