package com.revature.daos;

import com.revature.models.Role;
import com.revature.utils.ConnectionUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

//THIS CLASS IS RESPONSIBLE FOR ALL THINGS ROLE DATA.(roledao == role data access object)
//this class will access /query the roles table in the db
public class RoleDAO implements RoleDAOinterface{


    @Override
    public Role getRoleById(int id) {

        //USE TRY WITH RESOURCE BLOCK TOOPEN THE CONNECTION TO OUR DATABASE

        try(Connection conn = ConnectionUtil.getConnection()){
            /*
            we need a string that holds the sql commands we want to run on the DB
            this string has a wild card/parameter/variable for the role_id(?).
            we have to take the user inputted role_id and put it into this wildcard

             */

            String sql = "SELECT * FROM roles WHERE role_id = ? ";


            //we need prepared stetements object to fill the ? (wildcard)
            //Preparedstatements prepare sql command before we send to DB

            PreparedStatement ps = conn.prepareStatement(sql);

            //we are inserting value for the wildcard
            //the first wild cars will get filled by the id varaible

            ps.setInt(1, id);

            /*Here, we are execute the fully prepared SQL command that has been stored in the PreparedStatement.
                The results of the Query will be stored in a ResultSet object.*/

            ResultSet rs = ps.executeQuery();

            //checks if there is any data in the resultset

            if(rs.next()){
                //extract the role data from the resultset. we need to us all-args constructore to store all data
                //to get data out of result set we use rs.get() method
                Role role = new Role(
                        rs.getInt("role_id"),
                        rs.getString("role_title"),
                        rs.getInt("role_salary")
                );
                //this is just a constructor we opened it up for the sake of cleaner code.

                return role;//return the role object to the user!

            }


        } catch (SQLException e){
            System.out.println("error getting role");
            e.printStackTrace();//tell us our error message
            //very important debugging .so we know what went wrong and were.

        }
        return null; //get returned if stg wrong


    }

    @Override
    public boolean updateRoleSalary(int salary, String title) {
        try(Connection conn = ConnectionUtil.getConnection()){

            String sql = "UPDATE roles SET role_salary = ? WHERE role_title = ?";

            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, salary);
            ps.setString(2, title);


            //execute the update we are not getting any data returned so no need for resultset object
            //note: executeupdate() instead of executequery() .query is for select only

            ps.executeUpdate();
            return true;



        }catch (SQLException e){
            System.out.println("update failed");
            e.printStackTrace();
        }
        return false;
    }
}
