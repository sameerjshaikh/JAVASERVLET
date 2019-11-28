package demoproject;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.jasper.tagplugins.jstl.core.Out;

//@WebServlet("/viewservlet")
public class viewservlet extends HttpServlet {
	
  
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		PrintWriter out = response.getWriter();
		try
		{
			Connection con=dbconnection.getConnection();
			String select="Select * from registertable";
			Statement query= con.createStatement();
			
			ResultSet rs=query.executeQuery(select);
			
		
			//request.getRequestDispatcher("fetchdata.html").include(request, response);
			out.print("<table align='left' border='1'>");
			out.print("<th>NAME</th> <th>EMAIL</th> <th>MOBILE NO</th>");
			
			while(rs.next())
			{
				out.print("<tr>");
				out.print("<td>"+rs.getString(1)+"</td>"+" <td>"+rs.getString(2)+"</td>"+" <td>"+rs.getString(3)+"</td>");
				out.print("</tr></br>");
			}
			
			out.print("</table>");
		
		
			
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
