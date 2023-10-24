/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;
import java.util.*;
import adt.*;

/**
 *
 * @author Nee Mei Yi
 */
public class Emergency {
    QueueInterface<SickDetailSystem> sickDetailSystemList = new ArrayQueue<>();
    public static int[] reverseArray(int[] arr) {
        Stack <String> stack = new Stack();
        int len = arr.length;
        String[] strArr = new String[len];


        for (int i = 0; i < arr.length; i++) {
            strArr[i] = String.valueOf(arr[i]);
            stack.push(strArr[i]);
        }
        for (int i = 0; i < strArr.length; i++) {
            strArr[i] = stack.pop();
            arr[i] = Integer.parseInt(strArr[i]);
        }
        return arr;
    }
    
//    public static void reverse(String[] arr){ 
//
//    ArrayStack<TrackingNumber> trackingNumber = new ArrayStack<TrackingNumber>();   
//
//        for(int i = 0; i < trackingNumber.length; i++) {           
//            trackingNumber.push(arr[i]);
//        }
//
//        for(int i = 0; i <trackingNumber.length; i++) {
//            arr[i] = trackingNumber.pop();
//            //arr[i] = Integer.parseInt(arr[i]);
//        }
//    }
}