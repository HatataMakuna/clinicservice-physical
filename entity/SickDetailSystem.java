package entity;

import adt.*;
import java.util.Scanner;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Nee Mei Yi
 */
public class SickDetailSystem {
    private int patientID;
    private String symptom;
    private String sickDescription;
    private String medicalHistory;
    private String medicineTaking;
    
    public SickDetailSystem(int patientID, String symptom, String sickDescription, String medicineTaking, String medicalHistory) {
        this.patientID = patientID;
        this.symptom = symptom;
        this.sickDescription = sickDescription;
        this.medicineTaking = medicineTaking;
        this.medicalHistory = medicalHistory;
    }
    
    public int getPatientID() {
        return patientID;
    }

    public void setPatientID(int patientID) {
        this.patientID = patientID;
    }

    public String getSymptom() {
        return symptom;
    }

    public void setSymptom(String symptom) {
        this.symptom = symptom;
    }
    
    public String getSickDescription() {
        return sickDescription;
    }

    public void setSickDescription(String sickDescription) {
        this.sickDescription = sickDescription;
    }
    
    public String getMedicineTaking() {
        return medicineTaking;
    }

    public void setMedicineTaking(String medicineTaking) {
        this.medicineTaking = medicineTaking;
    }
    
    public String getMedicalHistory() {
        return medicalHistory;
    }

    public void setMedicalHistory(String medicalHistory) {
        this.medicalHistory = medicalHistory;
    }
    
    @Override
    public String toString(){
            return String.format("| %-7d | %-15s | %-90s | %-50s | %-50s |\n", patientID, symptom, sickDescription, medicineTaking, medicalHistory);
    }
}