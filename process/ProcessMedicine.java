/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package process;
import adt.*;
//import assignment2.entity.generateHistory2;
import entity.*;
import java.util.Scanner;
/**
 *
 * @author Tan Kang Hong
 */
public class ProcessMedicine {
    ListInterface<medicineInformation> mi = new LinkedList<>(); // medicine information
    ListInterface<generateHistory> gh = new LinkedList<>(); // medicine history
    ListInterface<generateHistory2> gh2 = new LinkedList<>(); // patient history
    
    ProcessPaymentSystem pps = new ProcessPaymentSystem(); // stored for payment purpose
    
    public void start() {
        // history samples
        gh.add(new generateHistory("aisisisii", "jsjsjjsjs", "jsjsjsj", 100, 100.00));
        gh2.add(new generateHistory2("jajajja","aisisisii", "jsjsjjsjs", "jsjsjsj", 100, 100.00));
        gh2.add(new generateHistory2("jajajhb","aisisisii", "jsjsjjsjs", "jsjsjsj", 100, 100.00));
        
        // add medicine information
        mi.add(new medicineInformation("01010101", "Tan", "Common Illnesses",
                "Headaches", 50.00, "cluster, tension type and migraine",
                "Take three times a day, 2 capsules each time after meals.", 104));
        mi.add(new medicineInformation("01010102", "Kang", "Common Illnesses",
                "Colds and Flu", 30.00, "cause both colds and flu by increasing inflammation of the membranes "
                        + "in the nose and throat.",
                "Take three times a day, 2 capsules each time after meals.", 400));
        mi.add(new medicineInformation("01010103", "Hong", "Common Illnesses",
                "Fever", 20.00, "It is usually a sign that your body is trying to fight an illness or infection. "
                        + "Infections cause most fevers.",
                "Take three times a day, 2 capsules each time after meals.", 300));
        mi.add(new medicineInformation("01010104", "Cheng", "Common Illnesses",
                "Cough", 50.00, " clears the throat and breathing passage of foreign particles, microbes, "
                        + "irritants, fluids, and mucus",
                "Take three times a day, 2 capsules each time after meals.", 1000));
        mi.add(new medicineInformation("01010105", "Cai", "Common Illnesses",
                "Stomach Aches", 150.00, "have gas in your digestive tract, and to pass gas regularly.",
                "Take three times a day, 2 capsules each time after meals.", 400));
        mi.add(new medicineInformation("01010106", "Jie", "Common Illnesses",
                "Diarrhea", 100.00, "Diarrhea is loose, watery stools three or more times a day. "
                        + "Diarrhea may be acute, persistent, or chronic",
                "Take three times a day, 2 capsules each time after meals.", 200));
        mi.add(new medicineInformation("01010107", "Nee", "Allergic (Medicine, food, pollen, latex, pet dander)",
                "Medicine allergic", 150.00, "immune response", "Take three times a day, 2 capsules each time after meals.",
                460));
        mi.add(new medicineInformation("01010108", "Har", "Food Poisoning",
                "Food poisoning", 159.00, " caused by eating contaminated food. Infectious organisms",
                "Take three times a day, 2 capsules each time after meals.", 340));
        mi.add(new medicineInformation("01010109", "Chun", "Skin Diseases",
                "Acne", 20.00, " blocked skin follicles that lead to oil, bacteria and dead skin buildup in your pores.",
                "Take three times a day, 2 capsules each time after meals.", 460));
        mi.add(new medicineInformation("01010110", "Wai", "Skin Diseases",
                "Atopic dermatitis (eczema)", 50.00, " dry, itchy skin that leads to swelling, cracking or scaliness.",
                "Take three times a day, 2 capsules each time after meals.", 400));
    }
    
    /*
    * 
    * MEDICINE INFORMATION
    * 
    */
    
    // search medicine by sickness name
    int selectItem;
    public void displayMedicine(String patientID, String patientName, String sickType) {
        for (int i = 1; i <= mi.getNumberOfEntries(); i++) {
            if (sickType.equals(mi.getEntry(i).getSicknessName())) {
                //System.out.println(mi.getEntry(i));
                retrieveMedicineDetails(i);
                
                System.out.println("Do You Wanna to take medicine of this ?= ");
                Scanner choice = new Scanner(System.in);
                char choiceThis = choice.next(".").charAt(0);
                if (choiceThis == 'Y' || choiceThis == 'y') {
                    // prompt user how many items want to select
                    System.out.print("\nHow many item your wanna select? ");
                    Scanner item = new Scanner(System.in);
                    selectItem = item.nextInt();
                    takeMedicine(sickType, selectItem);
                    
                    // total medicine price = medicine price * no. of items
                    System.out.printf("Total Medicine Price : RM %.2f\n", mi.getEntry(i).getMedicialPrice() * selectItem);
                    // show no. of items left
                    System.out.println("Medicines left in stock: " + mi.getEntry(i).getMedicialInventory());
                    
                    // add to payment list
                    pps.addMedicineList(new Medicine(sickType, selectItem, mi.getEntry(i).getMedicialPrice()));
                    
                    // add to history
                    generateHistory agh = new generateHistory(patientID, patientName, sickType, selectItem, mi.getEntry(i).getMedicialPrice());
                    addHistory(agh);
                } else {
                    System.out.println("\nThe system will auto back to the common illnesses list.");
                    System.out.println("Please be wait awhile, system are going thru.");
                }
            }
        }
    }
    
    public void retrieveCommonIllness() {
        for (int i = 1; i <= mi.getNumberOfEntries(); i++) {
            if ("Common Illnesses".equals(mi.getEntry(i).getMedicialType())) {
                retrieveMedicineDetails(i);
            }
        }
    }
    
    // take medicine item, deduct the no. of items from the list
    public void takeMedicine(String sickType, int selectItem) {
        for (int i = 1; i <= mi.getNumberOfEntries(); i++) {
            if (sickType.equals(mi.getEntry(i).getSicknessName())) {
                mi.replace(i, new medicineInformation(mi.getEntry(i).getMedicialCode(),
                                                    mi.getEntry(i).getMedicialName(),
                                                    mi.getEntry(i).getMedicialType(),
                                                    mi.getEntry(i).getSicknessName(),
                                                    mi.getEntry(i).getMedicialPrice(),
                                                    mi.getEntry(i).getMedicialDesc(),
                                                    mi.getEntry(i).getTakeMedicine(),
                                                    mi.getEntry(i).getMedicialInventory() - selectItem));
            }
        }
    }
    
    public void addMedicine(medicineInformation m) {
        mi.add(m);
    }
    
    int toModify;
    public boolean searchMedicine(String code) {
        for (int i = 1; i <= mi.getNumberOfEntries(); i++) {
            if (code.equals(mi.getEntry(i).getMedicialCode())) {
                toModify = i;
                return true;
            }
        }
        return false;
    }
    
    // search medicine methods
    public void searchMedicineByCode(String code) {
        for (int i = 1; i <= mi.getNumberOfEntries(); i++) {
            if (code.equals(mi.getEntry(i).getMedicialCode())) {
                generateHistory2 agh2 = new generateHistory2("Search Function By Medicial Code", code,mi.getEntry(i).getMedicialName()
                    ,mi.getEntry(i).getMedicialDesc(), mi.getEntry(i).getMedicialInventory(), mi.getEntry(i).getMedicialPrice());
                    addHistory2(agh2);
                retrieveMedicineDetails(i);
                
            }
        }
    }
    
    public void searchMedicineByName(String name) {
        for (int i = 1; i <= mi.getNumberOfEntries(); i++) {
            if (name.equals(mi.getEntry(i).getMedicialName())) {
                generateHistory2 agh2 = new generateHistory2("Search Function By Medicial Name", mi.getEntry(i).getMedicialCode(),mi.getEntry(i).getMedicialName()
                    ,mi.getEntry(i).getMedicialDesc(), mi.getEntry(i).getMedicialInventory(), mi.getEntry(i).getMedicialPrice());
                    addHistory2(agh2);
                retrieveMedicineDetails(i);
            }
        }
    }
    
    public void searchMedicineByType(String type) {
        for (int i = 1; i <= mi.getNumberOfEntries(); i++) {
            if (type.equals(mi.getEntry(i).getMedicialType())) {
                generateHistory2 agh2 = new generateHistory2("Search Function By Medicial Type", mi.getEntry(i).getMedicialCode(),mi.getEntry(i).getMedicialName()
                    ,mi.getEntry(i).getMedicialDesc(), mi.getEntry(i).getMedicialInventory(), mi.getEntry(i).getMedicialPrice());
                    addHistory2(agh2);
                retrieveMedicineDetails(i);
            }
        }
    }
    
    // display medicine
    public void retrieveAllMedicine() {
        for (int i = 1; i <= mi.getNumberOfEntries(); i++) {
            generateHistory2 agh2 = new generateHistory2("Display Function", mi.getEntry(i).getMedicialCode(),mi.getEntry(i).getMedicialName()
                    ,mi.getEntry(i).getMedicialDesc(), mi.getEntry(i).getMedicialInventory(), mi.getEntry(i).getMedicialPrice());
            addHistory2(agh2);
            retrieveMedicineDetails(i);
        }
    }
    
    public void retrieveAllMedicine2(String patientID, String patientName) {
        for (int i = 1; i <= mi.getNumberOfEntries(); i++) {
            generateHistory agh = new generateHistory(patientID, patientName, mi.getEntry(i).getMedicialDesc(),
                    mi.getEntry(i).getMedicialInventory(), mi.getEntry(i).getMedicialPrice());
            addHistory(agh);
            retrieveMedicineDetails(i);
        }
    }
    
    public void retrieveMedicineDetails(int i) {
        System.out.printf("\n\n%61s <<<<<:::      Current Medicine Details      :::>>>>>\n", "");
        System.out.printf("%61s#=======================================================#\n", "");
//                      System.out.printf("%61s|       Medicial Code         :     %-21s  |\n", "", commonIllnessesList.getEntry(1));
        System.out.printf("%61s|       Medicial Code           :     %-10s    |\n", "", mi.getEntry(i).getMedicialCode());
        System.out.printf("%61s|       Medicial Name           :     %-15s    |\n", "", mi.getEntry(i).getMedicialName());
        System.out.printf("%61s|       Medicial Type           :     %-20s    |\n", "", mi.getEntry(i).getMedicialType());
        System.out.printf("%61s|       Sickness Name           :     %-15s    |\n", "", mi.getEntry(i).getSicknessName());
        System.out.printf("%61s|       Medicial Price          :     RM %.2f   |\n", "", mi.getEntry(i).getMedicialPrice());
        System.out.printf("%61s|       Medicine Description    :     %-20s    |\n", "", mi.getEntry(i).getMedicialDesc());
        System.out.printf("%61s|       Take Medicine           :     %-15s    |\n", "", mi.getEntry(1).getTakeMedicine());
        System.out.printf("%61s|       Medicine Inventory      :     %4d      |\n", "", mi.getEntry(i).getMedicialInventory());
    }
    
    public void deleteMedicineByCode(String code) {
        for (int i = 1; i <= mi.getNumberOfEntries(); i++) {
            if (code.equals(mi.getEntry(i).getMedicialCode())) {
                retrieveMedicineDetails(i);
                System.out.print("Confirm Delete? ");
                Scanner cscan = new Scanner(System.in);
                char confirm = cscan.next(".").charAt(0);
                if (confirm == 'Y' || confirm == 'y') {
                    generateHistory2 agh2 = new generateHistory2("Delete Function By Medicial Code", mi.getEntry(i).getMedicialCode(),mi.getEntry(i).getMedicialName()
                    ,mi.getEntry(i).getMedicialDesc(), mi.getEntry(i).getMedicialInventory(), mi.getEntry(i).getMedicialPrice());
                    addHistory2(agh2);
                    mi.remove(i);
                    
                    System.out.println("Deleted successfully");
                }
            }
        }
    }
    
    public void deleteMedicineByName(String name) {
        for (int i = 1; i <= mi.getNumberOfEntries(); i++) {
            if (name.equals(mi.getEntry(i).getMedicialName())) {
                retrieveMedicineDetails(i);
                System.out.print("Confirm Delete? ");
                Scanner cscan = new Scanner(System.in);
                char confirm = cscan.next(".").charAt(0);
                if (confirm == 'Y' || confirm == 'y') {
                    generateHistory2 agh2 = new generateHistory2("Delete Function By Medicial Name", mi.getEntry(i).getMedicialCode(),name
                    ,mi.getEntry(i).getMedicialDesc(), mi.getEntry(i).getMedicialInventory(), mi.getEntry(i).getMedicialPrice());
                    addHistory2(agh2);
                    mi.remove(i);
                    
                    System.out.println("Deleted successfully");
                }
            }
        }
    }
    
    public void editMedicineByCode() {
        String newCode;
        boolean isCodeValid = false;
        medicineInformation nmi = mi.getEntry(toModify);
        do {
            System.out.print("What is your new Medicial Code? = ");
            Scanner newMc = new Scanner(System.in);
            newCode = newMc.nextLine();
            isCodeValid = validateCode(newCode);
        } while (isCodeValid == false);
        System.out.println("Your new Medicial Code: " + newCode);
        
        nmi.setMedicialCode(newCode);
        confirmEdit(nmi, toModify);
         for (int i = 1; i <= mi.getNumberOfEntries(); i++) {
        if (newCode.equals(mi.getEntry(i).getMedicialCode())) {
            generateHistory2 agh2 = new generateHistory2("Modify Function By Medicial Code", mi.getEntry(i).getMedicialCode(),mi.getEntry(i).getMedicialName()
                    ,mi.getEntry(i).getMedicialDesc(), mi.getEntry(i).getMedicialInventory(), mi.getEntry(i).getMedicialPrice());
                    addHistory2(agh2);
        }
         }
        
        
    }
    
    public void editMedicineByName() {
        String newName;
        boolean isNameValid = false;
        medicineInformation nmi = mi.getEntry(toModify);
        do {
            System.out.print("What is your new Medicine Name? = ");
            Scanner newMn = new Scanner(System.in);
            newName = newMn.nextLine();
            isNameValid = validateName(newName);
        } while (isNameValid == false);
        System.out.println("Your new Medicine Name: " + newName);
        nmi.setMedicailName(newName);
        confirmEdit(nmi, toModify);
        for (int i = 1; i <= mi.getNumberOfEntries(); i++) {
        if (newName.equals(mi.getEntry(i).getMedicialName())) {
            generateHistory2 agh2 = new generateHistory2("Modify Function By Medicial Name", mi.getEntry(i).getMedicialCode(),mi.getEntry(i).getMedicialName()
                    ,mi.getEntry(i).getMedicialDesc(), mi.getEntry(i).getMedicialInventory(), mi.getEntry(i).getMedicialPrice());
                    addHistory2(agh2);
        }
         }
    }
    
    public void editMedicineByType() {
        medicineInformation nmi = mi.getEntry(toModify);
         Scanner editScan = new Scanner(System.in);
        int newMedicineType = 0;
        do {
            System.out.println("------- TYPE OF SICKNESS -------");
            System.out.println("[1] Common Illnesses");
            System.out.println("[2] Allergic (Medicine, food, pollen, latex, pet dander)");
            System.out.println("[3] Food Poisoning");
            System.out.println("[4] Skin Diseases");
            System.out.print("Choose new medicine type: ");
            Scanner nmt = new Scanner(System.in);

            newMedicineType = nmt.nextInt();
            if (newMedicineType < 1 || newMedicineType > 4) {
                System.out.println("Please choose 1 to 4 only !!");
            }
        } while (newMedicineType < 1 || newMedicineType > 4);
        switch (newMedicineType) {
            case 1:
                int newSickType = 0;
                nmi.setMedicialType("Common Illnesses");
                do {
                    System.out.println("\nType of CommonIllnesses");
                    System.out.println("--------------------------");
                    System.out.println("1. Headaches");
                    System.out.println("2. Colds and Flu");
                    System.out.println("3. Fever");
                    System.out.println("4. Cough");
                    System.out.println("5. Stomach Aches");
                    System.out.println("6. Diarrhea");
                    System.out.print("Enter choice(1-6):");
                    newSickType = editScan.nextInt();
                    if (newSickType < 1 || newSickType > 6) {
                        System.out.println("Please choose 1 to 6 only !!");
                    }
                } while (newSickType < 1 || newSickType > 6);
                switch (newSickType) {
                    case 1: nmi.setSicknesssName("Headaches"); break;
                    case 2: nmi.setSicknesssName("Colds and Flu"); break;
                    case 3: nmi.setSicknesssName("Fever"); break;
                    case 4: nmi.setSicknesssName("Cough"); break;
                    case 5: nmi.setSicknesssName("Stomach Aches"); break;
                    case 6: nmi.setSicknesssName("Diarrhea"); break;
                    default: System.out.println("Please enter 1 to 6 only !!");
                }
                break;
            case 2:
                nmi.setMedicialType("Allergic (Medicine, food, pollen, latex, pet dander)");
                nmi.setSicknesssName("Medicine allergic");
                break;
            case 3:
                nmi.setMedicialType("Food Poisoning");
                nmi.setSicknesssName("Food poisoning");
                break;
            case 4:
                int newSickType2 = 0;
                nmi.setMedicialType("Skin Diseases");
                do {
                    System.out.println("\nType of Skin Diseases");
                    System.out.println("--------------------------");
                    System.out.println("1. Acne");
                    System.out.println("2. Atopic dermatitis (eczema)");
                    System.out.print("Enter choice(1-2):");
                    newSickType2 = editScan.nextInt();
                    if (newSickType2 < 1 || newSickType2 > 2) {
                        System.out.println("Please choose 1 or 2 only !!");
                    }
                } while (newSickType2 < 1 || newSickType2 > 2);
                switch (newSickType2) {
                    case 1: nmi.setSicknesssName("Acne"); break;
                    case 2: nmi.setSicknesssName("Atopic dermatitis (eczema)"); break;
                    default: System.out.println("Please enter 1 to 2 only !!");
                }
                break;
        }
        confirmEdit(nmi, toModify);
        for (int i = 1; i <= mi.getNumberOfEntries(); i++) {
        if (nmi.equals(mi.getEntry(i))) {
            generateHistory2 agh2 = new generateHistory2("Modify Function By Medicial Type", mi.getEntry(i).getMedicialCode(),mi.getEntry(i).getMedicialName()
                    ,mi.getEntry(i).getMedicialDesc(), mi.getEntry(i).getMedicialInventory(), mi.getEntry(i).getMedicialPrice());
                    addHistory2(agh2);
        }
         }
    }
    
    public void editMedicineByPrice() {
        medicineInformation nmi = mi.getEntry(toModify);
        System.out.print("What is your new Medicine Price? = ");
        Scanner nmp = new Scanner(System.in);
        double newMedicinePrice = nmp.nextDouble();
        nmi.setMedicialPrice(newMedicinePrice);
        confirmEdit(nmi, toModify);
        for (int i = 1; i <= mi.getNumberOfEntries(); i++) {
        if (nmi.equals(mi.getEntry(i).getMedicialPrice())) {
            generateHistory2 agh2 = new generateHistory2("Modify Function By Medicial Price", mi.getEntry(i).getMedicialCode(),mi.getEntry(i).getMedicialName()
                    ,mi.getEntry(i).getMedicialDesc(), mi.getEntry(i).getMedicialInventory(), mi.getEntry(i).getMedicialPrice());
                    addHistory2(agh2);
        }
         }
    }
    
    public void editMedicineByDesc() {
        medicineInformation nmi = mi.getEntry(toModify);
        System.out.print("What is your new Medicial Description? = ");
        Scanner nmd = new Scanner(System.in);
        String newMedicineDesc = nmd.nextLine();
        nmi.setMedicialDesc(newMedicineDesc);
        confirmEdit(nmi, toModify);
        for (int i = 1; i <= mi.getNumberOfEntries(); i++) {
        if (nmi.equals(mi.getEntry(i).getMedicialDesc())) {
            generateHistory2 agh2 = new generateHistory2("Modify Function By Medicial Type", mi.getEntry(i).getMedicialCode(),mi.getEntry(i).getMedicialName()
                    ,mi.getEntry(i).getMedicialDesc(), mi.getEntry(i).getMedicialInventory(), mi.getEntry(i).getMedicialPrice());
                    addHistory2(agh2);
        }
         }
    }
    
    public void editMedicineByTm() {
        medicineInformation nmi = mi.getEntry(toModify);
        System.out.print("What is your new Take Medicine? = ");
        Scanner ntm = new Scanner(System.in);
        String newTakeMedicine = ntm.nextLine();
        nmi.setTakeMedicine(newTakeMedicine);
        confirmEdit(nmi, toModify);
        for (int i = 1; i <= mi.getNumberOfEntries(); i++) {
        if (nmi.equals(mi.getEntry(i).getTakeMedicine())) {
            generateHistory2 agh2 = new generateHistory2("Modify Function By Medicial Type", mi.getEntry(i).getMedicialCode(),mi.getEntry(i).getMedicialName()
                    ,mi.getEntry(i).getMedicialDesc(), mi.getEntry(i).getMedicialInventory(), mi.getEntry(i).getMedicialPrice());
                    addHistory2(agh2);
        }
         }
    }
    
    public void editMedicineByInv() {
        medicineInformation nmi = mi.getEntry(toModify);
        System.out.print("What is your new Medicial Inventory? = ");
        Scanner nminv = new Scanner(System.in);
        int newMedicineInv = nminv.nextInt();
        nmi.setMedicialInventory(newMedicineInv);
        confirmEdit(nmi, toModify);
        for (int i = 1; i <= mi.getNumberOfEntries(); i++) {
        if (nmi.equals(mi.getEntry(i).getMedicialInventory())) {
            generateHistory2 agh2 = new generateHistory2("Modify Function By Medicial Type", mi.getEntry(i).getMedicialCode(),mi.getEntry(i).getMedicialName()
                    ,mi.getEntry(i).getMedicialDesc(), mi.getEntry(i).getMedicialInventory(), mi.getEntry(i).getMedicialPrice());
                    addHistory2(agh2);
        }
         }
    }
    
    public void confirmEdit(medicineInformation nmi, int i) {
        System.out.print("Conform edit this medicine information ? ");
        Scanner ce = new Scanner(System.in);
        char confirmEdit = ce.next(".").charAt(0);
        if (confirmEdit == 'Y' || confirmEdit == 'y') {
            mi.replace(i, nmi);
            System.out.println("Edited successfully");
       }
    }
    
    /*
    * 
    * GENERATE HISTORY
    * 
    */
    // add a history to the list
    public void addHistory(generateHistory agh) {
        gh.add(agh);
    }
    
    public void displayHistory() {
        System.out.println("+------------------------------------------------------------------------------------------------------------------------------------------------------+");
        System.out.println("+                                                          Generate History                                                                            +");
        System.out.println("+ Patient Code         Patient Name       Duration Time & Date        Sickness Name    Medicine Inventory        Medicial Price                        +");
        for (int i = 1; i <= gh.getNumberOfEntries(); i++) {
            System.out.printf("+ %-10s           %-15s    %-20s        %-10s              %4d              RM %.2f    +\n" ,
                    gh.getEntry(i).getPatientID(), gh.getEntry(i).getPatientName(),
                    gh.getEntry(i).getDurationDate(), gh.getEntry(i).getAllMedicialDesc(),
                    gh.getEntry(i).getGMedicialInventory(), gh.getEntry(i).getGMedicialPrice());
        }
        System.out.println("+------------------------------------------------------------------------------------------------------------------------------------------------------+");
    }
    
     /*
    * 
    * GENERATE HISTORY 2
    * 
    */
    // add a history to the list
    public void addHistory2(generateHistory2 agh2) {
        gh2.add(agh2);
    }
    
    public void displayHistory2() {
        System.out.println("+------------------------------------------------------------------------------------------------------------------------------------------------------+");
        System.out.println("+                                                                  Generate History                                                                    +");
        System.out.println("+ Which Function            Medicial Code     Medicial Name     Duration Time & Date    Sickness Name    Medicine Inventory        Medicial Price      +");
        for (int i = 1; i <= gh2.getNumberOfEntries(); i++){
            System.out.printf("+     %-10s       %-10s    %-15s    %-5s                 %-10s              %4d                  RM %.2f    +\n",
                    gh2.getEntry(i).getWhichFunction(), gh2.getEntry(i).getMedicialID(),gh2.getEntry(i).getMedicialName(),
                    gh2.getEntry(i).getDurationDate(),gh2.getEntry(i).getAllMedicialDesc(), gh2.getEntry(i).getGMedicialInventory(),
                    gh2.getEntry(i).getGMedicialPrice());
        }
        System.out.println("+------------------------------------------------------------------------------------------------------------------------------------------------------+");
    }
    
    /*
    * 
    * OTHER METHODS
    * 
    */
    // validate medicine code
    public boolean validateCode(String medicineCode) {
        boolean codeIsValid = false;
        if ("".equals(medicineCode)) {
            System.out.println("The medicine code can't be empty! Please enter medicine code!");
        } else if (medicineCode.length() != 8) {
            System.out.println("Only acceptable 8 digits! Please re-enter!");
        } else if (!medicineCode.matches("[0-9]+")) {
            System.out.println("Only acceptable digits number! Please re-enter!");
        } else {
            codeIsValid = true;
        }
        return codeIsValid;
    }
    
    // validate medicine name
    public boolean validateName(String medicineName) {
        boolean nameIsValid = false;
        if ("".equals(medicineName)) {
            System.out.println("The name can't be empty! Please enter medicine name!");
        } else if (!medicineName.matches("[a-zA-Z ]+")) {
            System.out.println("The name only include alphabetic character and space! Please re-enter again!");
        } else {
            nameIsValid = true;
        }
        return nameIsValid;
    }
    
    public static void main(String[] args) {
//        medicineInformation test = new medicineInformation("01010108", "Har", "Food Poisoning",
//                "Food poisoning", 159.00, " caused by eating contaminated food. Infectious organisms",
//                "Take three times a day, 2 capsules each time after meals.", 340);
//        System.out.println(test.getSicknessName());

        ProcessMedicine pm = new ProcessMedicine();
        pm.start();
        pm.displayHistory2();
        
        //pm.displayMedicine("Food poisoning");
        //pm.displayMedicine("Colds and Flu");
        //pm.displayMedicine("Cough");
        //pm.takeMedicine("Headaches", 10);
        //pm.displayMedicine("Headaches");
        //pm.displayHistory();
    }
}