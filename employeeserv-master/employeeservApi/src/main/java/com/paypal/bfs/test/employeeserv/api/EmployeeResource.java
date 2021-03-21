package com.paypal.bfs.test.employeeserv.api;

import com.paypal.bfs.test.employeeserv.api.model.Employee;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Interface for employee resource operations.
 */
public interface EmployeeResource {

    /**
     * Retrieves the {@link Employee} resource by id.
     *
     * @param id employee id.
     * @return {@link Employee} resource.
     */
    @RequestMapping("/v1/bfs/employees/{id}")
    ResponseEntity<Employee> employeeGetById(@PathVariable("id") String id);

    // ----------------------------------------------------------
    // TODO - add a new operation for creating employee resource.
    // ----------------------------------------------------------
    
    @RequestMapping(value = "/v1/bfs/employees", method = RequestMethod.POST)
    @ResponseBody
    ResponseEntity<Employee> employeeCreate(@RequestBody Employee empIncoming);
    
    @RequestMapping(value = "/v1/bfs/employees/{id}", method = RequestMethod.PUT)
    @ResponseBody
    ResponseEntity<Employee> employeeUpdateById(@PathVariable("id") String id);
    
    @RequestMapping(value = "/v1/bfs/employees/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    boolean employeeDeleteById(@PathVariable("id") String id);
}
