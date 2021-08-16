package com.emy.ApiRest.repository;

import com.emy.ApiRest.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee,Long> {

    Optional<Employee> findEmployeeByEmpId(Long empId);
    void deleteEmployeeByEmpId(Long empId);
}
