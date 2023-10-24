/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author Tan Kang Hong
 */
public class medicineInformation {
    private String medicialCode;
    private String medicialName;
    private String medicialType;
    private String sicknessName;
    private double medicialPrice;
    private String medicialDesc;
    private String takeMedicine;
    private int medicialInventory;
    
    public medicineInformation(String medicialCode, String medicialName, String medicialType, String sicknessName, double medicialPrice, String medicialDesc, String takeMedicine, int medicialInventory){
        this.medicialCode = medicialCode;
        this.medicialName = medicialName;
        this.medicialType = medicialType;
        this.sicknessName = sicknessName;
        this.medicialPrice = medicialPrice;
        this.medicialDesc = medicialDesc;
        this.takeMedicine = takeMedicine;
        this.medicialInventory = medicialInventory;
    }
    
    public String getMedicialCode(){
        return medicialCode;
    }
    
    public String getMedicialName(){
        return medicialName;
    }
    
    public String getMedicialType(){
        return medicialType;
    }
    
    public String getSicknessName(){
        return sicknessName;
    }
    
    public double getMedicialPrice(){
        return medicialPrice;
    }
    
    public String getMedicialDesc(){
        return medicialDesc;
    }
    
     public String getTakeMedicine(){
        return takeMedicine;
    }
     
    public int getMedicialInventory(){
        return medicialInventory;
    }
    
    public void setMedicialCode(String medicialCode){
        this.medicialCode = medicialCode;
    } 
    
    public void setMedicailName(String medicialName){
        this.medicialName = medicialName;
    }
    
    public void setMedicialType(String medicialType){
        this.medicialType = medicialType;
    }
    
    public void setSicknesssName(String sicknessName){
        this.sicknessName = sicknessName;
    }
    
    public void setMedicialPrice(double medicialPrice){
        this.medicialPrice = medicialPrice;
    }
    
    public void setMedicialDesc(String medicialDesc){
        this.medicialDesc = medicialDesc;
    }
    
    public void setTakeMedicine(String takeMedicine){
        this.takeMedicine = takeMedicine;
    }
    
    public void setMedicialInventory(int medicialInventory){
        this.medicialInventory = medicialInventory;
    }
   
    @Override
    public String toString(){
        return String.format("| %-10s | %-15s | %-20s | %-15s | %.2f | %-20s | %-15s | %4d |\n", medicialCode,medicialName, medicialType, sicknessName, medicialPrice, medicialDesc, takeMedicine, medicialInventory);
    }
}