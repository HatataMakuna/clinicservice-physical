/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author Har Chun Wai
 */
public class Medicine {
    // list the medicines, number and cost
    // show total cost
    private String medicineName;
    private int number;
    private double costPerMedicine;
    private double cost;
    
    public Medicine(String medicineName, int number, double costPerMedicine) {
        this.medicineName = medicineName;
        this.number = number;
        this.costPerMedicine = costPerMedicine;
        this.cost = number * costPerMedicine;
    }

    public String getMedicineName() {
        return medicineName;
    }

    public int getNumber() {
        return number;
    }

    public double getCostPerMedicine() {
        return costPerMedicine;
    }

    public double getCost() {
        return cost;
    }

    public void setMedicineName(String medicineName) {
        this.medicineName = medicineName;
    }

    public void setNumber(int number) {
        this.number = number;
        this.cost = number * costPerMedicine;
    }

    public void setCostPerMedicine(double costPerMedicine) {
        this.costPerMedicine = costPerMedicine;
        this.cost = number * costPerMedicine;
    }

    @Override
    public String toString() {
        return "medicineList{" + "medicineName=" + medicineName + ", number=" + number + ", costPerMedicine=" + costPerMedicine + ", cost=" + cost + '}';
    }
}
