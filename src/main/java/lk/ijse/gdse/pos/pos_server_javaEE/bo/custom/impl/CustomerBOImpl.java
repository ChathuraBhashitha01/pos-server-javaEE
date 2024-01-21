package lk.ijse.gdse.pos.pos_server_javaEE.bo.custom.impl;

import lk.ijse.gdse.pos.pos_server_javaEE.bo.custom.CustomerBO;
import lk.ijse.gdse.pos.pos_server_javaEE.dao.CrudDAO;
import lk.ijse.gdse.pos.pos_server_javaEE.dao.custom.impl.CustomerDAOImpl;
import lk.ijse.gdse.pos.pos_server_javaEE.dto.CustomerDTO;
import lk.ijse.gdse.pos.pos_server_javaEE.entity.Customer;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

public class CustomerBOImpl implements CustomerBO {
    CrudDAO customerDAO=new CustomerDAOImpl();

    @Override
    public ArrayList<CustomerDTO> getAllCustomers(Connection connection) {
        return null;
    }

    @Override
    public boolean saveCustomer(CustomerDTO dto, Connection connection) throws SQLException, ClassNotFoundException {
        boolean isSaved = customerDAO.save(new Customer(dto.getId(),dto.getName(),dto.getAddress(),dto.getSalary()),connection);
        return isSaved;
    }

    @Override
    public boolean updateCustomer(CustomerDTO dto, Connection connection) {
        return false;
    }

    @Override
    public boolean deleteCustomer(String id, Connection connection) {
        return false;
    }
}
