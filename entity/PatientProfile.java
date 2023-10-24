/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author Cheng Cai Jie
 */
public class PatientProfile {
    private String patientID;
    private String patientName;
    private String ic;
    private int age;
    private double weight;
    private String address;
    private String patientNum;
    private String patientHistory;
    
    public PatientProfile() {
        
    }
    
    public PatientProfile(String patientID, String patientName, String ic, int age, double weight, String address, String patientNum, String patientHistory) {
        this.patientID = patientID;
        this.patientName = patientName;
        this.ic = ic;
        this.age = age;
        this.weight = weight;
        this.address = address;
        this.patientNum = patientNum;
        this.patientHistory = patientHistory;
    }
    
    public String getPatientID() {
        return patientID;
    }

    public void setPatientID(String patientID) {
        this.patientID = patientID;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public String getIC() {
        return ic;
    }

    public void setIC(String ic) {
        this.ic = ic;
    }
    
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    
    public String getPatientNum() {
        return patientNum;
    }

    public void setPatientNum(String patientNum) {
        this.patientNum = patientNum;
    }

    public String getPatientHistory() {
        return patientHistory;
    }

    public void setPatientHistory(String patientHistory) {
        this.patientHistory = patientHistory;
    }
}
