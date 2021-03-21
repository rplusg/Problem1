package com.paypal.bfs.test.Service;

import com.paypal.bfs.test.Search.IEmployeeFilterCriterion;
import com.paypal.bfs.test.Search.IEmployeeOrderCriterion;
import com.paypal.bfs.test.employeeserv.api.model.Employee;

public interface IEmployeeService {
	public boolean createNewUser(Employee emp);
	public Employee getUserById(String id);
	public void deleteUserById(String id);
	public void updateUserById(String id, Employee emp);
	public Employee[] search(IEmployeeFilterCriterion empFilterCriteria, IEmployeeOrderCriterion empOrderCriteria);
}
