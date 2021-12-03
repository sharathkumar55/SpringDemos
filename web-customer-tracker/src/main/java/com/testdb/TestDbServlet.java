package com.testdb;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
@WebServlet("/TestDbServlet")
public class TestDbServlet extends HttpServlet {


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //setup connection variables
        String user = "springstudent";
        String password = "springstudent";

        String jdbcUrl = "jdbc:mysql://localhost:3306/web_customer_tracker?useSSL=false";
        String driver = "com.mysql.jdbc.Driver";
        //get the connection
        try{
            PrintWriter out = response.getWriter();
            out.println("connecting to "+jdbcUrl);
            Class.forName(driver);
            Connection mycon = DriverManager.getConnection(jdbcUrl,user,password);
            out.println("Connection succesful");
            mycon.close();

    }
        catch (Exception ex)
        {
            ex.printStackTrace();
            throw new ServletException(ex);
        }
}
}
