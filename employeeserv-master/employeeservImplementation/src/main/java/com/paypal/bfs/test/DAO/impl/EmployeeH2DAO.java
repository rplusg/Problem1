package com.paypal.bfs.test.DAO.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.paypal.bfs.test.DAO.IEmployeeDAO;
import com.paypal.bfs.test.Search.IEmployeeFilterCriterion;
import com.paypal.bfs.test.Search.IEmployeeOrderCriterion;
import com.paypal.bfs.test.employeeserv.api.model.Employee;

public class EmployeeH2DAO implements IEmployeeDAO {
	   static final String JDBC_DRIVER = "org.h2.Driver";   
	   static final String DB_URL = "jdbc:h2:mem:employee";  
	   
	   //  Database credentials 
	   static final String USER = "sa"; 
	   static final String PASS = ""; 

	@Override
	public boolean createEmployee(Employee emp) {
		   boolean bRet=true;
		   Connection conn = null; 
		      Statement stmt = null; 
		      try{
		         // STEP 1: Register JDBC driver 
		         Class.forName(JDBC_DRIVER);  
		         
		         // STEP 2: Open a connection 
		         System.out.println("Connecting to a selected database..."); 
		         conn = DriverManager.getConnection(DB_URL,USER,PASS); 
		         System.out.println("Connected database successfully..."); 
		         
		         
		         // STEP 3: Execute a query 
		         stmt = conn.createStatement();
		         
		         String sql = "CREATE TABLE IF NOT EXISTS EMPLOYEE (ID VARCHAR(255) PRIMARY KEY,\r\n" + 
		         		"   firstName VARCHAR(255), lastName VARCHAR(255), dob VARCHAR(255), address VARCHAR(255));";
		                 stmt.executeUpdate(sql); 
		                 
		                 //System.out.println(emp);  
		                 ObjectMapper mapper = new ObjectMapper();
		                
		          sql = "INSERT INTO EMPLOYEE " + "VALUES (" + "'"+ emp.getId().toString() +"'"+ ", "+ "'"+emp.getFirstName() + "'"+", "+ "'"+emp.getLastName() + "'"+", " + "'"+emp.getDob().toString() + "'"+", "+ "'"+ mapper.writeValueAsString( emp.getAddress()) + "'" + ")";
		        //System.out.println(sql);  
		         
		         stmt.executeUpdate(sql);	         
		          
		         
		         // STEP 4: Clean-up environment 
		         stmt.close(); 
		         conn.close(); 
		      } catch(SQLException se) { 
		         // Handle errors for JDBC 
		         se.printStackTrace(); 
		         bRet=false;
		      } catch(Exception e) { 
		         // Handle errors for Class.forName 
		         e.printStackTrace();
		         bRet=false;
		      } finally { 
		         // finally block used to close resources 
		         try {
		            if(stmt!=null) stmt.close();  
		         } catch(SQLException se2) { 
		        	 bRet=false;
		         } // nothing we can do 
		         try { 
		            if(conn!=null) conn.close(); 
		         } catch(SQLException se) { 
		            se.printStackTrace(); 
		         } // end finally try 
		      } // end try
		      
		      return bRet;		
	}

	@Override
	public Employee getEmployeeByID(String id) {
		   Connection conn = null; 
		      Statement stmt = null; 
		      Employee empRet = null;
		      try{
		         // STEP 1: Register JDBC driver 
		         Class.forName(JDBC_DRIVER);  
		         
		         // STEP 2: Open a connection 
		         System.out.println("Connecting to a selected database..."); 
		         conn = DriverManager.getConnection(DB_URL,USER,PASS); 
		         System.out.println("Connected database successfully..."); 
		         
		         
		         // STEP 3: Execute a query 
		         stmt = conn.createStatement();
		         
		         String sql = "select * from EMPLOYEE where id="+id;  
		         		
		         ResultSet rs = stmt.executeQuery(sql); 		         
		         
		         while(rs.next())
		         {
		        	 empRet = new Employee();
		        	 System.out.println(rs.getString("ADDRESS"));
		        	empRet.setId(Integer.parseInt(  rs.getString("ID")));
		        	empRet.setFirstName(rs.getString("FIRSTNAME"));
		        	empRet.setLastName(rs.getString("LASTNAME"));		        	
		        	empRet.setDob(rs.getString("DOB"));
		        	empRet.setAddress(rs.getString("ADDRESS"));
		         }
		         
		         // STEP 4: Clean-up environment 
		         stmt.close(); 
		         conn.close();
		         
		         
		      } catch(SQLException se) { 
		         // Handle errors for JDBC 
		         se.printStackTrace(); 
		      } catch(Exception e) { 
		         // Handle errors for Class.forName 
		         e.printStackTrace(); 
		      } finally { 
		         // finally block used to close resources 
		         try {
		            if(stmt!=null) stmt.close();  
		         } catch(SQLException se2) { 
		         } // nothing we can do 
		         try { 
		            if(conn!=null) conn.close(); 
		         } catch(SQLException se) { 
		            se.printStackTrace(); 
		         } // end finally try 
		      } // end try
		      
		      return empRet;		
	}

	@Override
	public void deleteEmployeeByID(String id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateEmployeeByID(String id, Employee emp) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public Employee[] search(IEmployeeFilterCriterion empFilterCriteria, IEmployeeOrderCriterion empOrderCriteria) {
		// TODO Auto-generated method stub
		return null;
	}



}
