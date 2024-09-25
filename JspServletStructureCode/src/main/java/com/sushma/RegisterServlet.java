package com.sushma;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sushma.dao.EmployeeDao;
import com.sushma.entity.Employee;

public class RegisterServlet extends HttpServlet {


	@Override
	public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException  {

		int id = Integer.parseInt( req.getParameter( "id" ) );
		String name = req.getParameter( "name" );
		int salary = Integer.parseInt( req.getParameter( "salary" ) );

	    Employee e=new Employee(id,name,salary);
	    
	    EmployeeDao dao=new EmployeeDao();
	    boolean isRegistered=dao.register(e);
	    
	    RequestDispatcher rd=null;
	    
	    if(isRegistered) {
			req.setAttribute("msg", "Register successful");
			rd=req.getRequestDispatcher("success.jsp");
		}else {
			req.setAttribute("errorMsg", "Register failed");
			rd=req.getRequestDispatcher("error.jsp");
		}
		
		rd.forward(req, res);
	}



}
