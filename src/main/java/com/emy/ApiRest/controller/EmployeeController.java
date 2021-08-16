package com.emy.ApiRest.controller;

import com.emy.ApiRest.model.Employee;
import com.emy.ApiRest.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping(value = "/api/employee")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @GetMapping(value = "/all")
    public ResponseEntity<Employee> findAllEmployees(){
        List<Employee> employees = employeeService.findAllEmployee();
        return new ResponseEntity(employees, HttpStatus.OK);
    }

    @GetMapping(value = "/find/{empId}")
    public ResponseEntity<Employee> findEmployee(@PathVariable("empId") Long empId) throws Throwable{
        Employee employee = employeeService.findEmployeeByEmpId(empId);
        return new ResponseEntity(employee , HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee){
        Employee newEmp = employeeService.addEmployee(employee);
        return new ResponseEntity(newEmp , HttpStatus.CREATED);
    }
    @PutMapping("/update")
    public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee){
        Employee updateEmployee = employeeService.updateEmployee(employee);
        return new ResponseEntity(updateEmployee , HttpStatus.OK);
    }
    @DeleteMapping("/delete/{empId}")
    public ResponseEntity<Employee> deleteEmployee(@PathVariable("empId") Long empId){
        employeeService.deleteEmployeeByEmpId(empId);
        return new ResponseEntity(HttpStatus.OK);
    }
    @DeleteMapping("/delete/all")
    public ResponseEntity<Employee> deleteAllEmployee(){
        employeeService.deleteAllEmployees();
        return new ResponseEntity(HttpStatus.OK);
    }
}
