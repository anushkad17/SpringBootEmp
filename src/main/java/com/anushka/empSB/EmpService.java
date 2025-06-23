package com.anushka.empSB;

import java.util.List;

public interface EmpService {
    String createEmployee(Employee employee);
    List<Employee> readEmployees();
    boolean deleteEmployee(int id);
    String updateEmployee(int id, Employee employee);
}

