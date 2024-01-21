package lk.ijse.gdse.pos.pos_server_javaEE.bo.custom;

import lk.ijse.gdse.pos.pos_server_javaEE.bo.SuperBO;
import lk.ijse.gdse.pos.pos_server_javaEE.dto.CustomerDTO;

import java.util.ArrayList;

public interface ItemBO extends SuperBO {
    ArrayList<CustomerDTO> getAllCustomers();

    boolean saveCustomer(CustomerDTO dto);

    boolean updateCustomer(CustomerDTO dto);

    boolean deleteCustomer(String id);

}
