package com.revature.daos;

import com.revature.models.Employee;
import com.revature.utils.ConnectionUtil;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.concurrent.ConcurrentNavigableMap;

public class EmployeeDAO implements EmployeeDAOinterface {
    @Override
    public ArrayList<Employee> getAllEmployees() {
        return null;
    }

    @Override
    public Employee insertemployee(Employee emp) {

        //every dao method start b y openening db connection
        try(Connection conn = ConnectionUtil.getConnection()){

            String sql = "INSERT INTO EMPLOYEES (first_name, last_name, rolr_id_fk) VALUES (?, ?, ?";


        }catch(SQLException e){
            System.out.println("insert employee failed");
            e.printStackTrace(); //tell the suer what exactly went wrong
        }


        return null;
    }
}
