package com.main.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.main.document.Employee;
import com.main.repository.IEmployeeRepo;

@Service("empService")
public class IEmployeeMgntService implements IEmployeeMngtService {

	@Autowired
	private IEmployeeRepo repo;
	
	@Override
	public String saveEmployee(Employee emp) {
		 
		String idVal = repo.save(emp).getId();
		
		return "Employee is save with id-"+idVal;
	}

	@Override
	public String saveAll(List<Employee> empList) {
		  List<Employee> listEmp = repo.saveAll(empList);
		  List<String> idList = listEmp.stream().map(e->e.getId()).collect(Collectors.toList());
		  
		return "Bulk of employee records inserted with ids-"+idList;
	}

	@Override
	public List<Employee> getAllRecords() {
		 
		return repo.findAll();
	}

	@Override
	public Employee findEmployeeById(String id) {
		 
	    Optional<Employee>	opt = repo.findById(id);
	    Employee emp = null;
	    if(opt.isPresent())
	    {
	    	emp = opt.get();
	    }
		return emp;
	}

	@Override
	public String modifyEmpSalaryById(String id, Float newSalary) {
		Optional<Employee>	opt = repo.findById(id);
	    String msg = null;
	    if(opt.isPresent())
	    {
	    	Employee emp  = opt.get();
	    	emp.setSalary(newSalary);
	    	//update
	    	repo.save(emp);
	    	msg = "record is updated with id-"+emp.getId()+" and new Salary is-"+newSalary;
	    }
		return msg;
	}

	@Override
	public String deleteById(String id) {
		 
		  Optional<Employee> opt = repo.findById(id);
		  String msg = null;
		  if(opt.isPresent())
		  {
			  repo.deleteById(opt.get().getId());
			  msg = "Record is deleted with id-"+opt.get().getId();
		  }
		  else
		  {
		     msg = "Record is not found with this id-"+id;
		  }
		 
		return  msg;
	}

	@Override
	public List<Employee> getAllEmpSortingOrder(boolean ascOrder, String... properties) {
		 Sort sort =  Sort.by(ascOrder?Direction.ASC:Direction.DESC, properties);
		return repo.findAll(sort);
	}

}
