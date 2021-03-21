package com.paypal.bfs.test.Service.impl;

import com.paypal.bfs.test.DAO.IEmployeeDAO;
import com.paypal.bfs.test.DAO.impl.EmployeeH2DAO;
import com.paypal.bfs.test.Search.IEmployeeFilterCriterion;
import com.paypal.bfs.test.Search.IEmployeeOrderCriterion;
import com.paypal.bfs.test.Service.IEmployeeService;
import com.paypal.bfs.test.employeeserv.api.model.Employee;

public class EmployeeService implements IEmployeeService {

	IEmployeeDAO empDAOObj = new EmployeeH2DAO();
	@Override
	public boolean createNewUser(Employee emp) {
		return empDAOObj.createEmployee(emp);		
	}

	@Override
	public Employee getUserById(String id) {

		return empDAOObj.getEmployeeByID(id);
	}

	@Override
	public void deleteUserById(String id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateUserById(String id, Employee emp) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Employee[] search(IEmployeeFilterCriterion empFilterCriteria, IEmployeeOrderCriterion empOrderCriteria) {
		// TODO Auto-generated method stub
		return empDAOObj.search(empFilterCriteria, empOrderCriteria);
	}

}
