package ui;
import process.ProcessPaymentSystem;
import java.util.Scanner;
import process.*;
import entity.*;
import java.beans.EventHandler;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;

/**
 *
 * @author Har Chun Wai
 */

public class PaymentSystem {
    ProcessPaymentSystem pps = new ProcessPaymentSystem();
    
    Card c;
    int paymentMethodChoice;
    boolean isConsult = false;
    double totalCost;
    
//    public void mainMenu() {
//        CardMaintenance cm = new CardMaintenance();
//        //FirstRegister fr = new FirstRegister();
//        
//        int payment = 0;
//        do {
//            System.out.println("=========================");
//            System.out.println("+        PAYMENT        +");
//            System.out.println("=========================");
//            System.out.println("| [1] Card maintenance  |");
//            System.out.println("| [2] Make payment      |");
//            System.out.println("| [3] Exit              |");
//            System.out.println("=========================");
//            System.out.print("\nYour choice: ");
//            Scanner menu = new Scanner(System.in);
//            payment = menu.nextInt();
//            if (payment < 1 || payment > 3) {
//                System.out.println("Please enter 1 to 3 only !!");
//            }
//        } while (payment < 1 || payment > 3);
//        switch (payment) {
//            case 1: cm.start(); break;
//            case 2: add(); break;
//            default: System.out.println("Exiting...\nExited!");//fr.optionPage();
//        }
//    }
    
    public void start() {
        pps.addCard(new Card("S001", "1001", "2001", "3001", "5555"));
        pps.addCard(new Card("S002", "1002", "2002", "3002", "0000"));
        pps.addCard(new Card("S003", null, "2003", null, "1234"));
        
        pps.addMedicineList(new Medicine("Colds and Flu", 5, 10.00));
        pps.addMedicineList(new Medicine("Atopic dermatitis (eczema)", 10, 15.00));
        pps.addMedicineList(new Medicine("Food poisoning", 3, 20.00));
        //pps.start();
        mlStart();
    }
    
    public void mlStart() {
        System.out.print("Retrieving medicine list");
        delay();
        System.out.print(".");
        delay();
        System.out.print(".");
        delay();
        System.out.print(".");
        delay();
        System.out.print(".");
        delay();
        System.out.print(".");
        delay();
        System.out.println("\n\n++==============================================================================++");
        System.out.println("||                                MEDICINE  LIST                                ||");
        System.out.println("++==============================================================================++");
        System.out.printf("   Name%30sAmount%5sCost per unit%2sTotal Cost (RM)\n", "", "", "");
        pps.retrieveMedicineList();
        totalCost = pps.calculateTotalCost();
        medicineList();
        consult();
        /* Testing: add the payment details to queue, after staff call then proceed to choose payment method
        Payment p = new Payment(patientID, paymentType, totalCost);
        */
    }
    
    public void medicineList() {
        System.out.printf("%66s", "");
        System.out.println("=========");
        System.out.printf("  TOTAL%60s%.2f\n", "", totalCost);
        System.out.printf("%66s", "");
        System.out.println("=========");
    }
    
    public void consult() {
        // got consult doctor or not??
        System.out.print("Is the patient got consult doctor or not (Y/N)? ");
        Scanner consultScan = new Scanner(System.in);
        char consult = consultScan.next(".").charAt(0);
        if (consult == 'y' || consult == 'Y') {
            isConsult = true;
            totalCost += 50;
            System.out.printf("Your new total price: RM %.2f\n\n", totalCost);
            medicineFee();
        } else {
            isConsult = false;
        }
        selectPatient();
    }
    
    // whether medicine fee needed to be paid by patient or not
    public void medicineFee() {
        System.out.print("Do you want to pay the medicines (Y/N)? ");
        Scanner medicineScan = new Scanner(System.in);
        char medicine = medicineScan.next(".").charAt(0);
        if (medicine != 'y' && medicine != 'Y') {
            // nullify all medicine cost
            pps.resetMedicineCost();
            totalCost = 50; // the total cost only include the consultation fee, which is RM 50.00
        }
    }
    
    public void selectPatient() {
        boolean isExist = false;
        int noTries = 0;
        do {
            System.out.print("Select your patient ID: ");
            Scanner search = new Scanner(System.in);
            String pid = search.nextLine();
            if (pps.searchPatient(pid) == true) {
                c = pps.getCard(pid);
                noTries = 4;
                chooseMethod();
            } else {
                System.out.println("** This patient ID does not exist !! **");
                noTries++;
            }
        } while (isExist == false && noTries < 3);
        if (noTries > 2 && noTries != 4) {
            System.out.println("** You have no more tries !! **");
            System.out.println("** The system is going back to main menu **\n");
            //mainMenu();
        }
    }
    
    public void chooseMethod() {
        paymentMethodChoice = 0;
        boolean isExist = false;
        do {
            System.out.println("++========================================================++");
            System.out.println("||                CHOOSE A PAYMENT METHOD                 ||");
            System.out.println("++========================================================++");
            System.out.println("     1) Debit Card");
            System.out.println("     2) Credit Card");
            System.out.println("     3) E-wallet");
            System.out.print("\nYour choice (1-3): ");
            Scanner paymentMethodScan = new Scanner(System.in);
            paymentMethodChoice = paymentMethodScan.nextInt();
            if (paymentMethodChoice < 1 || paymentMethodChoice > 3) {
                System.out.println("** Please enter 1 to 3 only !! **");
            } else {
                if (checkCard(paymentMethodChoice) == true) {
                    isExist = true;
                    enterPin();
                } else {
                    System.out.print("** You don't have a/an ");
                    switch (paymentMethodChoice) {
                        case 1: System.out.print("debit card !! **\n\n"); break;
                        case 2: System.out.print("credit card !! **\n\n"); break;
                        case 3: System.out.print("e-wallet !! **\n\n"); break;
                    }
                }
            }
        } while (paymentMethodChoice < 1 || paymentMethodChoice > 3 || isExist == false);
    }
    
    // check card whether is valid or not
    public boolean checkCard(int pmChoice) {
        switch (pmChoice) {
            case 1: return c.getDebitCard() != null;
            case 2: return c.getCreditCard() != null;
            case 3: return c.getEwallet() != null;
            default: return false;
        }
    }
    
    public void enterPin() {
        int tries = 3;
        boolean validPin = false, isNoAttempts = false;
        do {
            System.out.print("Enter PIN number: ");
            Scanner pinScan = new Scanner(System.in);
            String pin = pinScan.nextLine();
            ProcessPaymentSystem cm = new ProcessPaymentSystem();
            validPin = cm.checkPin(c, pin);
            if (validPin == false) {
                System.out.println("** Your PIN is invalid, please try again **");
                tries--;
                System.out.println("** Remaining attempts: " + tries + " **");
                if (tries == 0) {
                    System.out.println("** You have no more attempts **");
                    validPin = true; // stop the loop
                    isNoAttempts = true;
                    // go back
                }
            }
        } while (validPin == false);
        if (isNoAttempts == false) {
            System.out.print("Waiting for payment");
            delay();
            System.out.print(".");
            delay();
            System.out.print(".");
            delay();
            System.out.print(".");
            delay();
            System.out.print("\nProcessing your payment");
            delay();
            System.out.print(".");
            delay();
            System.out.print(".");
            delay();
            System.out.print(".");
            delay();
            System.out.println("\nPayment successful");
            System.out.print("Do you want to generate a receipt (Y/N): ");
            Scanner receiptScan = new Scanner(System.in);
            char receipt = receiptScan.next(".").charAt(0);
            if (receipt == 'y' || receipt == 'Y') {
                receipt();
            } else {
                System.out.println("Thank you for visiting...");
            }
            pps.clearList();
        }
    }
    // end payment
    
    // generate receipt
    public void receipt() {
        System.out.print("\nGenerating receipt");
        delay();
        System.out.print(".");
        delay();
        System.out.print(".");
        delay();
        System.out.print(".");
        
        System.out.println("\n\n++===========================================================================++");
        System.out.println("||                            Clinic  Nee Mei Yi                             ||");
        System.out.println("||                                 RECEIPT                                   ||");
        System.out.println("++===========================================================================++");
        System.out.println("            No. 26, Jalan Genting Klang, Setapak, 53000 Kuala Lumpur");
        
        // patient name, type: 'consult' or 'pick up'
        System.out.println("  Patient ID     : " + c.getPatientID());
        System.out.print  ("  Payment Method : ");
        switch (paymentMethodChoice) {
            case 1: System.out.print("Debit Card\n"); break;
            case 2: System.out.print("Credit Card\n"); break;
            case 3: System.out.print("E-wallet\n"); break;
        }
        // time
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
        LocalDateTime now = LocalDateTime.now();
        System.out.println("  Time           : " + dtf.format(now) + "\n");
        
        System.out.printf("  Name%30sAmount%5sCost per unit%2sTotal Cost (RM)\n", "", "", "");
        if (isConsult == true) {
            System.out.printf("  Consultation%53s50.00\n\n", "");
        }
        pps.retrieveMedicineList();
        
        System.out.printf ("\n  TOTAL%60s%.2f\n", "", totalCost);
        System.out.printf ("  PAID%61s%.2f\n", "", totalCost);
        System.out.printf ("  CHANGE%59s0.00\n", "");
        System.out.println("                           THANK YOU FOR VISITING");
        System.out.println("++============================================================================++");
        System.out.print  ("\n\nPress enter to go back...");
        Scanner goBack = new Scanner(System.in);
        goBack.nextLine();
        //mainMenu(); // back to main menu
    }
    // end generate receipt
    
    private void delay(){
        try {
            TimeUnit.MILLISECONDS.sleep(500);
        } catch (InterruptedException ex) {
            Logger.getLogger(EventHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void main(String args[]) {
        PaymentSystem ps = new PaymentSystem();
        ps.start();
        //ProcessPaymentSystem pcm = new ProcessPaymentSystem();
        //ps.mainMenu();
    }
}