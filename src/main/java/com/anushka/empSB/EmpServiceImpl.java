package com.anushka.empSB;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public abstract class EmpServiceImpl implements EmpService {
    @Autowired
    private EmpRepo empRepo;
    List<Employee> employees=new ArrayList<>();

    @Override
    public String createEmployee(Employee employee) {
        EmpEntity empEntity=new EmpEntity();
        BeanUtils.copyProperties(employee,empEntity);
        empRepo.save(empEntity);//save employee to database
        //employees.add(employee);
        return "Saved sucessfully";
    }

    @Override
    public List<Employee> readEmployees() {
        List<EmpEntity> emplist=empRepo.findAll();//get all employees from database
        List<Employee> employees=new ArrayList<>();
        for (EmpEntity empEntity:emplist){
            Employee emp =new Employee();
            emp.setName(empEntity.getName());
            emp.setPhoneno(empEntity.getPhoneno());
            emp.setEmail(empEntity.getEmail());//ek ek list chahiye thi nhi to beansutil bi use kr skte hai
            employees.add(emp);

        }
        return employees;
    }

    @Override
    public boolean deleteEmployee(int id) {
        EmpEntity emp=empRepo.findById(id).get();
        empRepo.delete(emp);
        //employees.remove(id);
        return true;
    }

    @Override
    public String updateEmployee(int id, Employee employee) {
        EmpEntity existingEntity=empRepo.findById(id).get();
        existingEntity.setName(employee.getName());
        existingEntity.setPhoneno(employee.getPhoneno());
        existingEntity.setEmail(employee.getEmail());
        empRepo.save(existingEntity);
        return "Update Succesfully";
    }
}
