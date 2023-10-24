/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ui;
import java.util.Scanner;
/**
 *
 * @author Har Chun Wai
 */
public class main {
    FirstRegister fr = new FirstRegister();
    SickDetailDriver sdd = new SickDetailDriver();
    medicineSystem ms = new medicineSystem();
    pickUpMedicine pum = new pickUpMedicine();
    CardMaintenance cm = new CardMaintenance();
    PaymentSystem ps = new PaymentSystem();
    
    public void menu() {
        int choice = 0;
        do {
            System.out.println("=============");
            System.out.println("     MENU");
            System.out.println("=============");
            System.out.println("[1] First Register");
            System.out.println("[2] Generate tracking number");
            System.out.println("[3] Medicine system");
            System.out.println("[4] Pick up medicine");
            System.out.println("[5] Card maintenance");
            System.out.println("[6] Payment system");
            System.out.println("[7] Exit");
            System.out.print  ("Your choice (1-7): ");
            Scanner menu = new Scanner(System.in);
            choice = menu.nextInt();
            if (choice < 1 || choice > 7) {
                System.out.println("** Please enter 1 to 7 only !!");
            }
        } while (choice < 1 || choice > 7);
        choose(choice);
    }
    
    public void choose(int choice) {
        switch (choice) {
            case 1: fr.welcome(); break;
            case 2: sdd.patientData(); break;
            case 3: ms.msStart(); break;
            case 4: pum.start(); break;
            case 5: cm.start(); break;
            case 6: ps.start(); break;
            case 7: System.out.println("Exiting..."); break;
            default: break;
        }
        if (choice != 7) {
            menu(); // go back to menu
        }
    }
    
    public static void main(String[] args) {
        main m = new main();
        m.menu();
    }
}