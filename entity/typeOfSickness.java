package entity;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
//package MedicialSystem;

/**
 *
 * @author Tan Kang Hong
 */
public class typeOfSickness {
    private String sicknessName;
    private String sicknessDesc;
    private double medicinePrice; 
    private String takeMedicine;
    private int medicineInventory;
    
    public typeOfSickness(String sicknessName, String sicknessDesc, double medicinePrice,  String takeMedicine, int medicineInventory){
        this.sicknessName = sicknessName;
        this.sicknessDesc = sicknessDesc;
        this.medicinePrice = medicinePrice;
        this.takeMedicine = takeMedicine;
        this.medicineInventory = medicineInventory;
    }
    
    public String getSicknessName(){
        return sicknessName;
    }
    
    public String getSicknessDesc(){
        return sicknessDesc;
    }
    
    public double getMedicinePrice(){
        return medicinePrice;
    }
    
    public String getTakeMedicine(){
        return takeMedicine;
    }
    
    public int getMedicineInventory(){
        return medicineInventory;
    }
    
    public void setSicknesssName(String sicknessName){
        this.sicknessName = sicknessName;
    }
    
    public void setSicknessDesc(String sicknessDesc){
        this.sicknessDesc = sicknessDesc;
    }
    
    public void setMedicinePrice(double medicinePrice){
        this.medicinePrice = medicinePrice;
    }
    
    public void setTakeMedicine(String takeMedicine){
        this.takeMedicine = takeMedicine;
    }
    
    public void setMedicineInventory(int medicineInventory){
        this.medicineInventory = medicineInventory;
    }
    
    @Override
    public String toString(){
        return String.format(" %-15s  %-50s  %2f  %-15s  %3d \n", sicknessName, sicknessDesc, medicinePrice, takeMedicine, medicineInventory);
    }
}
