package com.huixiong.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 转发，由服务器端控制，不需要浏览器端像重定向一样再次发送请求
 */
@WebServlet(urlPatterns = "/forword")
public class ForwordServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        System.out.println(name);
        if ("god".equals(name)) {
            req.getRequestDispatcher("/").forward(req,resp);
        }else{
            PrintWriter pw = resp.getWriter();
            name = "NoBody";
            pw.write("<h1>Morning " + name + "!</h1>");
            pw.flush();
        }
    }
}
