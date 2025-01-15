package com.royal_gym;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/StoreDataServlet")
public class StoreDataServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		// Retrieve form data
		String name = request.getParameter("name");
		String age = request.getParameter("age");
		String gender = request.getParameter("gender");
		String locality = request.getParameter("locality");
		String email = request.getParameter("email");
		String mobile = request.getParameter("mobile");

		Connection con = null;
		PreparedStatement ps = null;

		try {

			con = db_con.getConnection();

			if (con == null) {
				out.println("<h3>Database Connection Failed!</h3>");
				return;
			}

			String query = "INSERT INTO members (name, age, gender, locality, email, mobile) VALUES (?, ?, ?, ?, ?, ?)";
			ps = con.prepareStatement(query);

			ps.setString(1, name);
			ps.setString(2, age);
			ps.setString(3, gender);
			ps.setString(4, locality);
			ps.setString(5, email);
			ps.setString(6, mobile);

			int result = ps.executeUpdate();

			if (result > 0) {
				out.println("<h3>Registration Successful!</h3>");
			} else {
				out.println("<h3>Error occurred. Please try again!</h3>");
			}
		} catch (Exception e) {
			e.printStackTrace();
			out.println("<h3>An error occurred while processing your request.</h3>");
			out.println("<p>Error Details: " + e.getMessage() + "</p>");
		} finally {
			try {

				if (ps != null)
					ps.close();
				if (con != null)
					con.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
