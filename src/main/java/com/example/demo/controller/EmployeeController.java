package com.example.demo.controller;

import com.example.demo.exception.UserNotFoundException;
import com.example.demo.model.Employee;
import com.example.demo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.util.List;

@RestController
@RequestMapping("/employee")
@CrossOrigin
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    // http://localhost:8081/employee/add
    @PostMapping("/add")
    public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee){
        Employee employees = this.employeeService.addEmployee(employee);
        return new ResponseEntity<>(employees, HttpStatus.CREATED);
    }

    // http://localhost:8081/employee/getAll
    // to get all the employees
    @GetMapping("/getAll")
    public ResponseEntity<List<Employee>> getAllEmployee(){
        List<Employee> employeeList = this.employeeService.getAllEmployee();
        return new ResponseEntity<>(employeeList, HttpStatus.OK);
    }

    // get employee by id
    @GetMapping("/get/{id}")
    public ResponseEntity<Employee> getEmployee(@PathVariable long id){
            Employee employee = this.employeeService.getEmployee(id);
            return new ResponseEntity<>(employee, HttpStatus.OK);
    }

    // update employee by id
    @PutMapping("/update/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable long id, @RequestBody Employee employee){
        Employee updateEmployee = this.employeeService.updateEmployee(id, employee);
        return new ResponseEntity<>(updateEmployee, HttpStatus.ACCEPTED);
    }

    // delete employee by id
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable long id){
        employeeService.deleteEmployee(id);
        return new ResponseEntity<>("Deleted successfully", HttpStatus.OK);
    }

}
