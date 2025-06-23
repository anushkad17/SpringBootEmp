package com.anushka.empSB;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;
//@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class EmpController {
    @Autowired
    EmpService employeeService;
    //EmpService EmpService = new EmpServiceImpl();
    @GetMapping("/emp")
    public  List<Employee> getAllEmp(){
        return employeeService.readEmployees();

    }
    @PostMapping("/employees")
    public String  createEmp(@RequestBody Employee employee){
        //employees.add(employee);
       return employeeService.createEmployee(employee);


    }
    @DeleteMapping("employees/{id}")
    public String  deleteEmp(@PathVariable int id){
        if(employeeService.deleteEmployee(id)){
            return "Delete Succesfully";
        }else
            return "Delete Failed";
    }
    @PutMapping("employees/{id}")
    public String updateEmp(@PathVariable int id,@RequestBody Employee employee){
        return employeeService.updateEmployee(id,employee);
    }



}
