/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ui;
/**
 *
 * @author Tan Kang Hong
 */
import adt.LinkedList;
import adt.ListInterface;
//import assignment2.entity.generateHistory2;
import entity.*;
import process.*;

import java.beans.EventHandler;
import java.util.logging.Logger;
import java.util.logging.Level;
import java.util.Scanner;
//import java.util.ArrayList;
//import static java.util.Collections.list;
import java.util.concurrent.TimeUnit;

public class medicineSystem {    
    ListInterface<medicineInformation> mi = new LinkedList<>(); // medicine information
    ProcessMedicine pm = new ProcessMedicine();
    LinkedList<generateHistory2> generateHistoryList2 = new LinkedList<generateHistory2>();
    public void msStart() {
        pm.start();
        welcome();
    }
    
    public static void main(String args[]) {

        //LinkedList<medicialInformation> medicialInformationList = new LinkedList<medicialInformation>();
        medicineSystem ma = new medicineSystem();
 //    System.out.println(medicialInformation);
        ma.msStart();
        //ma.welcome();
    }
    
    private void displayDelay(){
        try {
            TimeUnit.MILLISECONDS.sleep(500);
        } catch (InterruptedException ex) {
            Logger.getLogger(EventHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void welcome(){
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
//        clearScreen();
        medicineSystemHome();
    }
    
    public void medicineSystemHome(){
        int medicialChoice = 0;
        do {
            System.out.println("\n");
            System.out.println("\n");
            System.out.println("----------- MEDICINE SYSTEM -----------");
            System.out.println("| [1] Search Medicine                 |");
            System.out.println("| [2] Create an Medicine              |");
            System.out.println("| [3] Edit an Medicine Information    |");
            System.out.println("| [4] Delete an Medicine Information  |");
            System.out.println("| [5] Display current Medicial List   |");
            System.out.println("| [6] Generate History                |");
            System.out.println("| [7] Exit                            |");
            System.out.println("---------------------------------------");
            System.out.println("What is your wanna to choose? ");
            Scanner home = new Scanner(System.in);
            medicialChoice = home.nextInt();
            switch (medicialChoice) {
                case 1: searchMedicine(); break;
                case 2: createMedicine(); break;
                case 3: editMedicine(); break;
                case 4: deleteMedicine(); break;
                case 5: displayMedicine(); break;
                case 6: generateCheckHistory2(); break;
                case 7: 
                    System.out.println("Exiting...\n");
//                    pickUpMedicine pum = new pickUpMedicine();
//                    pum.pumStart();
                    break;
                default: System.out.println("Please enter 1 to 7 only !!"); break;
            }
        } while (medicialChoice < 1 || medicialChoice > 7);
    }
    
    /*
    *
    * SEARCH MEDICINE
    *
    */
    public void searchMedicine(){        
        int identifier = 0;
        char again = 'y';
        do {
            do {
                System.out.println("\n");
                System.out.println("");
                System.out.println("Searching by...");
                System.out.println("[1] Medicial Code");
                System.out.println("[2] Medicial Name");
                System.out.println("[3] Type of Medicial");
                System.out.println("[4] Back To The Medicial System ");
                System.out.print("Please pick one: ");
                Scanner search = new Scanner(System.in);
                identifier = search.nextInt();

                switch (identifier) {
                    case 1:
                        System.out.print("Medicine Code : ");
                        Scanner codeScan = new Scanner(System.in);
                        String medicineCode = codeScan.nextLine();
                        displayDelay();
                        System.out.println("The System will display the List of Medicial Information !!!");
                        displayDelay();
                        System.out.println("Please Wait a moment............");
                        displayDelay();
                        System.out.println("Our aim: to provide the best service for customers, to find out the cause of the patient");
                        displayDelay();
                        pm.searchMedicineByCode(medicineCode);
                       
                        break;
                    case 2:
                        System.out.print("Medicine Name : ");
                        Scanner nameScan = new Scanner(System.in);
                        String medicineName = nameScan.nextLine();
                        displayDelay();
                        System.out.println("The System will display the List of Medicial Information !!!");
                        displayDelay();
                        System.out.println("Please Wait a moment............");
                        displayDelay();
                        System.out.println("Our aim: to provide the best service for customers, to find out the cause of the patient");
                        displayDelay();
                        pm.searchMedicineByName(medicineName);
                        
                        break;
                    case 3: searchByType(); break;
                    case 4: medicineSystemHome(); break;
                    default: System.out.println("Please enter 1 to 4 only !!");
                }
            } while (identifier < 1 || identifier > 4);
            
            if (identifier == 4) {
                displayDelay();
                System.out.println("\nThe system will auto back to the Main menu.");
                displayDelay();
                System.out.println("Please be wait awhile, system are going thru.");
                displayDelay();
                medicineSystemHome();
            } else {
                System.out.print("Do your wanna do the search again (Y/N) :  ");
                Scanner searchAgain = new Scanner(System.in);
                again = searchAgain.next(".").charAt(0);
                if (again == 'Y' || again == 'y') {
                    System.out.println("The System will display the List of Medicial Information !!!");
                    displayDelay();
                    System.out.println("Please Wait a moment............");
                    displayDelay();
                    System.out.println("Our aim: to provide the best service for customers, to find out the cause of the patient");
                    displayDelay();
                } else {
                    displayDelay();
                    System.out.println("\nThe system will auto back to the Main menu.");
                    displayDelay();
                    System.out.println("Please be wait awhile, system are going thru.");
                    displayDelay();
                    medicineSystemHome();
                }
            }
        } while (again == 'Y' || again == 'y');
    }
    
    public void searchByType() {
        int typeSearch = 0;
        char tSearchAgain = 'y';
        do {
            do {
                System.out.println("\n");
                System.out.println("------------------------ TYPE OF SICKNESS ------------------------");
                System.out.println("| [1] Common Illnesses                                           |");
                System.out.println("| [2] Allergic (Medicine, food, pollen, latex, pet dander)       |");
                System.out.println("| [3] Food Poisoning                                             |");
                System.out.println("| [4] Skin Diseases                                              |");
                System.out.println("| [5] Back to main menu                                          |");
                System.out.println("------------------------------------------------------------------");
                System.out.print("What Medicial Type your wanna to choose? ");
                Scanner typeScan = new Scanner(System.in);
                typeSearch = typeScan.nextInt();

                switch (typeSearch) {
                    case 1: pm.searchMedicineByType("Common Illnesses"); break;
                    case 2: pm.searchMedicineByType("Allergic (Medicine, food, pollen, latex, pet dander)"); break;
                    case 3: pm.searchMedicineByType("Food Poisoning"); break;
                    case 4: pm.searchMedicineByType("Skin Diseases"); break;
                    default: System.out.println("Please enter 1 to 5 only !!");
                }
            } while (typeSearch < 1 || typeSearch > 5);
            
            if (typeSearch == 5) {
                displayDelay();
                System.out.println("\nThe system will auto back to the Main menu.");
                displayDelay();
                System.out.println("Please be wait awhile, system are going thru.");
                displayDelay();
                medicineSystemHome();
            } else {
                System.out.print("Do your wanna do the search again (Y/N) :  ");
                Scanner typeAgain = new Scanner(System.in);
                tSearchAgain = typeAgain.next(".").charAt(0);
                if (tSearchAgain == 'Y' || tSearchAgain == 'y') {
                    System.out.println("The System will display the List of Medicial Information !!!");
                    displayDelay();
                    System.out.println("Please Wait a moment............");
                    displayDelay();
                    System.out.println("Our aim: to provide the best service for customers, to find out the cause of the patient");
                    displayDelay();
                } else {
                    displayDelay();
                    System.out.println("\nThe system will auto back to the Main menu.");
                    displayDelay();
                    System.out.println("Please be wait awhile, system are going thru.");
                    displayDelay();
                    medicineSystemHome();
                }
            }
        } while (tSearchAgain == 'y' || tSearchAgain == 'Y');
    }
    
    /*
    *
    * ADD MEDICINE
    *
    */
    String mType, sickType;
    public void createMedicine() {
        boolean codeIsValid = false, nameIsValid = false;
        String medicineCode, medicineName;
        char again;
        
        System.out.println("\nMedicine Information");
        do {
            System.out.print("Medicine Code (8 digits) : ");
            Scanner mCode = new Scanner(System.in);
            medicineCode = mCode.nextLine();
            codeIsValid = pm.validateCode(medicineCode);
        } while (codeIsValid == false);
        do {
            System.out.print("Medicine Name : ");
            Scanner mName = new Scanner(System.in);
            medicineName = mName.nextLine();
            nameIsValid = pm.validateName(medicineName);
        } while (nameIsValid == false);
        
        chooseSickType();
        
        System.out.print("Medicial Price : ");
        Scanner priceScan = new Scanner(System.in);
        double medicinePrice = priceScan.nextDouble();
        
        System.out.print("Medicial Description : ");
        Scanner descScan = new Scanner(System.in);
        String medicineDesc = descScan.nextLine();
        
        System.out.print("Take Medicine : ");
        Scanner takeScan = new Scanner(System.in);
        String takeMedicine = takeScan.nextLine();
        
        System.out.print("Medicial Inventory : ");
        Scanner invScan = new Scanner(System.in);
        int medicineInv = invScan.nextInt();
        
        medicineInformation mi = new medicineInformation(medicineCode, medicineName, mType, sickType,
                medicinePrice, medicineDesc, takeMedicine, medicineInv);
        System.out.print("Proceed?[Y]");
        Scanner proc = new Scanner(System.in);
        char proceed = proc.next(".").charAt(0);
        if (proceed == 'y' || proceed == 'Y') {
            pm.addMedicine(mi);
            System.out.println("Created medicine");
            pm.searchMedicineByCode(medicineCode);
        }
        System.out.print("Do your wanna do the Create again (Y/N) :  ");
                Scanner searchAgain = new Scanner(System.in);
                again = searchAgain.next(".").charAt(0);
                if (again == 'Y' || again == 'y') {
                    System.out.println("The System will display the List of Medicial Information !!!");
                    displayDelay();
                    System.out.println("Please Wait a moment............");
                    displayDelay();
                    System.out.println("Our aim: to provide the best service for customers, to find out the cause of the patient");
                    displayDelay();
                    createMedicine();
                } else {
                    displayDelay();
                    System.out.println("\nThe system will auto back to the Main menu.");
                    displayDelay();
                    System.out.println("Please be wait awhile, system are going thru.");
                    displayDelay();
                    medicineSystemHome();
                }
    }
    
        // choose medicine type
    public void chooseSickType() {
        int medicineType = 0;
        do {
            System.out.println("\n");
            System.out.println("------- TYPE OF SICKNESS -------");
            System.out.println("[1] Common Illnesses ");
            System.out.println("[2] Allergic (Medicine, food, pollen, latex, pet dander)");
            System.out.println("[3] Food Poisoning");
            System.out.println("[4] Skin Diseases");
            System.out.print("What Medicine Type your wanna to choose? ");
            Scanner type = new Scanner(System.in);
            medicineType = type.nextInt();
            if (medicineType < 1 || medicineType > 4) {
                System.out.println("Please enter 1 to 4 only !!");
            }
        } while (medicineType < 1 || medicineType > 4);
        switch (medicineType) {
            case 1:
                mType = "Common Illnesses";
                chooseCommonIllness();
                break;
            case 2: 
                System.out.println("Medicine Type : Allergic (Medicine, food, pollen, latex, pet dander)");
                mType = "Allergic (Medicine, food, pollen, latex, pet dander)";
                System.out.println("Sickness Name : Medicine allergic");
                sickType = "Medicine allergic";
                break;
            case 3:
                System.out.println("Medicine Type : Food Poisoning");
                mType = "Food Poisoning";
                System.out.println("Sickness Name : Food Poisoning");
                sickType = "Food Poisoning";
                break;
            case 4:
                mType = "Skin Diseases";
                chooseSkinDisease();
                break;
        }
    }
    
            // common illness
    public void chooseCommonIllness() {
        int ciChoice = 0;
        
        System.out.println("Medicine Type : Common Illnesses"  );
        //medicialType = "Common Illnesses";
        do {
            System.out.println("\n");
            System.out.println("\nType of CommonIllnesses");
            System.out.println("--------------------------");
            System.out.println("1. Headaches");
            System.out.println("2. Colds and Flu");
            System.out.println("3. Fever");
            System.out.println("4. Cough");
            System.out.println("5. Stomach Aches");
            System.out.println("6. Diarrhea");
            System.out.println("7. Exit");
            System.out.print("Enter choice(1-7):");
            Scanner cci = new Scanner(System.in);
            ciChoice = cci.nextInt();
            
            switch (ciChoice) {
                case 1:
                    System.out.println("Sickness Name : Headaches");
                    sickType = "Headaches";
                    break;
                case 2:
                    System.out.println("Sickness Name : Colds and Flu");
                    sickType = "Colds and Flu";
                    break;
                case 3:
                    System.out.println("Sickness Name : Fever");
                    sickType = "Fever";
                    break;
                case 4:
                    System.out.println("Sickness Name : Cough");
                    sickType = "Cough";
                    break;
                case 5:
                    System.out.println("Sickness Name : Stomach Aches");
                    sickType = "Stomach Aches";
                    break;
                case 6:
                    System.out.println("Sickness Name : Diarrhea");
                    sickType = "Diarrhea";
                    break;
                case 7:
                    chooseSickType();
                    break;
                default: System.out.println("Please enter 1 to 7 only !!");
            }
        } while (ciChoice < 1 || ciChoice > 7);
    }
    
            // skin disease
    public void chooseSkinDisease() {
        int sdChoice = 0;
        System.out.println("Medicial Type : Skin Diseases");
        do {
            System.out.println("\n");
            System.out.println("\nType of Skin Diseases");
            System.out.println("--------------------------");
            System.out.println("1. Acne");
            System.out.println("2. Atopic dermatitis (eczema)");
            System.out.println("3. Exit");
            System.out.print("Enter choice(1-3):");
            Scanner csd = new Scanner(System.in);
            sdChoice = csd.nextInt();
            
            switch (sdChoice) {
                case 1:
                    System.out.println("Sickness Name : Acne");
                    sickType = "Acne";
                    break;
                case 2:
                    System.out.println("Sickness Name : Atopic dermatitis (eczema)");
                    sickType = "Atopic dermatitis (eczema)";
                    break;
                case 3:
                    chooseSickType();
                    break;
                default: System.out.println("Please enter 1 to 3 only !!");
            }
        } while (sdChoice < 1 || sdChoice > 3);
    }
    
    /*
    *
    * DELETE MEDICINE
    *
    */
    public void deleteMedicine() {
        int deleteBy = 0;
        char again;
        do {
            System.out.println("\n");
            System.out.println("Delete by...");
            System.out.println("[1] Medicial Code");
            System.out.println("[2] Medicial Name");
            System.out.println("[3] Back To The Medicial System ");
            System.out.print("Please pick one:");
            Scanner dScan = new Scanner(System.in);
            deleteBy = dScan.nextInt();
            switch (deleteBy) {
                case 1:
                    System.out.println("Medicial Code (8 digits) : ");
                    Scanner dmc = new Scanner(System.in);
                    String deleteCode = dmc.nextLine();
                    pm.deleteMedicineByCode(deleteCode);
                    System.out.print("Do your wanna do the Delete again (Y/N) :  ");
                Scanner searchAgain = new Scanner(System.in);
                again = searchAgain.next(".").charAt(0);
                if (again == 'Y' || again == 'y') {
                    System.out.println("The System will display the List of Medicial Information !!!");
                    displayDelay();
                    System.out.println("Please Wait a moment............");
                    displayDelay();
                    System.out.println("Our aim: to provide the best service for customers, to find out the cause of the patient");
                    displayDelay();
                    deleteMedicine();
                } else {
                    displayDelay();
                    System.out.println("\nThe system will auto back to the Main menu.");
                    displayDelay();
                    System.out.println("Please be wait awhile, system are going thru.");
                    displayDelay();
                    medicineSystemHome();
                }
                    break;
                case 2:
                    System.out.println("Medicine Name : ");
                    Scanner dmn = new Scanner(System.in);
                    String deleteName = dmn.nextLine();
                    pm.deleteMedicineByName(deleteName);
                    System.out.print("Do your wanna do the Create again (Y/N) :  ");
                Scanner searchAgain2 = new Scanner(System.in);
                again = searchAgain2.next(".").charAt(0);
                if (again == 'Y' || again == 'y') {
                    System.out.println("The System will display the List of Medicial Information !!!");
                    displayDelay();
                    System.out.println("Please Wait a moment............");
                    displayDelay();
                    System.out.println("Our aim: to provide the best service for customers, to find out the cause of the patient");
                    displayDelay();
                    deleteMedicine();
                } else {
                    displayDelay();
                    System.out.println("\nThe system will auto back to the Main menu.");
                    displayDelay();
                    System.out.println("Please be wait awhile, system are going thru.");
                    displayDelay();
                    medicineSystemHome();
                }
                    break;
                case 3: medicineSystemHome(); break;
                default: System.out.println("Please choose 1 to 3 only !!");
            }
        } while (deleteBy != 3);
        medicineSystemHome();
    }
    
    /*
    *
    * RETRIEVE MEDICINE
    *
    */
    private void displayMedicine(){
        char again;
        
        displayDelay();
        System.out.println("The System will display the List of Medicial Information !!!");
        displayDelay();
        System.out.println("Please Wait a moment............");
        displayDelay();
        System.out.println("Our aim: to provide the best service for customers, to find out the cause of the patient");
        displayDelay();
        pm.retrieveAllMedicine();
        System.out.print("Do your wanna do the Display again (Y/N) :  ");
                Scanner searchAgain = new Scanner(System.in);
                again = searchAgain.next(".").charAt(0);
                if (again == 'Y' || again == 'y') {
                    System.out.println("The System will display the List of Medicial Information !!!");
                    displayDelay();
                    System.out.println("Please Wait a moment............");
                    displayDelay();
                    System.out.println("Our aim: to provide the best service for customers, to find out the cause of the patient");
                    displayDelay();
                    displayMedicine();
                } else {
                    displayDelay();
                    System.out.println("\nThe system will auto back to the Main menu.");
                    displayDelay();
                    System.out.println("Please be wait awhile, system are going thru.");
                    displayDelay();
                    medicineSystemHome();
                }
    }
    
    /*
    *
    * EDIT MEDICINE
    *
    */
    public void editMedicine() {
        System.out.print("Which Medicine Code wanna edit: ");
        Scanner c = new Scanner(System.in);
        String code = c.nextLine();
        boolean isExist = pm.searchMedicine(code);
        char again;
        pm.searchMedicineByCode(code);
        
        if (isExist == true) {
            int editBy = 0;
            do {
                System.out.println("\nEditing by...");
                System.out.println("[1] Edit Medicine Code");
                System.out.println("[2] Edit Medicine Name");
                System.out.println("[3] Edit Medicine Type");
                System.out.println("[4] Edit Medicine Price");
                System.out.println("[5] Edit Medicine Description");
                System.out.println("[6] Edit Take Medicine");
                System.out.println("[7] Edit Medicine Inventory");
                System.out.println("[8] Back To The Medicine System");
                System.out.println("Please pick one:");
                Scanner editScan = new Scanner(System.in);
                editBy = editScan.nextInt();
                if (editBy < 1 || editBy > 8) {
                    System.out.println("Please enter 1 to 8 only !!");
                }
                switch (editBy) {
                    case 1: pm.editMedicineByCode(); break;
                    case 2: pm.editMedicineByName(); break;
                    case 3: pm.editMedicineByType(); break;
                    case 4: pm.editMedicineByPrice(); break;
                    case 5: pm.editMedicineByDesc(); break;
                    case 6: pm.editMedicineByTm(); break;
                    case 7: pm.editMedicineByInv(); break;
                    case 8: medicineSystemHome(); break;
                    default: System.out.println("Please enter 1 to 8 only !!");
                }
            } while (editBy < 1 || editBy > 8);
            System.out.print("Do your wanna do the Modify again (Y/N) :  ");
                Scanner searchAgain = new Scanner(System.in);
                again = searchAgain.next(".").charAt(0);
                if (again == 'Y' || again == 'y') {
                    System.out.println("The System will display the List of Medicial Information !!!");
                    displayDelay();
                    System.out.println("Please Wait a moment............");
                    displayDelay();
                    System.out.println("Our aim: to provide the best service for customers, to find out the cause of the patient");
                    displayDelay();
                    editMedicine();
                } else {
                    displayDelay();
                    System.out.println("\nThe system will auto back to the Main menu.");
                    displayDelay();
                    System.out.println("Please be wait awhile, system are going thru.");
                    displayDelay();
                    medicineSystemHome();
                }
        }
    }
    
    /*
    *
    * GENERATE HISTORY 2
    *
    */
    private void generateCheckHistory2(){
        displayDelay();
        System.out.println("The System will display the List of Medicial Information !!!");
        displayDelay();
        System.out.println("Please Wait a moment............");
        displayDelay();
        System.out.println("Our aim: to provide the best service for customers, to find out the cause of the patient");
        displayDelay();
        pm.displayHistory2();
        System.out.print("Press enter to go back... ");
        Scanner goBack = new Scanner(System.in);
        goBack.nextLine();
        medicineSystemHome();
    }
}