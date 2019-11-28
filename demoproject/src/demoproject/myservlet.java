package demoproject;

import java.awt.print.Printable;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class myservlet extends HttpServlet {

	

	

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException

	{
		PrintWriter out = res.getWriter();

		try {
			Connection con = dbconnection.getConnection();

			// Statement query=con.createStatement();

			String query = "insert into registertable(name,email,mobno) values(?,?,?)";
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, req.getParameter("name"));
			ps.setString(2, req.getParameter("email"));
			ps.setString(3, req.getParameter("mobno"));

			int RowsAffected = ps.executeUpdate();

			if (RowsAffected != 1) {

				
				out.print("<p>Data Insertion failled</p>");
				req.getRequestDispatcher("registration.html").include(req, res);

			} else {

				
				out.print("<p>Data Inserted Successfully</p>");
				req.getRequestDispatcher("registration.html").include(req, res);
			}

		} catch (Exception e) {
			System.out.println(e);
		}

		
		 
	}

}
