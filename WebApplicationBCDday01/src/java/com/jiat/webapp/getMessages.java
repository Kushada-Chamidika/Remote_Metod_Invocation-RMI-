/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.jiat.webapp;

import com.jiat.ejb.HelloSessionBeanRemote;
import java.io.IOException;
import java.io.PrintWriter;
import javax.naming.InitialContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author 1999k
 */
@WebServlet(name = "getMessages", urlPatterns = {"/getMessages"})
public class getMessages extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        try {

                //anotation use karala remote access karanna bari weleta apita puluwan me widiyata intial contxt eka haraha call karaganna look up karaddi api remote access karanna hithan innawanm portble name eka thama use karanna one namuth apita ema nathuwa local eke witharanm use karanna one apita non [portable name eka use karanna puluwan n 
                InitialContext ic = new InitialContext();
//                 = (HelloSessionBeanRemote) ic.lookup("java:global/EJBModuleBCDday01/MessageBean");

            } catch (Exception e) {
                e.printStackTrace();
            }
        
    }

  

}
