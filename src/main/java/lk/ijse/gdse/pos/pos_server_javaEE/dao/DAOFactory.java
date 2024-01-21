package lk.ijse.gdse.pos.pos_server_javaEE.dao;

import lk.ijse.gdse.pos.pos_server_javaEE.dao.custom.impl.CustomerDAOImpl;
import lk.ijse.gdse.pos.pos_server_javaEE.dao.custom.impl.ItemDAOImpl;

public class DAOFactory {
    private static DAOFactory daoFactory;

    private DAOFactory(){

    }
    public static DAOFactory getDaoFactory(){
        return (daoFactory==null)? daoFactory=new DAOFactory() : daoFactory;
    }

    public enum DAOType{
        CUSTOMER_DAO,ITEM_DAO,ORDER_DAO,
    }

    public <T extends SuperDAO> T getDao(DAOType daoType){
        switch (daoType){
            case CUSTOMER_DAO:
                return (T) new CustomerDAOImpl();
            case ITEM_DAO:
                return (T) new ItemDAOImpl();
            default:
                return null;
        }
    }
}
