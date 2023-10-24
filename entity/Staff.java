/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

/**
 *
 * @author Cheng Cai Jie
 */
public class Staff {
    private String staffID;
    private String password;
    
    public Staff(String stuffID, String password) {
        this.staffID = stuffID;
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getStaffID() {
        return staffID;
    }

    public void setStaffID(String stuffID) {
        this.staffID = stuffID;
    }

    @Override
    public String toString() {
        return String.format("%s\t%s", staffID, password);
    }
}