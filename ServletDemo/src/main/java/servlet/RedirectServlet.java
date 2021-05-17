package servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 临时重定向：302
 * 访问这个路由会自动重定向到 / 下
 */
@WebServlet(urlPatterns = "/redirect")
public class RedirectServlet extends HttpServlet {
    @Override
    protected void doGet(final HttpServletRequest req, final HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String redirectToUrl = req.getContextPath()+"/" + (name == null ? "":"?name="+name);
        resp.setStatus(HttpServletResponse.SC_MOVED_PERMANENTLY);// 设置status和header后，将是永久重定向，浏览器下次访问该链接会直接访问真正的url。
        resp.setHeader("Location","/");
        resp.sendRedirect(redirectToUrl);
    }
}