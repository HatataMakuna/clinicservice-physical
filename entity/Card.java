/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author Har Chun Wai
 */
public class Card {
    private String patientID;
    private String debitCard; // debit card number
    private String creditCard; // credit card number
    private String ewallet; // e wallet number
    private String pin;
    
    // default constructor
    public Card() {
        this("", "", "", "", "");
    }
    
    // constructor when all details were inputted
    public Card(String patientID, String debitCard, String creditCard, String ewallet, String pin) {
        this.patientID = patientID;
        this.debitCard = debitCard;
        this.creditCard = creditCard;
        this.ewallet = ewallet;
        this.pin = pin;
    }
    
    // setters
    public void setPatientID(String patientID) {
        this.patientID = patientID;
    }
    public void setCreditCard(String creditCard) {
        this.creditCard = creditCard;
    }
    public void setDebitCard(String debitCard) {
        this.debitCard = debitCard;
    }
    public void setEwallet(String ewallet) {
        this.ewallet = ewallet;
    }
    public void setPin(String pin) {
        this.pin = pin;
    }
    
    // getters
    public String getPatientID() {
        return patientID;
    }
    public String getCreditCard() {
        return creditCard;
    }
    public String getDebitCard() {
        return debitCard;
    }
    public String getEwallet() {
        return ewallet;
    }
    public String getPin() {
        return pin;
    }
    
    // to String method
    @Override
    public String toString() {
        return String.format("%s\t%s\t%s\t%s\t%s", patientID, debitCard, creditCard, ewallet, pin);
    }
}
