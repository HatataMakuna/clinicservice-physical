package process;
import adt.*;
import entity.*;

import java.util.Scanner;

/**
 *
 * @author Har Chun Wai
 */

// display information for customer (debit and credit)
// card maintenance: add, modify, retrieve, delete
public class ProcessPaymentSystem {
    ListInterface<Card> card = new ArrayList<>();
    ListInterface<Medicine> ml = new ArrayList<>();
    
    double totalCost = 0.00;
    
    public void start() {
        // add card and medicine list
        card.add(new Card("S001", "1001", "2001", "3001", "1111"));
        card.add(new Card("A001", "1002", "2003", "3004", "1234"));
        
        ml.add(new Medicine("Colds and Flu", 5, 10.00));
        ml.add(new Medicine("Atopic dermatitis (eczema)", 10, 15.00));
        ml.add(new Medicine("Food poisoning", 3, 20.00));
    }
    
    /*
    * 
    * CARD MAINTENANCE
    * 
    */
    // add card
    public void addCard(Card c) {
        card.add(c);
    }
    
    // retrieve card
    public void retrieveCard() {
        System.out.println("================================================================================");
        System.out.println("+                                 LIST OF CARDS                                +");
        System.out.println("================================================================================");
        System.out.println(" Patient ID      Debit card no.      Credit card no.     E-wallet no.     PIN");
        for (int i = 1; i <= card.getNumberOfEntries(); i++) {
            System.out.printf(" %-15s %-19s %-19s %-16s %s\n", card.getEntry(i).getPatientID(), card.getEntry(i).getDebitCard()
                                                , card.getEntry(i).getCreditCard(), card.getEntry(i).getEwallet()
                                                , card.getEntry(i).getPin());
        }
    }
    
    // modify card
    public void modifyCard(String patientID, Card c) {
        int toModify = 0;
        for (int i = 1; i <= card.getNumberOfEntries(); i++) {
            if (card.getEntry(i).getPatientID().equals(patientID)) {
                toModify = i;
            }
        }
        card.replace(toModify, c);
    }
    
    // delete card
    public void deleteCard(String patientID) {
        // Note: check whether the patient ID exist is already been performed in deleteCard method in CardMaintenance
        int idToDelete = 0;
        char confirm;
        for (int i = 1; i <= card.getNumberOfEntries(); i++) {
            if (card.getEntry(i).getPatientID().equals(patientID)) {
                System.out.println(card.getEntry(i));
                System.out.print("Are you sure you want to delete this record (Y/N)? ");
                Scanner confirmDelete = new Scanner(System.in);
                confirm = confirmDelete.next(".").charAt(0);
                if (confirm == 'Y' || confirm == 'y') {
                    idToDelete = i;
                    card.remove(idToDelete);
                    System.out.println("** Deleted successfully **");
                }
            }
        }
    }
    
    // pin validation
    public boolean checkPin(Card c, String enterPin) {
        if (enterPin.equals(c.getPin())) {
            System.out.println("OK!");
            return true;
        } else {
            System.out.println("Your PIN number is invalid, please try again");
            return false;
        }
    }
    
    public boolean searchPatient(String patientID) {
        for (int i = 1; i <= card.getNumberOfEntries(); i++) {
            if (card.getEntry(i).getPatientID().equals(patientID)) {
                return true;
            }
        }
        return false;
    }
    
    // get card
    public Card getCard(String patientID) {
        Card c = new Card();
        for (int i = 1; i <= card.getNumberOfEntries(); i++) {
            if (card.getEntry(i).getPatientID().equals(patientID)) {
                c = new Card(patientID, card.getEntry(i).getCreditCard(),
                        card.getEntry(i).getDebitCard(), card.getEntry(i).getEwallet(),
                        card.getEntry(i).getPin());
            }
        }
        return c;
    }
    
    /*
    * 
    * MEDICINE LIST
    * 
    */
    public void addMedicineList(Medicine m) {
        ml.add(m);
    }
    
    public void retrieveMedicineList() {
        for (int i = 1; i <= ml.getNumberOfEntries(); i++) {
            //System.out.println(medicineList.getEntry(i).getMedicineName());
            if (ml.getEntry(i).getCostPerMedicine() < 10) {
                System.out.printf("  %-30s   %5d            %.2f           %.2f\n",
                    ml.getEntry(i).getMedicineName(), ml.getEntry(i).getNumber(),
                    ml.getEntry(i).getCostPerMedicine(), ml.getEntry(i).getCost());
            } else {
                System.out.printf("  %-30s   %5d            %.2f          %.2f\n",
                        ml.getEntry(i).getMedicineName(), ml.getEntry(i).getNumber(),
                        ml.getEntry(i).getCostPerMedicine(), ml.getEntry(i).getCost());
            }
        }
    }
    
    public double calculateTotalCost() {
        for (int i = 1; i <= ml.getNumberOfEntries(); i++) {
            totalCost += ml.getEntry(i).getCost();
        }
        return totalCost;
    }
    
    // reset all medicine cost (when user choose not to pay medicine)
    public void resetMedicineCost() {
        for (int i = 1; i <= ml.getNumberOfEntries(); i++) {
            ml.getEntry(i).setCostPerMedicine(0); // change the cost per medicine to 0.00
        }
    }
    
    // reset total cost
    public void resetCalculation() {
        totalCost = 0.00;
    }
    
    // after payment success, clear medicineList
    public void clearList() {
        ml.clear();
    }
    
    public static void main(String[] args) {
        ProcessPaymentSystem cm = new ProcessPaymentSystem();
        cm.start();
        cm.retrieveCard();
    }
}
