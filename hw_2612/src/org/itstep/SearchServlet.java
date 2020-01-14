package org.itstep;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SearchServlet
 */
@WebServlet("/SearchServlet") // в задании привязать к конечной точке search
public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SearchServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String first = request.getParameter("first"); // в задании Добавить параметры first_name, last_name в которые
		String last = request.getParameter("last");

		String SELECT = "Select count(*) from people.person where first_name = '" + first + "' AND last_name='" + last
				+ "';"; // что с sql инъекциями?

		int count = 0;

		try (Connection conn = DriverManager.getConnection(
				"jdbc:mysql://localhost/people?serverTimezone=Europe/Kiev&amp;characterEncoding=utf8", "root", "")) {
			PrintWriter writer = response.getWriter();
			Statement statement = conn.createStatement();
			long startTime = System.currentTimeMillis();
			ResultSet resultSet = statement.executeQuery(SELECT);

			long time = System.currentTimeMillis() - startTime;
			while (resultSet.next()) {
				count = resultSet.getInt(1);
			}
			writer.println("There are " + count + " people with searched name\n");
			writer.println("Execution time: " + time + " ms");

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
