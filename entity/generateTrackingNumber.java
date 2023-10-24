package entity;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


/**
 *
 * @author Tan Kang Hong
 */
import java.text.SimpleDateFormat;
//import java.time.LocalDateTime;
//import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
//import java.util.Scanner;
//import java.util.Random;

public class generateTrackingNumber {
    private int trackingCollectMedicial;
    private String collectMedicalDurationTime;
    private String returnCollectMedicalDurationTime;
    
    public generateTrackingNumber(int trackingCollectMedicial, String collectMedicalDurationTime){
        this.trackingCollectMedicial = trackingCollectMedicial;
        this.collectMedicalDurationTime = setDurationTime();
        this.returnCollectMedicalDurationTime = null;
    }
    
    public int getTrackingCollectMedicial(){
        return trackingCollectMedicial;
    }
    
    public String getCollectMedicalDurationTime(){
        return collectMedicalDurationTime;
    }
    
    public String getReturnCollectMedicalDurationTime(){
        return returnCollectMedicalDurationTime;
    }
    
    public void setTrackingCollectMedicial(int trackingCollectMedicial){
        this.trackingCollectMedicial = trackingCollectMedicial;
    }
    
    public void setCollectMedicalDurationTime(String collectMedicalDurationTime){
        this.collectMedicalDurationTime = collectMedicalDurationTime;
    }
    
    public void setReturnCollectMedicalDurationTime(String returnCollectMedicalDurationTime){
        this.returnCollectMedicalDurationTime = returnCollectMedicalDurationTime;
    }
    
    private String setDurationTime(){
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE, 0);
        Date today = calendar.getTime();
        
        SimpleDateFormat dateformat = new SimpleDateFormat("dd-MM-yyyy");
        
//        String collectMedicalDurationTime = null;
        
        collectMedicalDurationTime = dateformat.format(today);
//        txtBorrowDate.setText(borrowdate);

        return collectMedicalDurationTime;
    }
    
    @Override
    public String toString(){
        return String.format(" %-8s",  collectMedicalDurationTime);
    }
}

