package com.sushma;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sushma.dao.EmployeeDao;
import com.sushma.entity.Employee;



public class SelectAllServlet extends HttpServlet {

	@Override
	protected void service( HttpServletRequest req, HttpServletResponse res ) throws ServletException, IOException {
    
		res.setContentType("text/html");

		EmployeeDao dao = new EmployeeDao();
		List<Employee> list = dao.getAllEmployee();
          
		RequestDispatcher rd=null;
		 
		if (list == null) {
			req.setAttribute("msg", "No record found");
			 rd = req.getRequestDispatcher("success.jsp");
		} else {
			req.setAttribute("empList", list);
			 rd = req.getRequestDispatcher("displayAll.jsp");
		}
		//res.setContentType("text/html");
		rd.forward(req, res);
	}
}