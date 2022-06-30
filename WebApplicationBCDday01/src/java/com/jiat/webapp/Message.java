/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.jiat.webapp;

import com.jiat.ejb.HelloSessionBeanRemote;
import java.io.IOException;
import java.io.PrintWriter;
import javax.ejb.EJB;
import javax.naming.InitialContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author 1999k
 */
@WebServlet(name = "Message", urlPatterns = {"/Message"})
public class Message extends HttpServlet {
    

//    @EJB
//    private HelloSessionBeanRemote helloSessionBean;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String name = req.getParameter("name");

        HelloSessionBeanRemote hsbr = null;

        HttpSession ses = req.getSession();

        if (ses.getAttribute("myEJB") != null) {
            hsbr = (HelloSessionBeanRemote) ses.getAttribute("myEJB");
        } else {
            try {

                //anotation use karala remote access karanna bari weleta apita puluwan me widiyata intial contxt eka haraha call karaganna look up karaddi api remote access karanna hithan innawanm portble name eka thama use karanna one namuth apita ema nathuwa local eke witharanm use karanna one apita non [portable name eka use karanna puluwan n 
                InitialContext ic = new InitialContext();
                hsbr = (HelloSessionBeanRemote) ic.lookup("java:global/EJBModuleBCDday01/HelloSessionBean");

            } catch (Exception e) {
                e.printStackTrace();
            }

            ses.setAttribute("myEJB", hsbr);

        }

        PrintWriter out = resp.getWriter();
        out.write(hsbr.hello(name));

    }

}
