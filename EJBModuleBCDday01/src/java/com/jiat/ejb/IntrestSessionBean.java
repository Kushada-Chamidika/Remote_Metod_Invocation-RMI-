/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/StatelessEjbClass.java to edit this template
 */
package com.jiat.ejb;

import javax.ejb.Stateless;

/**
 *
 * @author 1999k
 */
@Stateless
public class IntrestSessionBean implements IntrestSessionBeanRemote {

    @Override
    public double calculateTotal(double amount) {

        return (amount + ((amount * 10) / 100));
    }

}
