/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author Har Chun Wai
 */
public class Payment {
    private static int nextPaymentID = 5000;
    private String patientID;
    private int paymentID;
    private String paymentType;
    private double totalCost;
    
    public Payment(int paymentID) {
        this.paymentID = paymentID;
    }
    
    public Payment(String patientID, String paymentType, double totalCost) {
        this.paymentID = nextPaymentID++;
        this.patientID = patientID;
        this.paymentType = paymentType;
        this.totalCost = totalCost;
    }

    public static int getNextPaymentID() {
        return nextPaymentID;
    }
    
    public String getPatientID() {
        return patientID;
    }

    public int getPaymentID() {
        return paymentID;
    }

    public String getPaymentType() {
        return paymentType;
    }

    public double getTotalCost() {
        return totalCost;
    }
    
    public void setPatientID(String patientID) {
        this.patientID = patientID;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }

    public static void setNextPaymentID(int nextPaymentID) {
        Payment.nextPaymentID = nextPaymentID;
    }

    public void setPaymentID(int paymentID) {
        this.paymentID = paymentID;
    }

    public void setTotalCost(double totalCost) {
        this.totalCost = totalCost;
    }
    
    @Override
    public String toString() {
        return String.format("%s\t%s\t%s\t%s", paymentID, patientID, paymentType, totalCost);
    }
}
