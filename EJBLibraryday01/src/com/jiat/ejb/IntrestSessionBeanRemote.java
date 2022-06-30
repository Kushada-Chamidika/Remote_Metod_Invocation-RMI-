/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/SessionRemote.java to edit this template
 */
package com.jiat.ejb;

import javax.ejb.Remote;

/**
 *
 * @author 1999k
 */
@Remote
public interface IntrestSessionBeanRemote {

    double calculateTotal(double amount);
    
}
