package lk.ijse.gdse.pos.pos_server_javaEE.controller.filter;

import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;

@WebFilter(filterName = "CORSFilter",urlPatterns = "/*")
public class CORSFilter extends HttpFilter {

}
