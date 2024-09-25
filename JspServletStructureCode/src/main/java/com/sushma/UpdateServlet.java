package com.sushma;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sushma.dao.EmployeeDao;

public class UpdateServlet extends HttpServlet {


	@Override
	public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException  {
	 
		int id = Integer.parseInt( req.getParameter( "id" ) );
		int salary = Integer.parseInt( req.getParameter( "sal" ) );
		
		EmployeeDao dao=new EmployeeDao();
		boolean isUpdated=dao.updateEmployee(id, salary);
		
		RequestDispatcher rd=null;
		if(isUpdated) {
			req.setAttribute("msg", "Salary Updation successful");
			rd=req.getRequestDispatcher("success.jsp");
		}else {
			req.setAttribute("errorMsg", "Salary Updation failed");
			rd=req.getRequestDispatcher("error.jsp");
		}
		
		rd.forward(req, res);	
		
	}


}
