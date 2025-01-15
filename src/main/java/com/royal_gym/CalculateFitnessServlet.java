package com.royal_gym;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/CalculateFitnessServlet")
public class CalculateFitnessServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		double weight = Double.parseDouble(request.getParameter("weight"));
		double height = Double.parseDouble(request.getParameter("height"));

		double heightInMeters = height / 100;
		double bmi = weight / (heightInMeters * heightInMeters);

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<html><body>");
		out.println("<h2>Your BMI is: " + bmi + "</h2>");
		out.println("<a href='fitnessCalculator.jsp'>Back to Calculator</a>");
		out.println("</body></html>");
	}
}
