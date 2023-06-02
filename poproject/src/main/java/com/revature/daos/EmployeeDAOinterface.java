package com.revature.daos;

import com.revature.models.Employee;

import java.util.ArrayList;

public interface EmployeeDAOinterface {

    //a method to select all employee

    ArrayList<Employee> getAllEmployees();
    /*Why an ArrayList? Get all will return multiple employees
       So we need some kind of COLLECTION that can store multiple Employee objects*/

    //a method to insert a new employee

    Employee insertemployee(Employee emp);

    //a method to delete an employee

    Employee deleteemployee(Employee emp);




}
