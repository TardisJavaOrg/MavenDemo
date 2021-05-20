package mvcServlet;

import org.apache.catalina.Context;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.WebResourceRoot;
import org.apache.catalina.startup.Tomcat;
import org.apache.catalina.webresources.DirResourceSet;
import org.apache.catalina.webresources.StandardRoot;

import java.io.File;

/**
 * @author timothy
 * @data 2021年05月20日 6:18 下午
 */
public class MvcMain {
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
