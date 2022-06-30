/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.jiat.webapp;

import com.jiat.ejb.IntrestSessionBeanRemote;
import java.io.IOException;
import java.io.PrintWriter;
import javax.ejb.EJB;
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
@WebServlet(name = "Interest", urlPatterns = {"/Interest"})
public class Interest extends HttpServlet {

    @EJB
    private IntrestSessionBeanRemote intrestSessionBean;//dependency injection

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String value = req.getParameter("amount");
        
        //anotations godakma declarations waladi thama api use karanna puluwan example widiyata class ekk hadaddi method ekk hadddi wage apita meka use karanna puluwanwagema apita meka method athule declaration ekk unath apita use karanna ba e wagema java micro edition waldith apita me anotations use karanna ba e nisai me wdiyata onema thanaka use karanna puluwan podu ekk hadala thinne
        //ethakota anotation eka nathi una kiyala prshanayak na onema thanka use karanna hadal thina eka apita use karala wade karganna puluwan
        //anotation kiyana ewahamatnama use karanna widiyak nathi nisa apita hama thanama use akranna puluwan widiyakata deyak hadala thinawa eka thama me IntialContext kiyala kiyanne 
//        InitialContext

        PrintWriter pw = resp.getWriter();
        pw.write("Amount : " + value + " -> Amount with interest : " + String.valueOf(intrestSessionBean.calculateTotal(Double.parseDouble(value))));
    }

}
