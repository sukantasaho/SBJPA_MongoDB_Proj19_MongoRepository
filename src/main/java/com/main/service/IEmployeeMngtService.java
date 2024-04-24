package com.main.service;

import java.util.List;

import com.main.document.Employee;

public interface IEmployeeMngtService 
{
    public String saveEmployee(Employee emp);
    public String saveAll(List<Employee> empList);
    public List<Employee> getAllRecords();
    public Employee findEmployeeById(String id);
    public String modifyEmpSalaryById(String id, Float newSalary);
    public String deleteById(String id);
    public List<Employee> getAllEmpSortingOrder(boolean ascOrder, String... properties);
}
