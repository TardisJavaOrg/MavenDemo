package com.huixiong.bio;

import java.io.File;
import java.net.URL;

/**
 * <描述>
 *
 * @author timothy.yang cloudwise
 * @since 2021-07-17 15:32
 */
public class IOMain {
    public static void main(String[] args) {
        URL resource = IOMain.class.getResource("");
        String path = resource.getPath();
        System.out.println(path);
        File file = new File(path);
    }
}
