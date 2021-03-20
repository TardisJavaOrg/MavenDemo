package com.huixiong.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

/**
 * 使用session保存登录状态
 */
@WebServlet(urlPatterns = "/session-sigin")
public class SessionSigninServlet extends HttpServlet {
    private static Map<String, String> users = new HashMap<>();

    static {
        users.put("huixiong", "123456");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter pw = resp.getWriter();
        pw.write("<h1>Sign In</h1>");
        pw.write("<form action=\"/session\" method=\"post\">");
        pw.write("<p>Username: <input name=\"username\"></p>");
        pw.write("<p>Password: <input name=\"password\" type=\"password\"></p>");
        pw.write("<p><button type=\"submit\">Sign In</button> <a href=\"/\">Cancel</a></p>");
        pw.write("</form>");
        pw.flush();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        if (password.equals(users.get("huixiong"))) {
            HttpSession session = req.getSession();
            session.setAttribute("user", username);
            resp.sendRedirect("/" + "?name=" + username);
        } else {
            resp.sendError(HttpServletResponse.SC_FORBIDDEN);
        }
    }

}
