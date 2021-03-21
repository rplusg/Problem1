package com.paypal.bfs.test.employeeserv.impl;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.paypal.bfs.test.Service.IEmployeeService;
import com.paypal.bfs.test.Service.impl.EmployeeService;
import com.paypal.bfs.test.employeeserv.api.EmployeeResource;
import com.paypal.bfs.test.employeeserv.api.model.Employee;
import com.paypal.bfs.test.employeeserv.api.model.Address;

import java.io.IOException;
import java.util.Date;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

/**
 * Implementation class for employee resource.
 */
@RestController
public class EmployeeResourceImpl implements EmployeeResource {

	IEmployeeService empService = new EmployeeService();
    @Override
    public ResponseEntity<Employee> employeeGetById(String id) {
    	Employee emp = empService.getUserById(id);
    	HttpStatus retStatusCode = HttpStatus.OK;
    	if(emp == null)
    		retStatusCode = HttpStatus.NOT_FOUND;
    	return new ResponseEntity<>(h2Helper.readFromDB(id), retStatusCode);
    }

	@Override
	public ResponseEntity<Employee> employeeCreate(Employee empIncoming) {
        Employee employee = new Employee();
        employee.setId(Integer.valueOf(empIncoming.getId()));
        employee.setFirstName(empIncoming.getFirstName());
        employee.setLastName(empIncoming.getLastName());
        employee.setDob(empIncoming.getDob());
        
       
        System.out.println(empIncoming.getAddress());
       
        Address addr = new Address();
        java.util.LinkedHashMap map = new java.util.LinkedHashMap();
		try {			
			map = java.util.LinkedHashMap.class.cast(empIncoming.getAddress());
		}  catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        addr.setLine1(map.get("line1").toString());
        addr.setLine2(map.get("line2").toString());
        addr.setCity(map.get("city").toString());
        addr.setZipCode(map.get("zipCode").toString());
        addr.setState(map.get("state").toString());        
        addr.setCountry(map.get("country").toString());
        
        employee.setAddress(addr);       
        //h2Helper.writeToDB(employee);
        boolean bRet = empService.createNewUser(employee);
        HttpStatus retStatusCode = HttpStatus.OK;
        if(!bRet) {
        	retStatusCode = HttpStatus.BAD_REQUEST;
        	return new ResponseEntity<>(null, retStatusCode);
        } else {
        	return new ResponseEntity<>(employee, retStatusCode);	
        }
        
        
	}

	@Override
	public ResponseEntity<Employee> employeeUpdateById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean employeeDeleteById(String id) {
		// TODO Auto-generated method stub
		return false;
	}
}
