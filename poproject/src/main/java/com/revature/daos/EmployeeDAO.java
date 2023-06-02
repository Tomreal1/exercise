package com.revature.daos;

import com.revature.models.Employee;
import com.revature.utils.ConnectionUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.concurrent.ConcurrentNavigableMap;

public class EmployeeDAO implements EmployeeDAOinterface {
    @Override
    public ArrayList<Employee> getAllEmployees() {

        try(Connection conn = ConnectionUtil.getConnection()) {

            String sql = "SELECT * FROM EMPLOYEES";
         /* No variables are needed in the SQL query above. No need for a PreparedStatement!
            Instead, we'll use a regular Statement object
            BIG PICTURE: If we have no variables, Statement is fine, otherwise we need PreparedStatement */

            Statement s = conn.createStatement();

            //excute the query and save the result in result set

            ResultSet rs = s.executeQuery(sql);

            //instatntiate empty arraylist
            ArrayList<Employee> employeesList = new ArrayList<>();

            //instantiate roleDAO so we can get role object foor our employee object
            RoleDAO rDAO = new RoleDAO();

            /* use rs.next() in a while loop to create a new Employee for every incoming Employee from the DB
                rs.next() ITERATES through the list of data. It will return false when there's no more data
             In other words, rs.next() returns true as long as there is new data to look at */

            while(rs.next()){

                Employee employee = new Employee(
                        rs.getInt("employeee_id"),
                        rs.getString("first_name"),
                        rs.getString("last_name"),
                        rDAO.getRoleById(rs.getInt("role_id_fk"))
                );
                employeesList.add(employee);
                //after array list break our array list will be full

            }
            return employeesList;

        }catch(SQLException e) {
            System.out.println("get all employee failed");
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Employee insertemployee(Employee emp) {

        //every dao method start b y openening db connection
        try(Connection conn = ConnectionUtil.getConnection()){

            String sql = "INSERT INTO EMPLOYEES (first_name, last_name, role_id_fk) VALUES (?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, emp.getFirst_name());
            ps.setString(2, emp.getLast_name());
            ps.setInt(3, emp.getRole_id_fk());

            ps.executeUpdate();

            return emp;



        }catch(SQLException e){
            System.out.println("insert employee failed");
            e.printStackTrace(); //tell the suer what exactly went wrong
        }
        return null;
    }

    @Override
    public Employee deleteemployee(Employee emp) {


        return null;
    }
}
