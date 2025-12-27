package com.shbair.hospital.db.type;

public enum UsersType {
    admin(1, "admin"),
    doctor(2, "doctor"),
    nurse(3, "nurse"),
    reception(4,"reception");

    public static UsersType getUsersTypeById(int aInt) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private int id;
    private String type;

    private UsersType(int id, String type) {
        this.id = id;
        this.type = type;
    }
    // ENCAPSOLATION SETTER & GETTER

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

    

    public static UsersType getUsersTypeByType(String type) {
        for (UsersType usersType : UsersType.values()) {
            if (usersType.getType().equals(type))
            {
                return usersType;
        }
        }
        return null;
    }

    public static UsersType getUsersTypeByTypeById(int id) {
       //FOREACH 
        for (UsersType u : UsersType.values()) {
            if (u.getId() == id){
                return u;
            }
        }
        return null;
    }
}
