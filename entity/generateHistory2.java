/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author Tan Kang Hong
 */
public class generateHistory2 {
  
    private String whichFunction;
    private String medicialID;
    private String medicialName;
    private String durationDate;
    private String allMedicialDesc;
    private int gMedicialInventory;
    private double gMedicialPrice;
    
    public generateHistory2(String whichFunction, String medicialID, String medicialName, String allMedicialDesc, int gMedicialInventory, double gMedicialPrice){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
         
        this.whichFunction = whichFunction;
        this.medicialID = medicialID;
        this.medicialName = medicialName;
        this.durationDate = dtf.format(now);
        this.allMedicialDesc = allMedicialDesc;
        this.gMedicialInventory = gMedicialInventory;
        this.gMedicialPrice = gMedicialPrice;
    }
    
    public String getWhichFunction(){
        return whichFunction;
    }
    
    public String getMedicialID(){
        return medicialID;
    }
    
    public String getMedicialName(){
        return medicialName;
    }

    
    public String getDurationDate(){
        return durationDate;
    }
    
    public String getAllMedicialDesc(){
        return allMedicialDesc;
    }
    
    public int getGMedicialInventory(){
        return gMedicialInventory;
    }
    
    public double getGMedicialPrice(){
        return gMedicialPrice;
    }
    
    public void setWhichFunction(String whichFunction){
        this.whichFunction = whichFunction;
    }
    
    public void setMedicialID(String medicialID) {
        this.medicialID = medicialID;
    }

    public void setPatientName(String medicialName) {
        this.medicialName = medicialName;
    }
    
//    public void setDurationTime(String durationTime) {
//        this.durationTime = durationTime;
//    }
//    
    public void setDurationDate(String durationDate) {
        this.durationDate = durationDate;
    }
    
    public void setAllMedicialDesc(String allMedicialDesc) {
        this.allMedicialDesc = allMedicialDesc;
    }
    
    public void setGMedicialInventory(int gMedicialInventory) {
        this.gMedicialInventory = gMedicialInventory;
    }
    
    public void setGMedicialPrice(double gMedicialPrice) {
        this.gMedicialPrice = gMedicialPrice;
    }
    
    @Override
    public String toString(){
        return String.format("| %-20s | %-20s | %-15s | %-15s | %-30s | %-4d | %.2f \n", whichFunction, medicialID, medicialName, durationDate, allMedicialDesc, gMedicialInventory, gMedicialPrice);
    }
    
//    public static void main(String args[]) {
//        generateHistory gh = new generateHistory("aisisisii", "jsjsjjsjs", "jsjsjsj", "jsjjsjsj", 100.00);
//        
//        System.out.println(gh.toString());
//    }
}