package lk.ijse.gdse.pos.pos_server_javaEE.bo.custom;

import lk.ijse.gdse.pos.pos_server_javaEE.bo.SuperBO;
import lk.ijse.gdse.pos.pos_server_javaEE.dto.CustomerDTO;

import javax.servlet.ServletException;
import java.io.IOException;
import java.util.ArrayList;

public interface ItemBO extends SuperBO {
    ArrayList<CustomerDTO> getAllCustomers()throws ServletException, IOException;

    boolean saveCustomer(CustomerDTO dto)throws ServletException, IOException;

    boolean updateCustomer(CustomerDTO dto)throws ServletException, IOException;

    boolean deleteCustomer(String id)throws ServletException, IOException;

}
