/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import entity.*;
import process.*;
import java.util.Scanner;

/**
 *
 * @author Cheng Cai Jie
 * 
 */
public class FirstRegister {
    ProcessFirstRegister pfr = new ProcessFirstRegister();
    PatientProfile pp;
    
    public static void main(String[] main) {
        FirstRegister fr = new FirstRegister();
        fr.welcome();
    }
    
    public void welcome() {
        pfr.start();
        int loginOrRegister;

        do {
            System.out.print(PrintColor.BLUE_BOLD);
            System.out.printf("%100s+-------------------------------------------------------+\n", "");
            System.out.print(PrintColor.BLUE_BOLD);
            System.out.printf("%100s|              Welcome to Clinic RSF2                   |\n", "");;
            System.out.print(PrintColor.BLUE_BOLD);
            System.out.printf("%100s+-------------------------------------------------------+\n\n", "");
            System.out.print(PrintColor.PURPLE_BOLD);
            System.out.printf("%100s                  Are you a new user ?? \n\n", "");
            System.out.print(PrintColor.PURPLE_BOLD);
            System.out.printf("%100s                (1.No / 2. Yes / 0.Exit) -> ", "");
            Scanner lorScan = new Scanner(System.in);
            loginOrRegister = lorScan.nextInt();

            switch (loginOrRegister) {
                case 1:
                    login();
                    break;

                case 2:
                    signUp();
                    break;

                case 0:
                    System.out.println("\n\n");
                    System.out.print(PrintColor.CYAN);
                    System.out.printf("%100s                      Thanks for VISITING!!!\n\n", "");
                    break;

                default:
                    System.out.println("\n");
                    System.out.print(PrintColor.RED_BOLD);
                    System.out.printf("%100s+-------------------------------------------------------+\n", "");
                    System.out.print(PrintColor.RED_BOLD);
                    System.out.printf("%100s|          Please enter either 0 , 1 or 2 only !!!      |\n", "");
                    System.out.print(PrintColor.RED_BOLD);
                    System.out.printf("%100s+-------------------------------------------------------+\n\n\n", "");
                    System.out.print(PrintColor.RESET);
                    break;
            }
        } while (loginOrRegister > 2 || loginOrRegister < 0);
    }

    public void login() {
        String id, password;
        int loginTime = 0;
        boolean isSuccess = false;

        do {
            System.out.println("\n");
            System.out.print(PrintColor.BLUE_BOLD);
            System.out.printf("%100s+-------------------------------------------------------+\n", "");
            System.out.print(PrintColor.BLUE_BOLD);
            System.out.printf("%100s|                          LOGIN                        |\n", "");
            System.out.print(PrintColor.BLUE_BOLD);
            System.out.printf("%100s+-------------------------------------------------------+\n\n", "");
            System.out.print(PrintColor.PURPLE_BOLD);
            System.out.printf("%100s                Please enter Your ID    : ", "");
            Scanner idScan = new Scanner(System.in);
            id = idScan.nextLine();
            System.out.print(PrintColor.PURPLE_BOLD);
            System.out.printf("%100s                Please enter Password   : ", "");
            Scanner passwordScan = new Scanner(System.in);
            password = passwordScan.nextLine();
            isSuccess = pfr.loggingIn(id, password);
            
            if (isSuccess == false) {
                System.out.println("\n\n");
                System.out.print(PrintColor.RED_BOLD);
                System.out.printf("%100s+-------------------------------------------------------+\n", "");
                System.out.print(PrintColor.RED_BOLD);
                System.out.printf("%100s|    There Something Wrong with Your ID or Password !!  |\n", "");
                System.out.print(PrintColor.RED_BOLD);
                System.out.printf("%100s|                   Please try again !!                 |\n", "");
                System.out.print(PrintColor.RED_BOLD);
                System.out.printf("%100s+-------------------------------------------------------+\n\n", "");
                System.out.print(PrintColor.RESET);
                loginTime++;
            } else {
                System.out.println("\n\n");
                System.out.print(PrintColor.CYAN);
                System.out.printf("%100s                         Welcome !!!!!    \n\n", "");
                loginTime = 0;
                optionPage();
            }
        } while (isSuccess == false && loginTime < 3);
        
        // if user try to login 3 times but still not valid
        if (loginTime == 3) {
            System.out.print(PrintColor.RED_BOLD);
            System.out.printf("%100s+-------------------------------------------------------+\n", "");
            System.out.print(PrintColor.RED_BOLD);
            System.out.printf("%100s| - You have enter 3 times wrong User ID or Password!! -|\n", "");
            System.out.print(PrintColor.RED_BOLD);
            System.out.printf("%100s+-------------------------------------------------------+\n\n", "");
            System.out.print(PrintColor.RESET);

            System.out.print(PrintColor.RED_BOLD);
            System.out.printf("%100s+-------------------------------------------------------+\n", "");
            System.out.print(PrintColor.RED_BOLD);
            System.out.printf("%100s| - Maybe you Forgot you have not register an account - |\n", "");
            System.out.print(PrintColor.RED_BOLD);
            System.out.printf("%100s| -             Please Try Register First!!!          - |\n", "");
            System.out.print(PrintColor.RED_BOLD);
            System.out.printf("%100s+-------------------------------------------------------+\n\n", "");
            System.out.print(PrintColor.RESET);
        }
    }
    
    public void signUp() {
        int confirm = 0;
        do {
            System.out.println("\n\n");
            System.out.print(PrintColor.BLUE_BOLD);
            System.out.printf("%100s+-------------------------------------------------------+\n", "");
            System.out.print(PrintColor.BLUE_BOLD);
            System.out.printf("%100s|                         SIGN UP                       |\n", "");
            System.out.print(PrintColor.BLUE_BOLD);
            System.out.printf("%100s+-------------------------------------------------------+\n\n", "");
            System.out.print(PrintColor.PURPLE_BOLD);
            System.out.printf("%100s                Create a new Stuff ID  : ", "");
            Scanner stuffidScan = new Scanner(System.in);
            String stuffID = stuffidScan.nextLine();
            System.out.print(PrintColor.PURPLE_BOLD);
            System.out.printf("%100s                Create a new Password  : ", "");
            Scanner newPasswordScan = new Scanner(System.in);
            String password = newPasswordScan.nextLine();
            pfr.addStaff(new Staff(stuffID, password));
            System.out.println("\n");
            System.out.print(PrintColor.BLUE);
            System.out.printf("%100s              Do you want to login Now??? \n", "");
            System.out.print(PrintColor.BLUE);
            System.out.printf("%100s                 (1 = Yes, 2 = No): ", "");
            Scanner confirmLogin = new Scanner(System.in);
            confirm = confirmLogin.nextInt();

            switch (confirm) {
                case 1:
                    login();
                    break;
                case 2:
                    System.out.println("\n");
                    System.out.print(PrintColor.CYAN);
                    System.out.printf("%100s                Thanks for Sign UP !!!\n\n", "");
                    break;
                default:
                    System.out.print(PrintColor.RED_BOLD);
                    System.out.printf("%100s+-------------------------------------------------------+\n", "");
                    System.out.print(PrintColor.RED_BOLD);
                    System.out.printf("%100s|           Please enter either 1 or 2 only !!!         |\n", "");
                    System.out.print(PrintColor.RED_BOLD);
                    System.out.printf("%100s+-------------------------------------------------------+\n\n\n", "");
                    System.out.print(PrintColor.RESET);
                    break;
            }
        } while (confirm < 1 || confirm > 2);
    }

    public void optionPage() {
        int noMenu, confirm = 6, invalid = 0;

        do {
            System.out.println("\n");
            System.out.print(PrintColor.BLUE_BOLD);
            System.out.printf("%100s+-------------------------------------------------------+\n", "");
            System.out.print(PrintColor.BLUE_BOLD);
            System.out.printf("%100s|                       Option                          |\n", "");
            System.out.print(PrintColor.BLUE_BOLD);
            System.out.printf("%100s+-------------------------------------------------------+\n", "");
            System.out.print(PrintColor.BLUE_BOLD);
            System.out.printf("%100s|                1. Display Patient details             |\n", "");
            System.out.print(PrintColor.BLUE_BOLD);
            System.out.printf("%100s|                2. Edit Patient details                |\n", "");
            System.out.print(PrintColor.BLUE_BOLD);
            System.out.printf("%100s|                3. Add new Patient.                    |\n", "");
            System.out.print(PrintColor.BLUE_BOLD);
            System.out.printf("%100s|                4. Walk In Treatment.                  |\n", "");
            System.out.print(PrintColor.BLUE_BOLD);
            System.out.printf("%100s|                5. Delete Patient.                     |\n", "");
            System.out.print(PrintColor.BLUE_BOLD);
            System.out.printf("%100s|                0. Log Out.                            |\n", "");
            System.out.print(PrintColor.BLUE_BOLD);
            System.out.printf("%100s+-------------------------------------------------------+\n\n", "");
            System.out.print(PrintColor.PURPLE_BOLD);
            System.out.printf("%100s             Please input your selection :   ", "");
            Scanner menuScan = new Scanner(System.in);
            noMenu = menuScan.nextInt();

            switch (noMenu) {
                case 1:
                    displayPatient();
                    optionPage();
                    break;
                case 2:
                    editPatient();
                    optionPage();
                    break;
                case 3:
                    System.out.println("\n\n\n");
                    System.out.print(PrintColor.BLUE_BOLD);
                    System.out.printf("%100s+-------------------------------------------------------+\n", "");
                    System.out.print(PrintColor.BLUE_BOLD);
                    System.out.printf("%100s|                 First Time Registration               |\n", "");
                    System.out.print(PrintColor.BLUE_BOLD);
                    System.out.printf("%100s+-------------------------------------------------------+\n\n", "");
                    System.out.print(PrintColor.PURPLE_BOLD);
                    System.out.printf("%100s    Create a new Patient ID               : ", "");
                    Scanner pid = new Scanner(System.in);
                    String patientId = pid.nextLine();
                    System.out.print(PrintColor.PURPLE_BOLD);
                    System.out.printf("%100s    What is The Patient Name              : ", "");
                    Scanner pn = new Scanner(System.in);
                    String name = pn.nextLine();
                    System.out.print(PrintColor.PURPLE_BOLD);
                    System.out.printf("%100s    What is The Patient IC Number ??      : ", "");
                    Scanner icn = new Scanner(System.in);
                    String ic = icn.nextLine();
                    System.out.print(PrintColor.PURPLE_BOLD);
                    System.out.printf("%100s    What are The Patient age              : ", "");
                    Scanner pa = new Scanner(System.in);
                    int a = pa.nextInt();
                    System.out.print(PrintColor.PURPLE_BOLD);
                    System.out.printf("%100s    What are The Patient weight           : ", "");
                    Scanner pw = new Scanner(System.in);
                    double w = pw.nextDouble();
                    System.out.print(PrintColor.PURPLE_BOLD);
                    System.out.printf("%100s    What are The Patient address          : ", "");
                    Scanner padd = new Scanner(System.in);
                    String add = padd.next();
                    System.out.print(PrintColor.PURPLE_BOLD);
                    System.out.printf("%100s    What are The Patient Phone Number     : ", "");
                    Scanner ppn = new Scanner(System.in);
                    String phone = ppn.next();
                    System.out.print(PrintColor.PURPLE_BOLD);
                    System.out.printf("%100s    What are The Patient Sickness History : ", "");
                    Scanner psh = new Scanner(System.in);
                    String history = psh.next();

                    pfr.addPatient(new PatientProfile(patientId, name, ic, a, w, add, phone, history));
                    System.out.println("\n\n");
                    System.out.print(PrintColor.CYAN);
                    System.out.printf("%100s      You Have Successfully Register the Patient !!! \n", "");
                    optionPage();
                    break;
                case 4:
                    // walk in treatment; call other ppl's function
                    System.out.println("UNDER CONSTRUCTION");
                    optionPage();
                    break;
                case 5:
                    removePatient();
                    optionPage();
                    break;
                case 0:
                    do {
                        System.out.println("\n");
                        System.out.print(PrintColor.PURPLE_BOLD);
                        System.out.printf("%100s           Confirm Log Out? (1.Yes/2.No):   ", "");
                        Scanner cLogOut = new Scanner(System.in);
                        confirm = cLogOut.nextInt();
                        if (confirm != 1 && confirm != 2) {
                            invalid = 1;
                            System.out.println("\n");
                            System.out.print(PrintColor.RED_BOLD);
                            System.out.printf("%100s+-------------------------------------------------------+\n", "");
                            System.out.print(PrintColor.RED_BOLD);
                            System.out.printf("%100s|                Please enter 1 or 2 only!!!!           |\n", "");
                            System.out.print(PrintColor.RED_BOLD);
                            System.out.printf("%100s+-------------------------------------------------------+\n\n", "");
                            System.out.print(PrintColor.RESET);
                        } else if (confirm == 2) {
                            optionPage();
                        } else {
                            invalid = 0;
                            System.out.print(PrintColor.RED_BOLD);
                            System.out.printf("%100s+-------------------------------------------------------+\n", "");
                            System.out.print(PrintColor.RED_BOLD);
                            System.out.printf("%100s|                 --  You have log out~~  --            |\n", "");
                            System.out.print(PrintColor.RED_BOLD);
                            System.out.printf("%100s+-------------------------------------------------------+\n\n", "");
                            System.out.print(PrintColor.RESET);
                            welcome(); // go back to welcome page
                        }
                    } while (invalid == 1);
                    break;
                default:
                    System.out.println("\n");
                    System.out.print(PrintColor.RED_BOLD);
                    System.out.printf("%100s+-------------------------------------------------------+\n", "");
                    System.out.print(PrintColor.RED_BOLD);
                    System.out.printf("%100s|                Please enter 0 to 5 only!!!!           |\n", "");
                    System.out.print(PrintColor.RED_BOLD);
                    System.out.printf("%100s+-------------------------------------------------------+\n\n", "");
                    System.out.print(PrintColor.RESET);
                    break;
            }
        } while (noMenu < 0 || noMenu > 5);
    }

    public void displayPatient() {
        System.out.println("\n\n");
        System.out.print(PrintColor.BLUE_BOLD);
        System.out.printf("%100s+-------------------------------------------------------+\n", "");
        System.out.print(PrintColor.BLUE_BOLD);
        System.out.printf("%100s|               DISPLAY PATIENT INFORMATION             |\n", "");
        System.out.print(PrintColor.BLUE_BOLD);
        System.out.printf("%100s+-------------------------------------------------------+\n\n", "");
        System.out.print(PrintColor.PURPLE_BOLD);
        System.out.printf("%100s              Please Enter Patient ID :   ", "");
        Scanner search = new Scanner(System.in);
        String pid = search.nextLine();
        pfr.displayPatient(pid);
    }

    public void editPatient() {
        System.out.println("\n\n");
        System.out.print(PrintColor.BLUE_BOLD);
        System.out.printf("%100s+-------------------------------------------------------+\n", "");
        System.out.print(PrintColor.BLUE_BOLD);
        System.out.printf("%100s|               MODIFY PATIENT INFORMATION              |\n", "");
        System.out.print(PrintColor.BLUE_BOLD);
        System.out.printf("%100s+-------------------------------------------------------+\n\n", "");
        System.out.print(PrintColor.PURPLE_BOLD);
        System.out.printf("%100s              Please Enter Patient ID :   ", "");
        Scanner pidScan = new Scanner(System.in);
        String pid = pidScan.next();
        
        // if patient ID is found
        if (pfr.searchPatient(pid) == true) {
            pp = pfr.getPatient(pid); // get the old record details
            epMenu(pid); // call the menu method
        } else {
            // not found
        }
    }
    
    // edit patient menu
    public void epMenu(String patientID) {
        int noEdit = 10;
        do {
            System.out.println("\n\n");
            System.out.print(PrintColor.CYAN);
            System.out.printf("%100s+-------------------------------------------------------+\n", "");
            System.out.print(PrintColor.CYAN);
            System.out.printf("%100s|           What Detail Would You Like To Edit ??       |\n", "");
            System.out.print(PrintColor.CYAN);
            System.out.printf("%100s+-------------------------------------------------------+\n", "");
            System.out.print(PrintColor.CYAN);
            System.out.printf("%100s|                1. Edit Patient ID                     |\n", "");
            System.out.print(PrintColor.CYAN);
            System.out.printf("%100s|                2. Edit Patient Name                   |\n", "");
            System.out.print(PrintColor.CYAN);
            System.out.printf("%100s|                3. Edit Patient IC                     |\n", "");
            System.out.print(PrintColor.CYAN);
            System.out.printf("%100s|                4. Edit Patient Age                    |\n", "");
            System.out.print(PrintColor.CYAN);
            System.out.printf("%100s|                5. Edit Patient Weight                 |\n", "");
            System.out.print(PrintColor.CYAN);
            System.out.printf("%100s|                6. Edit Patient Address                |\n", "");
            System.out.print(PrintColor.CYAN);
            System.out.printf("%100s|                7. Edit Patient Phone Number           |\n", "");
            System.out.print(PrintColor.CYAN);
            System.out.printf("%100s|                8. Edit Patient History                |\n", "");
            System.out.print(PrintColor.CYAN);
            System.out.printf("%100s|                9. Save Patient Detail                 |\n", "");
            System.out.print(PrintColor.CYAN);
            System.out.printf("%100s|                0. Back to Patient Profile             |\n", "");
            System.out.print(PrintColor.CYAN);
            System.out.printf("%100s+-------------------------------------------------------+\n\n", "");
            System.out.print(PrintColor.PURPLE_BOLD);
            System.out.printf("%100s                     Please select:   ", "");
            Scanner editScan = new Scanner(System.in);
            noEdit = editScan.nextInt();
            if (noEdit < 0 || noEdit > 9) {
                System.out.println("\n");
                System.out.print(PrintColor.RED_BOLD);
                System.out.printf("%100s+-------------------------------------------------------+\n", "");
                System.out.print(PrintColor.RED_BOLD);
                System.out.printf("%100s|                Please enter 0 or 9 only!!!!           |\n", "");
                System.out.print(PrintColor.RED_BOLD);
                System.out.printf("%100s+-------------------------------------------------------+\n\n", "");
                System.out.print(PrintColor.RESET);
            } else {
                rpDetails(noEdit, pp);
            }
        } while (noEdit < 0 || noEdit > 9); // loop this menu until user confirm the details
        
        // when user type 9
        pfr.editPatient(patientID, pp);
        System.out.print(PrintColor.BLUE);
        System.out.printf("%100s             Patient details have changed !!!                ", "");
    }
    
    // replace patient details
    public void rpDetails(int noEdit, PatientProfile pp) {
        String newUserId, newUsername, newAddress, newIc, newPhone, newHistory;
        int newAge;
        double newWeight;
        switch (noEdit) {
            case 1:
                System.out.println("\n");
                System.out.print(PrintColor.PURPLE_BOLD);
                System.out.printf("%100s         What is The new Patient ID? : ", "");
                Scanner nuid = new Scanner(System.in);
                newUserId = nuid.nextLine();
                pp.setPatientID(newUserId);
                break;
            case 2:
                System.out.println("\n");
                System.out.print(PrintColor.PURPLE_BOLD);
                System.out.printf("%100s         What is The new Patient Name? : ", "");
                Scanner username = new Scanner(System.in);
                newUsername = username.nextLine();
                pp.setPatientName(newUsername);
                break;
            case 3:
                System.out.println("\n");
                System.out.print(PrintColor.PURPLE_BOLD);
                System.out.printf("%100s        What is The new Patient IC? : ", "");
                Scanner ic = new Scanner(System.in);
                newIc = ic.next();
                pp.setIC(newIc);
                break;
            case 4:
                System.out.println("\n");
                System.out.print(PrintColor.PURPLE_BOLD);
                System.out.printf("%100s        What is The new Patient Age? : ", "");
                Scanner age = new Scanner(System.in);
                newAge = age.nextInt();
                pp.setAge(newAge);
                break;
            case 5:
                System.out.println("\n");
                System.out.print(PrintColor.PURPLE_BOLD);
                System.out.printf("%100s        What is The new Patient Weight? : ", "");
                Scanner weight = new Scanner(System.in);
                newWeight = weight.nextDouble();
                pp.setWeight(newWeight);
                break;
            case 6:
                System.out.println("\n");
                System.out.print(PrintColor.PURPLE_BOLD);
                System.out.printf("%100s        What is The new Patient Address? : ", "");
                Scanner address = new Scanner(System.in);
                newAddress = address.nextLine();
                pp.setAddress(newAddress);
                break;
            case 7:
                System.out.println("\n");
                System.out.print(PrintColor.PURPLE_BOLD);
                System.out.printf("%100s        What is The new Patient Phone Number? : ", "");
                Scanner phone = new Scanner(System.in);
                newPhone = phone.next();
                pp.setPatientNum(newPhone);
                break;
            case 8:
                System.out.println("\n");
                System.out.print(PrintColor.PURPLE_BOLD);
                System.out.printf("%100s        What is The new Patient Sickness history? : ", "");
                Scanner history = new Scanner(System.in);
                newHistory = history.next();
                pp.setPatientHistory(newHistory);
                break;
            case 0: break;
        }
    }

    public void removePatient() {
        int delete;
        String pid;

        System.out.println("\n\n");
        System.out.print(PrintColor.BLUE_BOLD);
        System.out.printf("%100s+-------------------------------------------------------+\n", "");
        System.out.print(PrintColor.BLUE_BOLD);
        System.out.printf("%100s|               DELETE PATIENT INFORMATION              |\n", "");
        System.out.print(PrintColor.BLUE_BOLD);
        System.out.printf("%100s+-------------------------------------------------------+\n\n", "");
        System.out.print(PrintColor.PURPLE_BOLD);
        System.out.printf("%100s              Please Enter Patient ID :   ", "");
        Scanner dpid = new Scanner(System.in);
        pid = dpid.next();
        
        if (pfr.searchPatient(pid) == true) {
            System.out.println("\n");
            System.out.print(PrintColor.CYAN_BOLD);
            System.out.printf("%100s+-------------------------------------------------------+\n", "");
            System.out.print(PrintColor.CYAN_BOLD);
            System.out.printf("%100s++            [ Required To Confirm REMOVAL ]          ++\n", "");
            System.out.print(PrintColor.CYAN_BOLD);
            System.out.printf("%100s+-------------------------------------------------------+\n\n", "");
            System.out.print(PrintColor.RESET);
            System.out.print(PrintColor.PURPLE_BOLD);
            System.out.printf("%100s                   Type 1=YES 2=NO   : ", "");
            Scanner removal = new Scanner(System.in);
            delete = removal.nextInt();
            switch (delete) {
                case 1:
                    pfr.deletePatient(pid);
                    System.out.println("\n");
                    System.out.print(PrintColor.CYAN);
                    System.out.printf("%100s++-------------------------------------------------------++\n", "");
                    System.out.print(PrintColor.CYAN);
                    System.out.printf("%100s||     You Have Successfully Removed This Record !!!     ||\n", "");
                    System.out.print(PrintColor.CYAN);
                    System.out.printf("%100s||  --> This Record Will Not Appear In Patient List...   ||\n", "");
                    System.out.print(PrintColor.CYAN);
                    System.out.printf("%100s++-------------------------------------------------------++\n\n", "");
                    System.out.print(PrintColor.RESET);
                    optionPage();
                    break;
                case 2:
                    System.out.println("\n");
                    System.out.print(PrintColor.PURPLE_BOLD);
                    System.out.printf("%100s++-------------------------------------------------------++\n", "");
                    System.out.print(PrintColor.CYAN);
                    System.out.printf("%100s||           There's no REMOVAL Being Made !!!           ||\n", "");
                    System.out.print(PrintColor.CYAN);
                    System.out.printf("%100s||            Please Try Again If Any Needs              ||\n", "");
                    System.out.print(PrintColor.CYAN);
                    System.out.printf("%100s++-------------------------------------------------------++\n\n", "");
                    System.out.print(PrintColor.RESET);
                    optionPage();
                    break;
                default:
                    System.out.println("\n");
                    System.out.print(PrintColor.RED_BOLD);
                    System.out.printf("%100s++-------------------------------------------------------++\n", "");
                    System.out.print(PrintColor.RED_BOLD);
                    System.out.printf("%100s||           Please Input the correct number !!!         ||\n", "");
                    System.out.print(PrintColor.RED_BOLD);
                    System.out.printf("%100s++-------------------------------------------------------++\n\n", "");
                    System.out.print(PrintColor.RESET);
            }
        }
    }
}
