package com.huixiong.servlet;

import org.apache.catalina.Context;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.WebResourceRoot;
import org.apache.catalina.startup.Tomcat;
import org.apache.catalina.webresources.DirResourceSet;
import org.apache.catalina.webresources.StandardRoot;

import java.io.File;

/**
 * 这是使用嵌入式tomcat启动一个tomcat服务
 * 不需要引入ServletAPI
 * 因为引入依赖的时候会自动引入Servlet APi
 */
public class EmbedTomcat {
    public static void main(String[] args) throws LifecycleException {
        Tomcat tomcat = new Tomcat();
        tomcat.setPort(Integer.getInteger("port", 8089));
        tomcat.getConnector();
        // 创建webapp
        Context text = tomcat.addWebapp("", new File("src/main/webapp").getAbsolutePath());
        WebResourceRoot resourceRoot = new StandardRoot(text);
        resourceRoot.addPreResources(new DirResourceSet(resourceRoot, "/WEB-INF/classes",
                new File("target/classes").getAbsolutePath(), "/"));
        text.setResources(resourceRoot);
        tomcat.start();
        tomcat.getServer().await();
    }
}