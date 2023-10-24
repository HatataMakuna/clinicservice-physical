/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package process;
import adt.*;
import entity.*;
import java.util.Scanner;
import ui.PrintColor;

/**
 *
 * @author Cheng Cai Jie
 */
public class ProcessFirstRegister {
    ListInterface<Staff> staff = new ArrayList<>();
    ListInterface<PatientProfile> pprofile = new ArrayList<>();
    
    // startup
    public void start() {
        // add login credentials
        staff.add(new Staff("S001", "nicole123"));
        staff.add(new Staff("S002", "halo321"));
        
        // add patient details
        pprofile.add(new PatientProfile("P001", "Michaele", "010203140101", 20, 45, "Taman Usahawan Kepong, KL", "0123456789", "Diabetes"));
        pprofile.add(new PatientProfile("A001", "Jack", "020202030609", 21, 50, "Taman Usahawan Kepong, KB", "0135489745", "LEG DMG"));
    }
    
    /*
    *
    *  STAFF
    *
    */
    public void addStaff(Staff p) {
        staff.add(p);
    }
    
    public void retrieveStaff() {
        for (int i = 1; i <= staff.getNumberOfEntries(); i++) {
            System.out.println(staff.getEntry(i));
        }
    }
    
    public boolean loggingIn(String id, String password) {
        boolean isSuccess = false;
        for (int i = 1; i <= staff.getNumberOfEntries(); i++) {
            if (staff.getEntry(i).getStaffID().equals(id) && staff.getEntry(i).getPassword().equals(password)) {
                isSuccess = true;
            }
        }
        return isSuccess;
    }
    
    /*
    *
    *  PATIENT PROFILE
    *
    */
    public void addPatient(PatientProfile pp) {
        pprofile.add(pp);
    }
    
    public void displayPatient(String patientID) {
        for (int i = 1; i <= pprofile.getNumberOfEntries(); i++) {
            if (patientID.equals(pprofile.getEntry(i).getPatientID())) {
                System.out.println("\n");
                System.out.print(PrintColor.CYAN);
                System.out.printf("%100s+-------------------------------------------------------+\n", "");
                System.out.print(PrintColor.CYAN);
                System.out.printf("%100s|              Patient Profile Detail                   |\n", "");
                System.out.print(PrintColor.CYAN);
                System.out.printf("%100s+-------------------------------------------------------+\n", "");
                System.out.print(PrintColor.CYAN);
                System.out.printf("%100s              USER ID          : ", "");
                System.out.println(pprofile.getEntry(i).getPatientID());
                System.out.print(PrintColor.CYAN);
                System.out.printf("%100s              USERNAME         : ", "");
                System.out.println(pprofile.getEntry(i).getPatientName());
                System.out.print(PrintColor.CYAN);
                System.out.printf("%100s              IC NUMBER        : ", "");
                System.out.println(pprofile.getEntry(i).getIC());
                System.out.print(PrintColor.CYAN);
                System.out.printf("%100s              AGE              : ", "");
                System.out.println(pprofile.getEntry(i).getAge());
                System.out.print(PrintColor.CYAN);
                System.out.printf("%100s              WEIGHT           : ", "");
                System.out.println(pprofile.getEntry(i).getWeight());
                System.out.print(PrintColor.CYAN);
                System.out.printf("%100s              ADDRESS          : ", "");
                System.out.println(pprofile.getEntry(i).getAddress());
                System.out.print(PrintColor.CYAN);
                System.out.printf("%100s              Phone Number     : ", "");
                System.out.println(pprofile.getEntry(i).getPatientNum());
                System.out.print(PrintColor.CYAN);
                System.out.printf("%100s              Patient History  : ", "");
                System.out.println(pprofile.getEntry(i).getPatientHistory());
            }
        }
    }
    
    public boolean searchPatient(String patientID) {
        for (int i = 1; i <= pprofile.getNumberOfEntries(); i++) {
            if (patientID.equals(pprofile.getEntry(i).getPatientID())) {
                return true;
            }
        }
        return false;
    }
    
    public PatientProfile getPatient(String patientID) {
        PatientProfile pp = new PatientProfile();
        for (int i = 1; i <= pprofile.getNumberOfEntries(); i++) {
            if (patientID.equals(pprofile.getEntry(i).getPatientID())) {
                pp.setPatientID(pprofile.getEntry(i).getPatientID());
                pp.setPatientName(pprofile.getEntry(i).getPatientName());
                pp.setIC(pprofile.getEntry(i).getIC());
                pp.setAge(pprofile.getEntry(i).getAge());
                pp.setWeight(pprofile.getEntry(i).getWeight());
                pp.setAddress(pprofile.getEntry(i).getAddress());
                pp.setPatientNum(pprofile.getEntry(i).getPatientNum());
                pp.setPatientHistory(pprofile.getEntry(i).getPatientHistory());
            }
        }
        return pp;
    }
    
    public void editPatient(String patientID, PatientProfile pp) {
        int toModify = 0;
        for (int i = 1; i <= pprofile.getNumberOfEntries(); i++) {
            if (pprofile.getEntry(i).getPatientID().equals(patientID)) {
                toModify = i;
            }
        }
        pprofile.replace(toModify, pp);
    }
    
    public void deletePatient(String patientID) {
        int idToDelete = 0;
        for (int i = 1; i <= pprofile.getNumberOfEntries(); i++) {
            if (pprofile.getEntry(i).getPatientID().equals(patientID)) {
                idToDelete = i;
            }
        }
        pprofile.remove(idToDelete);
    }
    
    public static void main(String[] args) {
        ProcessFirstRegister prf = new ProcessFirstRegister();
        prf.start();
        prf.retrieveStaff();
        System.out.printf("Please enter Your ID    : ", "");
        Scanner idScan = new Scanner(System.in);
        String id = idScan.nextLine();
        System.out.printf("Please enter Password   : ", "");
        Scanner passwordScan = new Scanner(System.in);
        String password = passwordScan.nextLine();
        System.out.println(prf.loggingIn(id, password));
    }
}
