package com.huixiong.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 设置和使用cookie
 */
@WebServlet(urlPatterns = "/cookie")
public class CookieServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie cookie = new Cookie("language", "en"); // 创建一个cookie对象
        cookie.setPath("/"); // 设置生效范围，这里是所有路径生效
        cookie.setMaxAge(900); // 设置cookie存活时间，单位秒
//        cookie.setSecure(true);// https访问时必须设置sccure位true
        resp.addCookie(cookie); // 将cookie添加到resp中
        resp.sendRedirect("/");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 获取请求附带的所有Cookie:
        Cookie[] cookies = req.getCookies();
        // 如果获取到Cookie:
        if (cookies != null) {
            // 循环每个Cookie:
            for (Cookie cookie : cookies) {
                // 如果Cookie名称为lang:
                if (cookie.getName().equals("lang")) {
                    // 返回Cookie的值:
                    System.out.println(cookie.getValue());
                }
            }
        }
    }
}