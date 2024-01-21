package lk.ijse.gdse.pos.pos_server_javaEE.bo.custom.impl;

import lk.ijse.gdse.pos.pos_server_javaEE.bo.custom.ItemBO;
import lk.ijse.gdse.pos.pos_server_javaEE.dto.CustomerDTO;

import java.util.ArrayList;

public class ItemBOImpl implements ItemBO {
    @Override
    public ArrayList<CustomerDTO> getAllCustomers() {
        return null;
    }

    @Override
    public boolean saveCustomer(CustomerDTO dto) {
        return false;
    }

    @Override
    public boolean updateCustomer(CustomerDTO dto) {
        return false;
    }

    @Override
    public boolean deleteCustomer(String id) {
        return false;
    }
}
