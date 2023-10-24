/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ui;

import ui.*;
import adt.*;
import entity.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

/**
 *
 * @author Nee Mei Yi
 */
public class SickDetailDriver {
    Scanner scanner = new Scanner(System.in);
    StackInterface<TrackingNumber> trackNumList = new ArrayStack<>(100);
    QueueInterface<SickDetailSystem> sickDetailSystemList = new ArrayQueue<>();
    
    public void start() {
        patientData();
        //menu();
    }
    
    public void patientData(){
        //-----Add Patient-----
        sickDetailSystemList.enqueue(new SickDetailSystem(10001, "Cold", "Upper respiratory infections, meaning they involve your nose, throat, and lungs.", "Acetaminophen", "Oseltamivir"));
        sickDetailSystemList.enqueue(new SickDetailSystem(10002, "Cough", "Voluntary or involuntary act that clears the throat and breathing passage of foreign particles", "Dextromethorphan ", "Dextromethorphan"));
        sickDetailSystemList.enqueue(new SickDetailSystem(10003, "Allergic", "Immune response triggered by allergens, an ordinarily harmful substance", "Antihistamines", "Benadryl, Antihistamines"));
        sickDetailSystemList.enqueue(new SickDetailSystem(10004, "Skin diseases", "Blocked skin follicles that lead to oil, bacteria and dead skin buildup in your pores.", "Tetracycline", "Erythromycin"));
        menu();
    }

    public void menu() {
      int choice = 0;
      boolean proceedToNext;  //continue to next stage
      do {
        System.out.println("\nTracking Number");
        System.out.println("1. Emergency case number.");
        System.out.println("2. Normal case number.");
        System.out.println("3. Exit...");
        System.out.print("Enter choice (1..3): ");
        Scanner tnScan = new Scanner(System.in);
        choice = tnScan.nextInt();
        //scanner.nextLine();
          switch (choice) {
              case 1:
                  displayEmergTrackingNumber();
                  //sickDetail();
                  break;
              case 2:
                  do{
                      System.out.println("\nTracking Number Selection");
                      System.out.println("1. Common illness [Headaches, Colds & Flu, Fever, Cough, Stomach Aches, Diarrhea].");
                      System.out.println("2. Allergic");
                      System.out.println("3. Food poisoning");
                      System.out.println("4. Skin diseases");
                      System.out.println("5. Exit...");
                      System.out.print("Enter choice (1..5): ");
                      Scanner tnSelect = new Scanner(System.in);
                      choice = tnSelect.nextInt();
                      //scanner.nextLine();
                      switch (choice) {
                          case 1: case 2: case 3: case 4: displayNormTrackingNumber(); break;
                          default: System.out.println("\nExiting program."); break;
                      }
                  } while (choice >= 1 && choice <= 4);
                  break;
              case 3:
                    System.out.println("\nExiting program...");
                  //FirstRegister fr = new FirstRegister();
                  //fr.optionPage();
                  break;
              default:
                  break;
          }
      } while (choice >= 1 && choice <= 2);
    }
  
    public void displayNormTrackingNumber() {
        int trackNum = 10000;
        String moreTrackNum;

        trackNum++;
        System.out.println("\nYour tracking number: " + trackNum);
        LocalTime time = LocalTime.now();
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("HH:mm:ss");
        String formattedDate = time.format(myFormatObj);
        LocalDate date = LocalDate.now();
        System.out.print("Time now: ");
        System.out.println(formattedDate);
        System.out.print("Today's date: ");
        System.out.println(date);

        System.out.print("Do you need more Tracking Number [YES/NO]: ");
        Scanner more = new Scanner(System.in);
        moreTrackNum = more.nextLine();
        moreTrackNum = moreTrackNum.toUpperCase();

        while("YES".equals(moreTrackNum) == true){
            trackNum++;
            System.out.println("\nYour tracking number: " + trackNum);
            System.out.print("Time now: ");
            System.out.println(formattedDate);
            System.out.print("Today's date: ");
            System.out.println(date);
            
            System.out.print("Do you need more Tracking Number [YES/NO]: ");
            Scanner moree = new Scanner(System.in);
            moreTrackNum = moree.nextLine();
            moreTrackNum = moreTrackNum.toUpperCase();
        }
        sickDetail();
    }
    
    public int displayEmergTrackingNumber() {
        int trackNum = 20001;
        String moreTrackNum, callTrackNum;

        do{
        System.out.println("\nYour tracking number: " + trackNum);
        //Scanner eTrackNumScan = new Scanner(System.in);
        //eTrackNumScan.nextLine();
        LocalTime time = LocalTime.now();
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("HH:mm:ss");
        String formattedDate = time.format(myFormatObj);
        LocalDate date = LocalDate.now();
        System.out.print("Time now: ");
        System.out.println(formattedDate);
        System.out.print("Today's date: ");
        System.out.println(date);

        TrackingNumber tn = new TrackingNumber(trackNum);
        if(tn.equals(tn)) {
            trackNum++;
        }else {
            return trackNum;
        }
        
        System.out.print("Do you need more Tracking Number [YES/NO]: ");
        Scanner more = new Scanner(System.in);
        moreTrackNum = more.nextLine();
        moreTrackNum = moreTrackNum.toUpperCase();
        }while("NO".equals(moreTrackNum.toUpperCase()) == false);
        
        trackNum--;
        trackNumList.push(new TrackingNumber(trackNum));
//        for(int i = 0; i <= trackNumList.toString(); i++){
            if (trackNum == trackNumList.peek().getTrackNum()) {
//                System.out.println(trackNumList.peek());
                System.out.println(trackNumList.toString());
            }
//        }
        trackNum++;
        
        System.out.print("Is calling first Tracking Number [YES/NO]: ");
        Scanner callTrack = new Scanner(System.in);
        callTrackNum = callTrack.nextLine();
        callTrackNum = callTrackNum.toUpperCase();
        if("YES".equals(callTrackNum.toUpperCase()) == true){
            if (trackNum == trackNumList.pop().getTrackNum()) {
                System.out.println(trackNumList.toString());
            }
            sickDetail();
        }
        
        return 0;
    }
  
    public void sickDetail(){
      int choice = 0;
      boolean proceedToNext;  //continue to next stage
      do{
        System.out.println("\n--------Sick Detail System--------");
        System.out.println("1. Add new patient sickness detail");
        System.out.println("2. Display patient sickness detail");
        System.out.println("3. Remove normal cases patient sickness detail");
        System.out.println("4. Remove emergency cases patient sickness detail");
        System.out.println("5. Exit...");
        System.out.print("Enter choice (1..4): ");
        Scanner detail = new Scanner(System.in);
        choice = detail.nextInt();
        //scanner.nextLine();
          switch (choice) {
              case 1:
                addPatient();
                break;
              case 2:
                displayPatient();
                break;
              case 3:
                removeNormPatient();
                break;
              case 4:
                removeEmergPatient();
                break;
              case 5:
                menu();
                break;
              default:
                System.out.println("Please enter 1 to 4 only !!");
                break;
          }
      }while (choice < 1 && choice > 4);
    }
  
    public int addPatient() {
        String proceedToNext = "YES";
        int patientID = 10005;
        
        String symptom, sickDescription, medicalHistory, medicineTaking;
        
        do{
            System.out.println("\n--------Patient Information--------");
            System.out.printf("\nPatient ID (5 digits) : %7d", patientID);
            Scanner pidScan = new Scanner(System.in);
            pidScan.nextLine();
            System.out.print("Patient sickness symptom : ");
            Scanner syScan = new Scanner(System.in);
            symptom = syScan.nextLine();
            while ("".equals(symptom) || !symptom.matches("[a-zA-Z ]+")) {
                if ("".equals(symptom)) {
                    System.out.printf("The name can't be empty! Please enter the patient sickness symptom!\nEnter patient sickness symptom: ");
                    Scanner nSyScan = new Scanner(System.in);
                    symptom = nSyScan.nextLine();
                }else if (!symptom.matches("[a-zA-Z ]+")) {
                    System.out.printf("The name only include alphabetic character and space! Please re-enter again!\nEnter patient sickness symptom: ");
                    Scanner nnSyScan = new Scanner(System.in);
                    symptom = nnSyScan.nextLine();
                }
            }
            System.out.print("Patient sickness description : ");
            Scanner desc = new Scanner(System.in);
            sickDescription = desc.nextLine();
                if ("".equals(sickDescription)) {
                    System.out.printf("The name can't be empty! Please enter the patient sickness sickDescription!\nEnter patient sickness description: ");
                    Scanner aDesc = new Scanner(System.in);
                    sickDescription = aDesc.nextLine();
                }
            System.out.print("Medicine taking : ");
            Scanner take = new Scanner(System.in);
            medicineTaking = take.nextLine();
            while ("".equals(medicineTaking) || !medicineTaking.matches("[a-zA-Z ]+")) {
                if ("".equals(medicineTaking)) {
                    System.out.printf("The name can't be empty! Please enter Member's name!\nEnter Medicine taking: ");
                    Scanner aTake = new Scanner(System.in);
                    medicineTaking = aTake.nextLine();
                }
                if (!medicineTaking.matches("[a-zA-Z ]+")) {
                    System.out.printf("The name only include alphabetic character and space! Please re-enter again!\nEnter Medicine taking: ");
                    Scanner aaTake = new Scanner(System.in);
                    medicineTaking = aaTake.nextLine();
                }
            }
            System.out.print("Medical history : ");
            Scanner history = new Scanner(System.in);
            medicalHistory = history.nextLine();
            //patientID++;
            SickDetailSystem sds = new SickDetailSystem(patientID, symptom, sickDescription, medicineTaking, medicalHistory);
                if(sds.equals(sds)) {
                    patientID++;
                }else {
                    return patientID;
                }
            System.out.print("\nConfirm to proceed [YES/NO]? ");
            Scanner proceed = new Scanner(System.in);
            proceedToNext = proceed.nextLine();
        }while ("YES".equals(proceedToNext.toUpperCase()) == false);

        patientID--;
        sickDetailSystemList.enqueue(new SickDetailSystem(patientID, symptom, sickDescription, medicineTaking, medicalHistory));
        for(int i = 0; i <= sickDetailSystemList.getBackIndex(); i++){
            if (patientID == sickDetailSystemList.getEntry(i).getPatientID()) {
                System.out.println(sickDetailSystemList.getEntry(i));
            }
        }
        patientID++;
        System.out.println("\nCreated a patient information.");
        System.out.println("");
        
        sickDetail();
        
        return 0;
    }
  
//    public int editPatient() {
//        int choice = 0;
//        String proceedToNext;
//        int patientID;
//        String symptom = null;
//        String sickDescription = null;
//        String medicalHistory = null;
//        String medicineTaking = null;
//        String newSymptom = null;
//        String newSickDescription = null;
//        String newMedicalHistory = null;
//        String newMedicineTaking = null;
//        Scanner modify = new Scanner(System.in);
//        int toModify = 0;
//        
//        do{
//        System.out.print("\nEnter patient ID: ");
//        patientID = scanner.nextInt();
//        scanner.nextLine();
//        
//        //displayPatient();
//        
//            do{
//            System.out.println("\n--------Edit Patient Sick Detail--------");
//            System.out.println("1. Edit patient symptom");
//            System.out.println("2. Edit patient sick description");
//            System.out.println("3. Edit patient medicine taking");
//            System.out.println("4. Edit patient medicine history");
//            System.out.println("5. Exit...");
//            System.out.print("Enter choice (1..4): ");
//            choice = scanner.nextInt();
//            scanner.nextLine();
//              switch (choice) {
//                  case 1:
//                        System.out.print("Please update patient new symptom: ");
//                        newSymptom = modify.nextLine();
//                        for(int i = 1; i < sickDetailSystemList.size(); i++){
//                            if(sickDetailSystemList.getFront().getSymptom().equals(symptom)){
//                                symptom = sickDetailSystemList.getFront().getSymptom();
//                                System.out.println("Patient new symptom: " + newSymptom);
//                                toModify = i;
//                            }
//                        sickDetailSystemList.replace(toModify, new SickDetailSystem(patientID, newSymptom, sickDescription, medicineTaking, medicalHistory));   //is enqueue?
//                        }
//                    break;
//                  case 2:
//                        System.out.print("Please update patient new sick description: ");
//                        newSickDescription = modify.nextLine();
//                        for(int i = 1; i < sickDetailSystemList.size(); i++){
//                            if(sickDetailSystemList.getFront().getSickDescription().equals(sickDescription)){
//                                sickDescription = sickDetailSystemList.getFront().getSickDescription();
//                                System.out.println("Patient new sick description: " + newSickDescription);
//                                toModify = i;
//                            }
//                        sickDetailSystemList.replace(toModify, new SickDetailSystem(patientID, symptom, newSickDescription, medicineTaking, medicalHistory));   //is enqueue?
//                        }
//                    break;
//                  case 3:
//                        System.out.print("Please update patient new medicine taking: ");
//                        newMedicineTaking = modify.nextLine();
//                        for(int i = 1; i < sickDetailSystemList.size(); i++){
//                            if(sickDetailSystemList.getFront().getMedicineTaking().equals(medicineTaking)){
//                                medicineTaking = sickDetailSystemList.getFront().getMedicineTaking();
//                                System.out.println("Patient new medicine taking: " + newMedicineTaking);
//                                toModify = i;
//                            }
//                        sickDetailSystemList.replace(toModify, new SickDetailSystem(patientID, symptom, sickDescription, newMedicineTaking, medicalHistory));   //is enqueue?
//                        }
//                    break;
//                  case 4:
//                        System.out.print("Please update patient new medical history: ");
//                        newMedicalHistory = modify.nextLine();
//                        for(int i = 1; i < sickDetailSystemList.size(); i++){
//                            if(sickDetailSystemList.getFront().getMedicalHistory().equals(medicalHistory)){
//                                medicalHistory = sickDetailSystemList.getFront().getMedicalHistory();
//                                System.out.println("Patient new medical history: " + newMedicalHistory);
//                                toModify = i;
//                            }
//                        sickDetailSystemList.replace(toModify, new SickDetailSystem(patientID, symptom, sickDescription, medicineTaking, newMedicalHistory));   //is enqueue?
//                        }
//                    break;
//                  default:
//                    System.out.println("\nExit editing...");
//                    break;
//              }
//            }while (choice >= 1 && choice <= 4);
//            
//            System.out.print("Do you want to continue editing [YES/NO]? ");
//            proceedToNext = scanner.nextLine();
//            proceedToNext = proceedToNext.toUpperCase();
//            
//        }while ("NO".equals(proceedToNext) == false);
//        
//        sickDetail();
//        
//        return 0;
//    }
    
    public void displayPatient() {
        sickDetailSystemList.getAllEntries();
//        int patientID;
//        
//        System.out.print("\nEnter patient ID: ");
//        Scanner search = new Scanner(System.in);
//        patientID = search.nextInt();
//        //scanner.nextLine();
//        
//        for(int i = 0; i <= sickDetailSystemList.getBackIndex(); i++){
//            if (patientID == sickDetailSystemList.getEntry(i).getPatientID()) {
//                System.out.println(sickDetailSystemList.getEntry(i));
//            }
//        }
        
        sickDetail();
    }
    
    public void removeNormPatient() {
        int patientID;
        
        System.out.println("");
        sickDetailSystemList.getAllEntries();
        System.out.println("\n------Remove Normal Cases Patient Information------");
        System.out.print("\nPlease be aware that only the first patient's information may be deleted here!!!");
        System.out.print("\nPatient must follow the queue list by list as is typical.\n");
        System.out.print("\nPlease enter the patient ID to be removed: ");
        patientID = scanner.nextInt();
        for(int i = 0; i <= sickDetailSystemList.getFrontIndex(); i++){
            if (patientID == sickDetailSystemList.getEntry(i).getPatientID()) {
                sickDetailSystemList.dequeue();
                System.out.println("\n" + patientID + " patient ID has been removed.");
            }else{
                System.out.printf("\nThe patient ID is not locate at the first!\n");
                sickDetailSystemList.getAllEntries();
                System.out.printf("\nPlease enter the patient ID to be removed: ");
                patientID = scanner.nextInt();
                while(patientID == sickDetailSystemList.getEntry(i).getPatientID()){
                    sickDetailSystemList.dequeue();
                    System.out.println("\n" + patientID + " patient ID has been removed.");
                }
            }
        }
        System.out.println("\nDeleted successfully!\n");
        
        sickDetailSystemList.getAllEntries();
        
        sickDetail();
    }
    
    public void removeEmergPatient() {
        int patientID;
        
        System.out.println("");
        sickDetailSystemList.getAllEntries();
        System.out.println("\n------Remove Emergency Cases Patient Information------");
        System.out.print("\nPlease be aware that only the recent patient's information may be deleted here!!!");
        System.out.print("\nAs the emergency patient might have a pressing issue would like to check out their data.\n");
        System.out.print("\nPlease enter the patient ID to be removed: ");
        patientID = scanner.nextInt();
        
        for(int i = 0; i <= sickDetailSystemList.getBackIndex(); i++){
            if (patientID == sickDetailSystemList.getEntry(i).getPatientID()) {
                sickDetailSystemList.dequeue(patientID);
                System.out.println("\n" + patientID + " patient ID has been removed.");
            }else{
//                System.out.printf("\nThe patient ID is not recently added!\n");
//                sickDetailSystemList.getAllEntries();
//                System.out.printf("\nPlease enter the patient ID to be removed: ");
//                patientID = scanner.nextInt();
//                while(patientID == sickDetailSystemList.getEntry(i).getPatientID()){
//                    sickDetailSystemList.dequeue(patientID);
//                    System.out.println("\n" + patientID + " patient ID has been removed.");
//                }
            }
        }

        System.out.println("\nDeleted successfully!\n");
        
        sickDetailSystemList.getAllEntries();
        
        sickDetail();
    }
        
    public static void main(String[] args) {
      SickDetailDriver t = new SickDetailDriver();
      t.start();
    }
}