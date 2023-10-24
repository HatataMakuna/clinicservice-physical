/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package entity;

import adt.*;

/**
 *
 * @author Nee Mei Yi
 */
public class TrackingNumber {

    private int trackNum = 20000;
    
    public TrackingNumber(int trackNum) {
        this.trackNum = trackNum;
    }

    public int getTrackNum() {
        return trackNum;
    }

    public void setTrackNum(int trackNum) {
        this.trackNum = trackNum;
    }
      
    @Override
    public String toString(){
            return "Currently tracking number is: " + trackNum;
    }
}