package com.revature;
import com.revature.daos.EmployeeDAO;
import com.revature.daos.RoleDAO;
import com.revature.models.Employee;
import com.revature.utils.ConnectionUtil;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

public class launcher {
    public static void main(String[] args) {
        /*This is a try-with-resources block
            A resource (in this case, a DB connection) is opened within the parenthesis
            Another benefit is that the resource will close for us when the block completes
            This is helpful for code cleanup and preventing memory leaks*/
        try(Connection conn = ConnectionUtil.getConnection()){
            System.out.println("connection successful");
        }
        catch(SQLException e){
            System.out.println("connection failed");
        }
        //calling DAO method below---
        //instantiate a RoleDAO object we can use its method

        RoleDAO rDAO = new RoleDAO();

        //getting role object by id
        System.out.println(rDAO.getRoleById(2));
        System.out.println(rDAO.updateRoleSalary(50000, "Manager"));

        System.out.println(rDAO.getRoleById(1));

        //instantiat objectso we can use our method

        EmployeeDAO eDAO =  new EmployeeDAO();

        //insert new employe

        Employee marrio = new Employee("Marrio", "Hinkle", 3);

        System.out.println(eDAO.insertemployee(marrio));

        //get all employee
        System.out.println(eDAO.getAllEmployees());
        //DIFFERENT WAY
        ArrayList<Employee> employeesList = eDAO.getAllEmployees();

        //enhanced for llop to print out each employee
        for(Employee e : employeesList){
            System.out.println(e);
        }



    }
}
