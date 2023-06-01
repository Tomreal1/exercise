package com.revature.daos;

import com.revature.models.Role;

//this will lay out the method that theroledao implments
//this is great way to document with functionalities exist in the roledao
public interface RoleDAOinterface {

    //a method that select a role by its ID
    Role getRoleById(int id);



    //METHOD that update a role salary

    boolean updateRoleSalary(int salary, String title);


}
