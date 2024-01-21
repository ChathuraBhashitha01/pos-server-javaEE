package lk.ijse.gdse.pos.pos_server_javaEE.dao.custom.impl;

import lk.ijse.gdse.pos.pos_server_javaEE.bo.SuperBO;
import lk.ijse.gdse.pos.pos_server_javaEE.bo.custom.CustomerBO;
import lk.ijse.gdse.pos.pos_server_javaEE.bo.custom.impl.CustomerBOImpl;
import lk.ijse.gdse.pos.pos_server_javaEE.dao.custom.CustomerDAO;
import lk.ijse.gdse.pos.pos_server_javaEE.entity.Customer;

import javax.servlet.ServletContext;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

public class CustomerDAOImpl implements CustomerDAO {

    @Override
    public ArrayList<Customer> getAll() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public boolean save(Customer entity, Connection connection) throws SQLException, ClassNotFoundException {
        String id = entity.getId();
        String name = entity.getName();
        String address = entity.getAddress();
        double salary = entity.getSalary();
        PreparedStatement stm = connection.prepareStatement("INSERT INTO customer(id, name, address,salary) VALUES (?,?,?,?)");

        stm.setString(1,id);
        stm.setString(2, name);
        stm.setString(3, address);
        stm.setDouble(4,salary);

        stm.executeUpdate();
        System.out.println("Connection"+connection);
        System.out.println(id);
        return true;

    }

    @Override
    public boolean update(Customer entity, Connection connection) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean delete(String s, Connection connection) throws SQLException, ClassNotFoundException {
        return false;
    }
}
