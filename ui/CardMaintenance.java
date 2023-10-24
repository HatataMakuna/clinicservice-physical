package ui;
import process.ProcessPaymentSystem;
import entity.*;
import java.beans.EventHandler;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Har Chun Wai
 */
public class CardMaintenance {
    ProcessPaymentSystem pcm = new ProcessPaymentSystem();
    PaymentSystem ps = new PaymentSystem();
    
    String patientID, debitCard, creditCard, ewallet, pin; // for record details
    String nPatientID, nDebitCard, nCreditCard, nEwallet, nPin; // used during modify card
    int noOfCards = 0; // cards counter, for validation purpose
    
    public void start() {
        pcm.addCard(new Card("S001", "1001", "2001", "3001", "5555"));
        pcm.addCard(new Card("S002", "1002", "2002", "3002", "0000"));
        pcm.addCard(new Card("S003", "1003", "2003", "3003", "1234"));
        mainMenu();
    }
    
    public void mainMenu() {
        int cardMenuChoice = 0;
        do {
            System.out.println("++========================================================++");
            System.out.println("||                    CARD MAINTENANCE                    ||");
            System.out.println("++========================================================++");
            System.out.print  ("                        Loading.");
            delay();
            System.out.print(".");
            delay();
            System.out.print(".");
            delay();
            System.out.print(".");
            delay();
            System.out.print(".");
            delay();
            System.out.println("\n\n    [1] Add Card");
            System.out.println("    [2] Modify Card");
            System.out.println("    [3] Retrieve Card");
            System.out.println("    [4] Delete Card");
            System.out.println("    [5] Exit");
            System.out.print("\nYour Choice: ");
            Scanner cardMenu = new Scanner(System.in);
            cardMenuChoice = cardMenu.nextInt();
            
            if (cardMenuChoice < 1 || cardMenuChoice > 5) {
                System.out.println("** Your input is invalid, please try again **");
            } else {
                switch(cardMenuChoice) {
                    case 1: acStart(); break;
                    case 2: mcStart(); break;
                    case 3: retrieveCard(); mainMenu(); break;
                    case 4: deleteCard(); mainMenu(); break;
                    case 5: {
                        System.out.println("Exiting...");
                        delay();
                        //ps.mainMenu();
                        //System.out.println("Exited");
                        break;
                    }
                }
            }
        } while (cardMenuChoice < 1 || cardMenuChoice > 5);
    }
    
    /*
    * 
    *    ** Add Card **
    * 
    */
    public void acStart() {
        System.out.println("++========================================================++");
        System.out.println("||                        ADD CARD                        ||");
        System.out.println("++========================================================++");
        System.out.print  ("                        Loading.");
        delay();
        System.out.print(".");
        delay();
        System.out.print(".");
        delay();
        System.out.print(".");
        delay();
        System.out.print(".\n\n");
        delay();
        addPatientID();
    }
    
    /* Step 1:
    *  Add patient ID
    */
    public void addPatientID() {
        System.out.println("++================++");
        System.out.println("||  STEP  1 OF 3  ||");
        System.out.println("||   PATIENT ID   ||");
        System.out.println("++================++");
        
        boolean patientIsValid = true;
        do {
            System.out.print("  Patient ID: ");
            Scanner patientIDscan = new Scanner(System.in);
            patientID = patientIDscan.nextLine();
            
            if ("".equals(patientID)) {
                // check whether the input patient ID is empty
                System.out.println("** Your patient ID cannot be empty **");
            } else {
                // check whether the input contains at least 4 digits
                if (patientID.length() > 3) {
                    // check whether the input patient ID already exists in the list
                    if (pcm.searchPatient(patientID) == true) {
                        System.out.println("** This patient ID already exists **");
                    } else {
                        patientIsValid = false;
                    }
                } else {
                    System.out.println("** Your patient ID should contain only numbers and at least 4 digits **");
                }
            }
        } while (patientIsValid == true);
        chooseCardType();
    }
    
    /* Step 2:
    *  Add card numbers
    */
    public void chooseCardType() {
        int cardType = 0;
        boolean containCard = false;
        do {
            do {
                System.out.println("++=========================++");
                System.out.println("||       STEP 2 OF 3       ||");
                System.out.println("||  CHOOSE YOUR CARD TYPE  ||");
                System.out.println("++=========================++");
                System.out.println("||                         ||");
                System.out.println("||  [1] Debit card         ||");
                System.out.println("||  [2] Credit card        ||");
                System.out.println("||  [3] E-wallet           ||");
                System.out.println("||  [4] Confirm Details    ||");
                System.out.println("||  [5] Go back            ||");
                System.out.println("||                         ||");
                System.out.println("++=========================++");
                System.out.print  ("    Your choice: ");
                Scanner cardTypescan = new Scanner(System.in);
                cardType = cardTypescan.nextInt();
                if (cardType < 1 || cardType > 5) {
                    System.out.println("** Your input is invalid, please try again **");
                }
            } while (cardType < 1 || cardType > 5);

            switch (cardType) {
                case 1: case 2: case 3: newCardNumber(cardType); break;
                case 4: {
                    if (noOfCards == 0) {
                        System.out.println("** No cards registered. Please make sure you input at least one card **");
                    } else {
                        containCard = true;
                        confirmDetails();
                    }
                    break;
                }
                case 5: {
                    resetVariables();
                    mainMenu();
                    break;
                }
            }
        } while (containCard == false);
    }
    
    public void newCardNumber(int cardType) {
        boolean isValid;
        switch (cardType) {
            case 1: {
                isValid = false;
                do {
                    System.out.print("Debit card number: ");
                    Scanner debitCardscan = new Scanner(System.in);
                    debitCard = debitCardscan.nextLine();
                    if ("".equals(debitCard)) {
                        System.out.println("** Your debit card number cannot be empty **");
                    } else {
                        if (debitCard.matches("[0-9]+") && debitCard.length() > 3) {
                            noOfCards++;
                            System.out.println("** Successfully added debit card number **\n");
                            isValid = true;
                            chooseCardType(); // back to choose card type menu
                        } else {
                            System.out.println("** Your debit card number should contain only numbers and at least 4 digits **");
                        }
                    }
                } while (isValid == false);
                break;
            }
            case 2: {
                isValid = false;
                do {
                    System.out.print("Credit card number: ");
                    Scanner creditCardscan = new Scanner(System.in);
                    creditCard = creditCardscan.nextLine();
                    if ("".equals(creditCard)) {
                        System.out.println("** Your credit card number cannot be empty **");
                    } else {
                        if (creditCard.matches("[0-9]+") && creditCard.length() > 3) {
                            noOfCards++;
                            isValid = true;
                            System.out.println("** Successfully added credit card number **\n");
                            chooseCardType(); // back to choose card type menu
                        } else {
                            System.out.println("** Your credit card number should contain only numbers and at least 4 digits **");
                        }
                    }
                } while (isValid == false);
                break;
            }
            case 3: {
                isValid = false;
                do {
                    System.out.print("E-wallet number: ");
                    Scanner ewalletscan = new Scanner(System.in);
                    ewallet = ewalletscan.nextLine();
                    if ("".equals(ewallet)) {
                        System.out.println("** Your e-wallet number cannot be empty **");
                    } else {
                        if (ewallet.matches("[0-9]+") && ewallet.length() > 3) {
                            noOfCards++;
                            isValid = true;
                            System.out.println("** Successfully added e-wallet number **\n");
                            chooseCardType(); // back to choose card type menu
                        } else {
                            System.out.println("** Your e-wallet number should contain only numbers and at least 4 digits **");
                        }
                    }
                } while (isValid == false);
                break;
            }
        }
    }
    
    public void confirmDetails() {
        System.out.println("** Confirm your details before proceeding **");
        System.out.println("Debit card number  : " + debitCard);
        System.out.println("Credit card number : " + creditCard);
        System.out.println("E-wallet number    : " + ewallet);
        System.out.print("\nY/N                : ");
        Scanner confirmDetailsscan = new Scanner(System.in);
        char confirm = confirmDetailsscan.next(".").charAt(0);
        if (confirm == 'Y' || confirm == 'y') {
            pinNumber();
        } else {
            resetVariables();
            System.out.println("Cancelled. Go back to...");
            System.out.println("[Y]   Select card type");
            System.out.println("[N]   Main menu");
            System.out.print  ("[Y/N] ");
            Scanner gbCardTypescan = new Scanner(System.in);
            char gbCardType = gbCardTypescan.next(".").charAt(0);
            if (gbCardType == 'Y' || gbCardType == 'y') {
                chooseCardType();
            } else {
                mainMenu();
            }
        }
    }
    
    /* Step 3:
    *  Add PIN number
    */
    public void pinNumber() {
        System.out.println("++================++");
        System.out.println("||  STEP  3 OF 3  ||");
        System.out.println("||   PIN NUMBER   ||");
        System.out.println("++================++");
        
        boolean matchPin = false;
        do {
            boolean pinIsValid = false; // PIN number is empty
            do {
                System.out.print("  PIN number: ");
                Scanner pinscan = new Scanner(System.in);
                pin = pinscan.nextLine();
                if ("".equals(pin)) {
                    // check whether the input PIN number is empty
                    System.out.println("** Your PIN number cannot be empty **");
                } else {
                    if (pin.matches("[0-9]+") && pin.length() > 3) {
                        pinIsValid = true;
                    } else {
                        System.out.println("** Your PIN number should contain only numbers and at least 4 digits **");
                    }
                }
            } while (pinIsValid == false);
            
            boolean confirmPinIsEmpty = true;
            do {
                System.out.print("  Repeat PIN number: ");
                Scanner confirmpinscan = new Scanner(System.in);
                String confirmpin = confirmpinscan.nextLine();
                if ("".equals(confirmpin)) {
                    // check whether the input PIN number is empty
                    System.out.println("** Your PIN number cannot be empty **");
                } else {
                    // check whether pin and confirmpin matches
                    if (!confirmpin.equals(pin)) {
                        System.out.println("\n** Your PIN number does not match repeat PIN number **\n");
                    } else {
                        // if matches, stop the matchPin loop
                        confirmPinIsEmpty = false;
                        matchPin = true;
                    }
                }
            } while (confirmPinIsEmpty == true);
        } while (matchPin == false);
        if (matchPin == true) {
            confirm();
        }
    }
    
    /* Step 4:
    *  Confirmation
    */
    public void confirm() {
        Card c = new Card(patientID, debitCard, creditCard, ewallet, pin);
        System.out.println("Patient ID         : " + patientID);
        System.out.println("Debit Card number  : " + debitCard);
        System.out.println("Credit Card number : " + creditCard);
        System.out.println("E-wallet number    : " + ewallet);
        System.out.println("PIN number         : " + pin);
        System.out.println("Are you sure you want to add this into card list (Y/N)? ");
        Scanner confirmAddscan = new Scanner(System.in);
        char confirmAdd = confirmAddscan.next(".").charAt(0);
        if (confirmAdd == 'y' || confirmAdd == 'Y') {
            pcm.addCard(c);
            System.out.println("** Your card has been added successfully **");
        } else {
            System.out.println("** Cancelled **");
        }
        resetVariables();
        System.out.print("Would you like to add more (Y/N)? ");
        Scanner addMorescan = new Scanner(System.in);
        char addMore = addMorescan.next(".").charAt(0);
        if (addMore == 'y' || addMore == 'Y') {
            acStart();
        } 
        else {
            mainMenu();
        }
    }
    
    /*
    * 
    *    ** Modify Card **
    * 
    */
    public void mcStart() {
        System.out.println("++========================================================++");
        System.out.println("||                      MODIFY  CARD                      ||");
        System.out.println("++========================================================++");
        System.out.print  ("                        Loading.");
        delay();
        System.out.print(".");
        delay();
        System.out.print(".");
        delay();
        System.out.print(".");
        delay();
        System.out.print(".\n\n");
        delay();
        mSearchPatient();
    }
    
    public void mSearchPatient() {
        boolean isExist = false;
        char searchAgain = 'Y';
        do {
            System.out.println("++==================++");
            System.out.println("||      STEP 1      ||");
            System.out.println("||  SEARCH PATIENT  ||");
            System.out.println("++==================++");
            System.out.print("Which patient ID you would like to modify? ");
            Scanner searchPatientscan = new Scanner(System.in);
            patientID = searchPatientscan.nextLine();
            isExist = pcm.searchPatient(patientID);
            if (isExist == false) {
                System.out.println("** This patient ID does not exist **");
                System.out.print("Would you like to search again? ");
                Scanner searchAgainscan = new Scanner(System.in);
                searchAgain = searchAgainscan.next(".").charAt(0);
            } else {
                searchAgain = 'n';
                isExist = true;
                editCardMenu();
            }
        } while (searchAgain == 'Y' || searchAgain == 'y');
        if (searchAgain == 'n' || searchAgain == 'N') {
            mainMenu();
        }
    }
    
    public void editCardMenu() {
        //String patientID, nDebitCard, nCreditCard, nEwallet, nPin;
        // get the card details
        Card c = pcm.getCard(patientID);
        
        int editCategory = 0;
        do {
            System.out.println("++==========================================++");
            System.out.println("||                  STEP 2                  ||");
            System.out.println("||               EDIT PATIENT               ||");
            System.out.println("++==========================================++");
            System.out.println("    [1] Patient ID");
            System.out.println("    [2] Debit card");
            System.out.println("    [3] Credit card");
            System.out.println("    [4] E-wallet");
            System.out.println("    [5] PIN number");
            System.out.println("    [6] Save details");
            System.out.println("    [7] Cancel");
            System.out.print("\n  Choose a category you would like to edit: ");
            Scanner editCategoryscan = new Scanner(System.in);
            editCategory = editCategoryscan.nextInt();
            if (editCategory < 1 || editCategory > 7) {
                System.out.println("** Your input is invalid, please try again **");
            }
            
            switch (editCategory) {
                case 1: editPatientID(c); break;
                case 2: case 3: case 4: editCardNumber(editCategory, c); break;
                case 5: editPin(c); break;
                case 6: confirmEdit(c); break;
                case 7: resetVariables(); break; // go back break;
            }
        } while (editCategory < 1 || editCategory > 7);
    }
    
    public void editPatientID(Card c) {
        System.out.println("Your current patient ID: " + c.getPatientID());
        System.out.print("Your new patient ID (leave it empty if no changes): ");
        Scanner nPatientIDscan = new Scanner(System.in);
        nPatientID = nPatientIDscan.nextLine();
        
        if ("".equals(nPatientID)) {
            System.out.println("** Your new patient ID has no changes **");
            System.out.println("** Current patient ID: " + c.getPatientID() + " **");
        } else {
            c.setPatientID(nPatientID);
            System.out.println("** Your new patient ID: " + c.getPatientID() + " **");
        }
        editCardMenu();
    }
    
    public void editCardNumber(int cardType, Card c) {
        boolean isValid;
        switch (cardType) {
            case 2: {
                isValid = false;
                do {
                    if ("".equals(c.getDebitCard())) {
                        System.out.println("You don't have a debit card number.");
                    } else {
                        System.out.println("Your current debit card number: " + c.getDebitCard());
                    }
                    System.out.print("Your new debit card number (leave it empty if no changse): ");
                    Scanner nDebitCardscan = new Scanner(System.in);
                    nDebitCard = nDebitCardscan.nextLine();
                    if ("".equals(nDebitCard)) {
                        isValid = true;
                        System.out.println("** Your new debit card number has no changes **");
                        System.out.println("** Current debit card number: " + c.getDebitCard() + " **");
                    } else {
                        if (nDebitCard.matches("[0-9]+") && nDebitCard.length() > 3) {
                            isValid = true;
                            c.setDebitCard(nDebitCard);
                            System.out.println("** Your new debit card number: " + c.getDebitCard() + " **");
                            editCardMenu();
                        } else {
                            System.out.println("** Your debit card number should contain only numbers and at least 4 digits **");
                        }
                    }
                } while (isValid == false);
                break;
            }
            case 3: {
                isValid = false;
                do {
                    if ("".equals(c.getCreditCard())) {
                        System.out.println("You don't have a credit card number.");
                    } else {
                        System.out.println("Your current credit card number: " + c.getCreditCard());
                    }
                    System.out.print("Your new credit card number (leave it empty if no changse): ");
                    Scanner nCreditCardscan = new Scanner(System.in);
                    nCreditCard = nCreditCardscan.nextLine();
                    if ("".equals(nCreditCard)) {
                        isValid = true;
                        System.out.println("** Your new credit card number has no changes **");
                        System.out.println("** Current credit card number: " + c.getCreditCard() + " **");
                    } else {
                        if (nCreditCard.matches("[0-9]+") && nCreditCard.length() > 3) {
                            isValid = true;
                            c.setCreditCard(nCreditCard);
                            System.out.println("** Your new credit card number: " + c.getCreditCard() + " **");
                            editCardMenu();
                        } else {
                            System.out.println("** Your credit card number should contain only numbers and at least 4 digits **");
                        }
                    }
                } while (isValid == false);
                break;
            }
            case 4: {
                isValid = false;
                do {
                    if ("".equals(c.getEwallet())) {
                        System.out.println("You don't have an e-wallet number.");
                    } else {
                        System.out.println("Your current e-wallet number: " + c.getEwallet());
                    }
                    System.out.print("Your new e-wallet number (leave it empty if no changse): ");
                    Scanner nEwalletscan = new Scanner(System.in);
                    nEwallet = nEwalletscan.nextLine();
                    if ("".equals(nEwallet)) {
                        isValid = true;
                        System.out.println("** Your new e-wallet number has no changes **");
                        System.out.println("** Current e-wallet number: " + c.getEwallet() + " **");
                    } else {
                        if (nEwallet.matches("[0-9]+") && nEwallet.length() > 3) {
                            isValid = true;
                            c.setEwallet(nEwallet);
                            System.out.println("** Your new e-wallet number: " + c.getEwallet() + " **");
                            editCardMenu();
                        } else {
                            System.out.println("** Your e-wallet number should contain only numbers and at least 4 digits **");
                        }
                    }
                } while (isValid == false);
                break;
            }
        }
    }
    
    public void editPin(Card c) {
        boolean matchPin = false;
        do {
            System.out.print("New PIN number: ");
            Scanner pinscan = new Scanner(System.in);
            nPin = pinscan.nextLine();
            // missing validate

            System.out.print("Repeat PIN number: ");
            Scanner confirmpinscan = new Scanner(System.in);
            String confirmpin = confirmpinscan.nextLine();
            // missing validate

            if (!confirmpin.equals(nPin)) {
                System.out.println("\n** Your PIN number does not match repeat PIN number **\n");
            } else {
                c.setPin(nPin);
                matchPin = true;
            }
        } while (matchPin = false);
        c.setPin(nPin);
        System.out.println("** Successfully changed your new PIN number **");
        editCardMenu();
    }
    
    public void confirmEdit(Card c) {
        System.out.println(c.toString());
        System.out.print("Are you sure you want to save your changes (Y/N)? ");
        Scanner saveChangesscan = new Scanner(System.in);
        char saveChanges = saveChangesscan.next(".").charAt(0);
        System.out.println(saveChanges);
        if (saveChanges == 'y' || saveChanges == 'Y') {
            pcm.modifyCard(patientID, c);
            System.out.println("** Changes saved **");
        } else {
            System.out.println("** Cancelled **");
        }
        resetVariables();
        System.out.print("Would you like to modify another card (Y/N)? ");
        Scanner modifyAgainscan = new Scanner(System.in);
        char modifyAgain = modifyAgainscan.next(".").charAt(0);
        if (modifyAgain == 'Y' || modifyAgain == 'y') {
            mcStart();
        } else {
            mainMenu();
        }
    }
    
    /*
    * 
    *    ** Retrieve Card **
    * 
    */
    public void retrieveCard() {
        pcm.retrieveCard();
    }
    
    /*
    * 
    *    ** Delete Card **
    * 
    */
    public void deleteCard() {
        boolean isExist = false;
        do {
            System.out.print("Which patient ID you would like to delete? ");
            Scanner searchPatientscan = new Scanner(System.in);
            patientID = searchPatientscan.nextLine();
            isExist = pcm.searchPatient(patientID);
            if (isExist == false) {
                System.out.println("** This patient ID does not exist **");
            } else {
                pcm.deleteCard(patientID);
            }
        } while (isExist == false);
    }
    
    /*
    * 
    *    ** Other features **
    * 
    */
    /*
    *  Reset all variables
    */
    public void resetVariables() {
        // core variables
        patientID = "";
        debitCard = "";
        creditCard = "";
        ewallet = "";
        pin = "";
        
        // card counter
        noOfCards = 0;
        
        // modify card variables
        nPatientID = "";
        nDebitCard = "";
        nCreditCard = "";
        nEwallet = "";
        nPin = "";
    }

    /*
    *  Output sleep for 0.5 seconds
    */
    private void delay(){
        try {
            TimeUnit.MILLISECONDS.sleep(500);
        } catch (InterruptedException ex) {
            Logger.getLogger(EventHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /*
    * 
    *    ** Main method for testing purpose **
    * 
    */
    public static void main(String[] args) {
        CardMaintenance cm = new CardMaintenance();
        cm.start();
        //cm.mainMenu();
    }
}