package com.main.runner;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.main.document.Employee;
import com.main.service.IEmployeeMngtService;

@Component
public class TestRunner implements CommandLineRunner {

	@Autowired
	private IEmployeeMngtService service;
	
	@Override
	public void run(String... args) throws Exception {
		 
          try
          {
        	  //save single record
				/* Employee emp = new Employee("Binita","Bhadrak",1000f,true,LocalDateTime.now());
				 String msg = service.saveEmployee(emp);
				 System.out.println(msg);*/
				/* Employee emp = new Employee();
				 emp.setEname("Test1");
				 emp.setEaddr("Balesore");
				 String msg = service.saveEmployee(emp);
				 System.out.println(msg);*/
        	  
        	  //custom id generation
				/* Employee emp = new Employee();
				    emp.setId(UUID.randomUUID().toString());
				 emp.setEname("Test2");
				 emp.setEaddr("Bangalore");
				 emp.setSalary(18000f);
				 emp.setDob(LocalDateTime.now());
				 emp.setSingle(true);
				 String msg = service.saveEmployee(emp);
				 System.out.println(msg);*/
        	  //save bulk records
				/*Employee emp1 = new Employee("Binita","Bhadrak",1000f,true,LocalDateTime.now());
				Employee emp2 = new Employee("Niranjan","Bhadrak",2000f,false,LocalDateTime.now());
				Employee emp3 = new Employee("Abhi","Bhadrak",3000f,true,LocalDateTime.now());
				Employee emp4 = new Employee("Sanjib","Bhadrak",4000f,false,LocalDateTime.now());
				List<Employee> eList = List.of(emp1, emp2, emp3, emp4);
				System.out.println(service.saveAll(eList));*/
        	  
        	  //get All reocrds
				/*service.getAllRecords().forEach(e->System.out.println(e.getId()+"  "+e.getEname()+" "+e.getEaddr()));;*/
        	  
				/* Employee e = service.findEmployeeById("65cf1fb49bd53a432fda4ce5");
				 System.out.println(e.getEname()+" "+e.getEaddr()+" "+e.getSalary());*/
        	  
        	  //update record
				/*String msg = service.modifyEmpSalaryById("65cf152292fba7146c25c194", 13000.0f);
				System.out.println(msg);*/
				 
        	  //delete record by id
				 String msg = service.deleteById("65cf1216ef53cf1450ac93b5");
				 System.out.println(msg);
				 
        	  //get All records based on sorting
				/*List<Employee> eList = service.getAllEmpSortingOrder(true, "salary");
				System.out.println(eList);*/
        	   
          }
          catch (Exception e) {
			 e.printStackTrace();
		}
	}

}
