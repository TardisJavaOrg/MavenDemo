package com.huixiong;

import org.junit.jupiter.api.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * <描述>
 *
 * @author timothy.yang cloudwise
 * @since 2021-09-16 09:43
 */
public class RegexTest {
    @Test
    public void regexpTest(){
        // 按指定模式在字符串查找
        String line = "This order was placed for QT3000! OK?";
        String pattern = "order.*";

        // 创建 Pattern 对象
        Pattern r = Pattern.compile(pattern);

        // 现在创建 matcher 对象
        Matcher m = r.matcher(line);
        if (m.find()) {
            System.out.println("Found value: " + m.group(0) );
        } else {
            System.out.println("NO MATCH");
        }
    }

    @Test
    public void matchTest(){
        String input = "Up(1)";
        System.out.println(Pattern.matches("(.*Up.*)", input));
    }
}
