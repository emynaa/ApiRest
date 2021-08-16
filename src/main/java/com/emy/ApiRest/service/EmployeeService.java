package com.emy.ApiRest.service;

import com.emy.ApiRest.exception.UserNotFoundException;
import com.emy.ApiRest.model.Employee;
import com.emy.ApiRest.repository.EmployeeRepo;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Getter
public class EmployeeService {

 private  EmployeeRepo employeeRepo;
    @Autowired
    public EmployeeService(EmployeeRepo employeeRepo) {
        this.employeeRepo = employeeRepo;
    }


    //list of  employees
    public List<Employee> findAllEmployee(){
        return employeeRepo.findAll();
    }
    // find employee by ID
    public Employee findEmployeeByEmpId(Long empId) throws Throwable{
        return employeeRepo.findEmployeeByEmpId(empId).orElseThrow(( ) -> new UserNotFoundException("Employee not found for this id :: " + empId ));
    }
    //create emp
    public Employee addEmployee(Employee employee){
        return employeeRepo.save(employee);
    }
    //update
    public Employee updateEmployee(Employee employee){
        return employeeRepo.save((employee));
    }
    //delete
    public void deleteEmployeeByEmpId(Long empId){
        employeeRepo.deleteEmployeeByEmpId(empId);
    }
    public void deleteAllEmployees(){
        employeeRepo.deleteAll();
    }
}
