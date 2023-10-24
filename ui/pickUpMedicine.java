/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ui;
import adt.*;
import entity.*;
import process.*;
import java.beans.EventHandler;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
//import java.util.LinkedList;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Tan Kang Hong
 * 
 */
public class pickUpMedicine {
    //static Scanner choice = new Scanner(System.in);
    //private static final int DEFAULT_PROCESSING_TIME = 1;
    ProcessMedicine pm = new ProcessMedicine();
    medicineSystem ms = new medicineSystem();
    //LinkedList<medicineInformation> medicialInformationList = new LinkedList<medicineInformation>();
    //LinkedList<generateHistory> generateHistoryList = new LinkedList<generateHistory>();
    
    String pid = "";
    String patientName = "";

    public void patientData(LinkedList<searchPatientID> searchPatientIDList) {
        searchPatientIDList.add(new searchPatientID("P000001"));
        searchPatientIDList.add(new searchPatientID("P000002"));
        searchPatientIDList.add(new searchPatientID("P000003"));
        searchPatientIDList.add(new searchPatientID("P000004"));
    }
    
    public void start() {
        pm.start();
        pumStart();
    }
    
    public void pumStart() {
        int menuChoice = 0;
        // menu
        do {
            System.out.println("==================================================");
            System.out.println("+                    MENU                        +");
            System.out.println("==================================================");
            System.out.println("| [1] Generate tracking number                   |");
            System.out.println("| [2] Search patient ID                          |");
            System.out.println("| [3] Generate history                           |");
            System.out.println("| [4] Pick up medicine                           |");
            System.out.println("| [5] Medicine system                            |");
            System.out.println("| [6] Run from beginning                         |");
            System.out.println("| [7] Exit                                       |");
            System.out.println("==================================================");
            System.out.print  ("Your choice (1-6): ");
            Scanner menu = new Scanner(System.in);
            menuChoice = menu.nextInt();
            switch (menuChoice) {
                case 1: generateTrackingNumber(); 
                pumStart();break;
                case 2: searchPatientID(); pumStart(); break;
                case 3: generateCheckHistory(); pumStart(); break;
                case 4: 
                    if ("".equals(pid) || "".equals(patientName)) {
                        System.out.println("You have not search a patient yet !!");
                        menuChoice = 0; // to loop back
                    } else {
                        welcome();
                        
                    }  
                    break;
                case 5: 
                    ms.msStart();
                    ms.welcome();
                    break;
                case 6:
                    generateTrackingNumber();
                    searchPatientID();
                    
                    welcome();
                    ms.msStart();
                    ms.welcome();
                    generateCheckHistory();
                    break;
                    case 7:
                        System.out.println("Exiting...\n");
                        break;
                default:
                    System.out.println("Please enter 1 to 6 only !!");
            }
        } while (menuChoice < 1 || menuChoice > 7);
    }
    
    public static void main(String args[]) {
        pickUpMedicine pum = new pickUpMedicine();
        pum.start();
        pum.pumStart();
        
        //pum.generateTrackingNumber();
        //pum.searchPatientID();
        //pum.welcome();
    }
    
    private void generateTrackingNumber() {
        int a = 0;
        Scanner gTrackingNumber = new Scanner(System.in);
        
//        generateTrackingNumber myGenerateTrackingNumber = new generateTrackingNumber();
        a++;
        System.out.println("\n\nYour Tracking Number : " + a);
        LocalTime myTime = LocalTime.now();
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("HH:mm:ss");
        String formattedDate = myTime.format(myFormatObj);
        LocalDate myDate = LocalDate.now();
        System.out.print("Duration Time : ");
        System.out.println(formattedDate);
        System.out.print("Duration Date : ");
        System.out.println(myDate);
        System.out.print("Waiting Time  : ");
        System.out.println(formattedDate);
    
//        System.out.println(generateTrackingNumber);
        System.out.print("Need More Tracking Number (Y | N) : ");
        char trackingNumber = gTrackingNumber.next().charAt(0);

        while (trackingNumber == 'Y' || trackingNumber == 'y'){
            a++;
            System.out.println("\n\nYour Tracking Number : " + a);
            
            System.out.print("Duration Time : ");
        System.out.println(formattedDate);
        System.out.print("Duration Date : ");
        System.out.println(myDate);
        System.out.print("Waiting Time  : ");
        System.out.println(formattedDate);
            System.out.print("Need More Tracking Number (Y | N) : ");
            trackingNumber = gTrackingNumber.next().charAt(0);
            
        }
    }
    
    private void welcome() {
        displayDelay();
        System.out.println("   _____             .___.__       .__       .__    .___        _____                            __  .__               ");  
        displayDelay();                           
        System.out.println("  /     \\   ____   __| _/|__| ____ |__|____  |  |   |   | _____/ ____\\___________  _____ _____ _/  |_|__| ____   ____  "); 
        displayDelay();
        System.out.println(" /  \\ /  \\_/ __ \\ / __ | |  |/ ___\\|  \\__  \\ |  |   |   |/    \\   __\\/  _ \\_  __ \\/     \\\\__  \\\\   __\\  |/  _ \\ /    \\ "); 
        displayDelay();
        System.out.println("/    Y    \\  ___// /_/ | |  \\  \\___|  |/ __ \\|  |__ |   |   |  \\  | (  <_> )  | \\/  Y Y  \\/ __ \\|  | |  (  <_> )   |  \\"); 
        displayDelay();
        System.out.println("\\____|__  /\\___  >____ | |__|\\___  >__(____  /____/ |___|___|  /__|  \\____/|__|  |__|_|  (____  /__| |__|\\____/|___|  /"); 
        displayDelay();
        System.out.println("        \\/     \\/     \\/         \\/        \\/                \\/                        \\/     \\/                    \\/ "); 
        displayDelay();
        System.out.println("                                                       __/ |            "); 
        displayDelay();
        System.out.println("Starting the module..."); 
        displayDelay();
        System.out.println("Almost done..."); 
        displayDelay();
        System.out.println("Ready"); 
        displayDelay();
        typeOfSickness();
//        clearScreen();
    }

    private void displayDelay() {
        try {
            TimeUnit.MILLISECONDS.sleep(500);
        } catch (InterruptedException ex) {
            Logger.getLogger(EventHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void searchPatientID() {
        ProcessFirstRegister pfr = new ProcessFirstRegister();
        FirstRegister fr = new FirstRegister();
        pfr.start();
//        fr.displayPatient();

        LinkedList<PatientProfile> patientList = new LinkedList<PatientProfile>();
        Scanner s = new Scanner(System.in);
        patientList.add(new PatientProfile("P001", "Michaele", "010203140101", 20, 45, "Taman Usahawan Kepong, KL", "0123456789", "Diabetes"));
        patientList.add(new PatientProfile("A001", "Jack", "020202030609", 21, 50, "Taman Usahawan Kepong, KB", "0135489745", "LEG DMG"));
        
        //String pid = "";
        System.out.println("\n\n");
        System.out.printf("%100s       Please Enter Patient ID:   ", "");
        pid = s.next();
        
        for (int i = 1; i <= patientList.getNumberOfEntries(); i++) {
            if (pid.equals(patientList.getEntry(i).getPatientID())) {

                System.out.println("\n");
                System.out.printf("%100s+-------------------------------------------------------+\n", "");
                System.out.printf("%100s|              Patient Profile Detail                   |\n", "");
                System.out.printf("%100s+-------------------------------------------------------+\n", "");
                System.out.printf("%100s              USER ID          : ", "");
                System.out.println(patientList.getEntry(i).getPatientID());
                System.out.printf("%100s              USERNAME         : ", "");
                System.out.println(patientList.getEntry(i).getPatientName());
                patientName = patientList.getEntry(i).getPatientName();
                System.out.printf("%100s              IC NUMBER        : ", "");
                System.out.println(patientList.getEntry(i).getIC());
                System.out.printf("%100s              AGE              : ", "");
                System.out.println(patientList.getEntry(i).getAge());
                System.out.printf("%100s              WEIGHT           : ", "");
                System.out.println(patientList.getEntry(i).getWeight());
                System.out.printf("%100s              ADDRESS          : ", "");
                System.out.println(patientList.getEntry(i).getAddress());
                System.out.printf("%100s              Phone Number     : ", "");
                System.out.println(patientList.getEntry(i).getPatientNum());
                System.out.printf("%100s              Patient History  : ", "");

                System.out.println(patientList.getEntry(i).getPatientHistory());
            }
        }
    }
    
    private void displayPatientID(LinkedList<searchPatientID> searchPatientIDList) {
//        String patientID = null;
//        String proceed = "";

        displayDelay();
        System.out.println("The System will display the List of Medicial Information !!!");
        displayDelay();
        System.out.println("Please Wait a moment............");
        displayDelay();
        System.out.println("Our aim: to provide the best service for customers, to find out the cause of the patient");
        displayDelay();
//        searchPatientIDList.add(new searchPatientID(patientID));
        System.out.print(searchPatientIDList);
    }
   
    
    public void typeOfSickness(){
        int sicknessChoice = 0;
        do{
            System.out.println("\n");
            System.out.println("----------------------------- TYPE OF SICKNESS -----------------------------");
            System.out.println("| [1] Common Illnesses                                                     |");
            System.out.println("| [2] Allergic (Medicine, food, pollen, latex, pet dander)                 |");
            System.out.println("| [3] Food poisoning                                                       |");
            System.out.println("| [4] Skin diseases                                                        |");
            System.out.println("| [5] Display all the sickness details                                     |");
            System.out.println("| [6] Generate History                                                     |");
            System.out.println("| [7] Medicine system                                                      |"); // add
            System.out.println("| [8] Proceed to payment                                                   |");
            System.out.println("| [9] Back to main menu                                                    |");
            System.out.println("----------------------------------------------------------------------------");
            System.out.println("What is your wanna to choose? ");
            Scanner scScan = new Scanner(System.in);
            sicknessChoice = scScan.nextInt();
//            clearScreen();
            switch (sicknessChoice) {
                case 1: commonIllnesses(); break;
                case 2: pm.displayMedicine(pid, patientName, "Medicine allergic"); typeOfSickness(); break;
                case 3: pm.displayMedicine(pid, patientName, "Food poisoning"); typeOfSickness(); break;
                case 4: skinDiseases(); break;
                case 5: displayList(); break;
                case 6: generateCheckHistory(); break;
                case 7: 
                    medicineSystem ms = new medicineSystem();
                    ms.msStart();
                    ms.welcome();
                    break;
                case 8: 
                    // go to cw's payment system
                    break;
                case 9:
                    System.out.println("\nexiting medicialSystem...");
                    displayDelay();
                    welcome();
                    break;
                default:
                    System.out.println("Please enter 1 to 8 only !!");
            }
        } while (sicknessChoice < 1 || sicknessChoice > 9);
    }
    
    public void commonIllnesses(){
        displayDelay();
        System.out.println("The System will display the List of Medicial Information !!!");
        displayDelay();
        System.out.println("Please Wait a moment............");
        displayDelay();
        System.out.println("Our aim: to provide the best service for customers, to find out the cause of the patient");
        displayDelay();
        
        int commonChoice = 0;
        do {
            System.out.println("\n\n");
            System.out.println("=============================");
            System.out.println("|   Type of CommonIllnesses |");
            System.out.println("=============================");
            System.out.println("+ [1] Headaches             +");
            System.out.println("+ [2] Colds and Flu         +");
            System.out.println("+ [3] Fever                 +");
            System.out.println("+ [4] Cough                 +");
            System.out.println("+ [5] Stomach Aches         +");
            System.out.println("+ [6] Diarrhea              +");
            System.out.println("+ [7] Exit                  +");
            System.out.println("=============================");
            System.out.print("Enter choice(1-7):");
            Scanner ciScan = new Scanner(System.in);
            commonChoice = ciScan.nextInt();
    //            clearScreen();
            switch (commonChoice) {
                case 1: pm.displayMedicine(pid, patientName, "Headaches"); break;
                case 2: pm.displayMedicine(pid, patientName, "Colds and Flu"); break;
                case 3: pm.displayMedicine(pid, patientName, "Fever"); break;
                case 4: pm.displayMedicine(pid, patientName, "Cough"); break;
                case 5: pm.displayMedicine(pid, patientName, "Stomach Aches"); break;
                case 6: pm.displayMedicine(pid, patientName, "Diarrhea"); break;
                case 7: typeOfSickness(); break;
                default: System.out.println("Please enter 1 to 7 only !!");
            }
            // if the choice is not 7 (Exit), loop back the menu until user chooses to exit
            if (commonChoice != 7) {
                commonChoice = 0;
            }
        } while (commonChoice < 1 || commonChoice > 7);
    }
    
    public void skinDiseases(){
        int sd = 0;
        do {
            System.out.println("\n\n");
            System.out.println("===================================");
            System.out.println("|      Type of Skin Diseases      |");
            System.out.println("===================================");
            System.out.println("+ [1] Acne                        +");
            System.out.println("+ [2] Atopic dermatitis (eczema)  +");
            System.out.println("+ [3] Exit                        +");
            System.out.println("===================================");
            System.out.print("Enter choice(1-3):");
            Scanner sdScan = new Scanner(System.in);
            sd = sdScan.nextInt();
            switch(sd) {
                case 1: pm.displayMedicine(pid, patientName, "Acne"); break;
                case 2: pm.displayMedicine(pid, patientName, "Atopic dermatitis (eczema)"); break;
                case 3: typeOfSickness(); break;
                default: System.out.println("Please enter 1 to 3 only !!");
            }
            // if the choice is not 3 (Exit), loop back the menu until user chooses to exit
            if (sd != 3) {
                sd = 0;
            }
        } while (sd < 1 || sd > 3);
    }
    
    // display all common illness medicines
    private void displayList(){
        displayDelay();
        System.out.println("The System will display the List of Medicial Information !!!");
        displayDelay();
        System.out.println("Please Wait a moment............");
        displayDelay();
        System.out.println("Our aim: to provide the best service for customers, to find out the cause of the patient");
        displayDelay();
        pm.retrieveAllMedicine2(pid, patientName);
        
        System.out.print("Press enter to go back... ");
        Scanner goBack = new Scanner(System.in);
        goBack.nextLine();
        typeOfSickness();
    }

    private void generateCheckHistory(){
        pm.displayHistory();
        
        System.out.print("Press enter to go back... ");
        Scanner goBack = new Scanner(System.in);
        goBack.nextLine();
        pumStart();
    }
}