package com.paypal.bfs.test.DAO;

import com.paypal.bfs.test.Search.IEmployeeFilterCriterion;
import com.paypal.bfs.test.Search.IEmployeeOrderCriterion;
import com.paypal.bfs.test.employeeserv.api.model.Employee;

public interface IEmployeeDAO {
	public boolean createEmployee(Employee emp);
	public Employee getEmployeeByID(String id);
	public void deleteEmployeeByID(String id);
	public void updateEmployeeByID(String id, Employee emp);
	public Employee[] search(IEmployeeFilterCriterion empFilterCriteria, IEmployeeOrderCriterion empOrderCriteria);
}
