/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.shbair.hospital.db.type;

/**
 *
 * @author LCS
 */
public enum UsersType {
    ADMIN(1, "admin"),DOCTOR(2,"doctor"); // Constants
    // متغيرات من نفس النوع  و من نفس الالعدد 
    private int id;
    private String type;
    // constructor
    private UsersType(int id , String type){
      this.id=id;
      this.type=type;
    }
    // if enter 1 -> admin or 2 -> doctor 
    public static UsersType getUsersTypeById(int id){
    for(UsersType UsersType:UsersType.values()){
         if (UsersType.getId()==id){
             return UsersType;
         }
        
    }
     return null;
    }
    
    
    // encapsulation (setter , getter)

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
    
    
}
