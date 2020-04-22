package servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * TestServletV3
 *
 * @author wangkm
 * @date 2020-03-05
 * @since 0.0.1
 */
@WebServlet("/testServletV3")
public class TestServletV3 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String myHeader = req.getHeader("myHeader");
        resp.getWriter().println("Hello servlet GET v3 " + myHeader);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String param = req.getParameter("param");
        resp.getWriter().println("Hello servlet POST v3 " + param);
    }
}
