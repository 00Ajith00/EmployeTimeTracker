package controller;

import utils.DataBaseUtil;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.annotation.WebServlet;
@WebServlet("/AdminLoginServlet")

public class AdminLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        try {
            Connection con = DataBaseUtil.getConnection();
            PreparedStatement ps = con.prepareStatement("SELECT * FROM Admin WHERE username=? AND password=?");
            ps.setString(1, username);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            
            if (rs.next()) {
                HttpSession session = request.getSession();
                session.setAttribute("userid", username);
                response.sendRedirect("AdminDashboard.jsp");
            } else {
                response.sendRedirect("AdminLogin.jsp?error=1");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
