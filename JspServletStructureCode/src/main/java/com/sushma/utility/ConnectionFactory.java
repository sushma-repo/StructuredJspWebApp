package com.sushma.utility;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {
		
		private static Connection con = null;
		
		static{
			
			try {
				Class.forName( "com.mysql.cj.jdbc.Driver" );

				con = DriverManager.
						getConnection("jdbc:mysql://localhost:3306/university?useSSL=false","root","Sushu@4997");
			}catch ( Exception e ) {
			e.printStackTrace();
			}

		}
		
		public static Connection getCon() {
			return con;	
		}
	}
	




