/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.shbair.hospital.validation;

/**
 *
 * @author LCS
 */
public class Validation {
    public static boolean isEmpty(String... text)//infinite paramerter numbers....
    {
    for(String s:text){
    if (s.isEmpty()){
        return true;
         }
    }
    return false;
    }
    //نفس  الـميثود بس باراميتر يختلف overload مفهوم الـ
   public static boolean isEmpty(int... value){
   for(int i:value){
    if (i<0){
        return true;
         }
    }
    return false;
   } 
   public static boolean isDigit(String...text){
   for(String s:text){
     if(!s.matches("[0-9]+")) // (+) to enter more than one number...
     {
     return false;
     }
   }
     return true;
   } 
    public static boolean isText(String...text){
   for(String s:text){
     if(!s.matches("[a-z]+")) // (+) to enter more than one character...
     {
     return false;
     }
   }
     return true;
   }
}
