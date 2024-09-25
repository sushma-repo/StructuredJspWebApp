package com.sushma.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.sushma.entity.Employee;
import com.sushma.utility.ConnectionFactory;

public class EmployeeDao {
	
	public boolean register(Employee emp)  {
			
		try {
			
			Connection con = ConnectionFactory.getCon();
			PreparedStatement ps = con.prepareStatement( "insert into employee values(?,?,?)" );
			ps.setInt( 1, emp.getId() );
			ps.setString( 2, emp.getName() );
			ps.setInt( 3, emp.getSalary() );
			int result = ps.executeUpdate();
			if (result == 1)
				return true;
			
		} catch ( Exception e ) {
			e.printStackTrace();
		}
		return false;
		
	}
	
	public List<Employee> getAllEmployee(){
		try {
			Connection con = ConnectionFactory.getCon();
			
			PreparedStatement ps = con.prepareStatement("select * from employee");

			ResultSet rs = ps.executeQuery();

			List<Employee> empList = new ArrayList<>();
			
			while (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				int sal = rs.getInt("salary");

				Employee e = new Employee(id, name, sal);
				empList.add(e);
			}

			return empList;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public Employee getEmployeebyId(int id) {
		
		try {
			Connection con =ConnectionFactory.getCon();
			PreparedStatement ps = con.prepareStatement( "select * from employee where id=?" );
			ps.setInt( 1, id );
			ResultSet rs = ps.executeQuery();
			
			if ( rs.next() ) {		
				int i = rs.getInt( "id" );
				String name = rs.getString( "name" );
				int sal = rs.getInt( "salary" );
				Employee e = new Employee( id, name, sal );
				return e;
			} 
			
		 } catch ( Exception e ) {
			e.printStackTrace();
		}
		
		return null;
		
	}
	
	
	public boolean updateEmployee(int id,int sal) {
		
		try {	
			Connection con = ConnectionFactory.getCon();
			PreparedStatement ps = con.prepareStatement( "update employee set salary=? where id=?" );
			ps.setInt( 1, sal );
			ps.setInt( 2, id );
			int result = ps.executeUpdate();

			if (result == 1)
				return true;
			
		} catch ( Exception e ) {
			e.printStackTrace();
		}
		
		return false;

	}

}
