package com.royal_gym;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/ContactServlet")
public class ContactServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String message = request.getParameter("message");

		Connection con = null;
		PreparedStatement ps = null;

		try {

			con = db_con.getConnection();

			String query = "INSERT INTO contact_info (name, email, message) VALUES (?, ?, ?)";
			ps = con.prepareStatement(query);
			ps.setString(1, name);
			ps.setString(2, email);
			ps.setString(3, message);

			int result = ps.executeUpdate();

			response.setContentType("text/html");
			PrintWriter out = response.getWriter();
			out.println("<html><body>");
			if (result > 0) {
				out.println("<h2>Thank you for contacting us, " + name + "!</h2>");
			} else {
				out.println("<h2>Sorry, there was an error. Please try again.</h2>");
			}
			out.println("<a href='contact.jsp'>Go back to Contact</a>");
			out.println("</body></html>");
		} catch (SQLException e) {
			e.printStackTrace();
			response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Database error");
		} finally {

			try {
				if (ps != null)
					ps.close();
				if (con != null)
					con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
