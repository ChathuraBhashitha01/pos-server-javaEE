package lk.ijse.gdse.pos.pos_server_javaEE.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Placeorder {
    private String orderID;
    private String date;
    private String customerID;
    private double total;
}
