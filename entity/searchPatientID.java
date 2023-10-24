/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author Tan Kang Hong
 */
public class searchPatientID {
    private String patientID;
    
    public searchPatientID(String patientID){
        this.patientID = patientID;
    }
    
    private String getPatientID(){
        return patientID;
    }
    
    private void setPatientID(String patientID){
        this.patientID = patientID;
    }
    
    @Override
    public String toString(){
        return String.format(" %-7s\n", patientID);
    }
}