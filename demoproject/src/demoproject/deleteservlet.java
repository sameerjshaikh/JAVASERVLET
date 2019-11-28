package demoproject;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class deleteservlet extends HttpServlet {
	
	
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException
	{
		PrintWriter out=res.getWriter();
		
		try {
			Connection con =dbconnection.getConnection();
			String query="delete from registertable where name=?";
			
			PreparedStatement ps=con.prepareStatement(query);
			ps.setString(1, req.getParameter("name"));
			
			int RowsAffected=ps.executeUpdate();
			
			if(RowsAffected!=1)
			{
				req.getRequestDispatcher("registration.html").include(req, res);
				out.print("<p>data not Deleted</p>");
			}
			else
			{
				req.getRequestDispatcher("registration.html").include(req, res);
				out.print("<p>Row Deleted</p>");
			}
			
			
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		
	}
	

}
