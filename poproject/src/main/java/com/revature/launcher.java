package com.revature;
import com.revature.daos.RoleDAO;
import com.revature.utils.ConnectionUtil;

import java.sql.Connection;
import java.sql.SQLException;

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

    }
}
