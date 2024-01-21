package lk.ijse.gdse.pos.pos_server_javaEE.controller.servlet;

import jakarta.json.bind.Jsonb;
import jakarta.json.bind.JsonbBuilder;
import lk.ijse.gdse.pos.pos_server_javaEE.bo.BoFactory;
import lk.ijse.gdse.pos.pos_server_javaEE.bo.SuperBO;
import lk.ijse.gdse.pos.pos_server_javaEE.bo.custom.CustomerBO;
import lk.ijse.gdse.pos.pos_server_javaEE.bo.custom.impl.CustomerBOImpl;
import lk.ijse.gdse.pos.pos_server_javaEE.dto.CustomerDTO;
import lombok.SneakyThrows;
import org.apache.commons.dbcp2.BasicDataSource;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

@WebServlet(name = "customerServlet",urlPatterns = "/customers")
public class CustomerServlet extends HttpServlet {
    CustomerBO customerBO= BoFactory.getBoFactory().getBO(BoFactory.BOType.CUSTOMER_BO);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletContext servletContext = getServletContext();
        BasicDataSource dbcp = (BasicDataSource) servletContext.getAttribute("dbcp");
        Connection connection=null;

        ArrayList<CustomerDTO> customerArray= new ArrayList<>();
        try {
            connection = dbcp.getConnection();
            customerArray = customerBO.getAll(connection);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        Jsonb jsonb = JsonbBuilder.create();
        jsonb.toJson(customerArray,resp.getWriter());

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletContext servletContext = getServletContext();
        BasicDataSource dbcp = (BasicDataSource) servletContext.getAttribute("dbcp");
        Connection connection=null;

        Jsonb jsonb = JsonbBuilder.create();
        CustomerDTO customerDTO = jsonb.fromJson(req.getReader(), CustomerDTO.class);

        if (customerDTO.getId()==null||customerDTO.getId().matches("/^(C00-)[0-9]{3}$/") ){
            resp.sendError(HttpServletResponse.SC_BAD_REQUEST,"ID is empty or invalid");
        }else if (customerDTO.getName()==null||customerDTO.getName().matches("/^[A-Za-z ]{2,}$/") ){
            resp.sendError(HttpServletResponse.SC_BAD_REQUEST,"Name is empty or invalid");
        }else if (customerDTO.getAddress()==null||customerDTO.getAddress().matches("/^[A-Za-z0-9 ]{5,}$/") ) {
            resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "Address is empty or invalid");
        }else {
            try {
                connection = dbcp.getConnection();
                boolean isSaved = customerBO.saveCustomer(customerDTO, connection);
                if (isSaved){
                    resp.setStatus(HttpServletResponse.SC_CREATED);
                }
                else {
                    resp.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR,"Failed to save the customer");
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletContext servletContext = getServletContext();
        BasicDataSource dbcp = (BasicDataSource) servletContext.getAttribute("dbcp");
        Connection connection=null;

        Jsonb jsonb = JsonbBuilder.create();
        CustomerDTO customerDTO = jsonb.fromJson(req.getReader(), CustomerDTO.class);

        if (customerDTO.getId()==null||customerDTO.getId().matches("/^(C00-)[0-9]{3}$/") ){
            resp.sendError(HttpServletResponse.SC_BAD_REQUEST,"ID is empty or invalid");
        }else if (customerDTO.getName()==null||customerDTO.getName().matches("/^[A-Za-z ]{2,}$/") ){
            resp.sendError(HttpServletResponse.SC_BAD_REQUEST,"Name is empty or invalid");
        }else if (customerDTO.getAddress()==null||customerDTO.getAddress().matches("/^[A-Za-z0-9 ]{5,}$/") ){
            resp.sendError(HttpServletResponse.SC_BAD_REQUEST,"Address is empty or invalid");
        }else {
            try {
                connection = dbcp.getConnection();
                boolean isUpdated = customerBO.updateCustomer(customerDTO, connection);

                if (isUpdated){
                    resp.setStatus(HttpServletResponse.SC_CREATED);
                }
                else {
                    resp.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR,"Failed to update the customer");
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }

    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id=req.getParameter("id");
        ServletContext servletContext = getServletContext();
        BasicDataSource dbcp = (BasicDataSource) servletContext.getAttribute("dbcp");
        Connection connection=null;

        if (id==null||id.matches("/^(C00-)[0-9]{3}$/") ){
            resp.sendError(HttpServletResponse.SC_BAD_REQUEST,"ID is empty or invalid");
        }else {
            try {
                connection = dbcp.getConnection();
                boolean isDelete = customerBO.deleteCustomer(id, connection);

                if (isDelete){
                    resp.setStatus(HttpServletResponse.SC_CREATED);
                }
                else {
                    resp.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR,"Failed to delete the customer");
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }
}
