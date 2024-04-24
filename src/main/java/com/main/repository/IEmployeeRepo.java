package com.main.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.CrudRepository;

import com.main.document.Employee;

public interface IEmployeeRepo  extends MongoRepository<Employee, String>, CrudRepository<Employee, String>
{

}
