package servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * HttpServlet 是 Java内部已经实现的方法
 * 需要使用外部 tomcat
 */
@WebServlet(urlPatterns = "/")
public class HelloServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 设置响应头
        resp.setContentType("text/html");
        // 获取请求参数
        String name = req.getParameter("name");

        // 设置响应体
        PrintWriter pw = resp.getWriter();
        pw.write("<h1>Hello " + name + "!</h1>");
        pw.flush();
    }
}