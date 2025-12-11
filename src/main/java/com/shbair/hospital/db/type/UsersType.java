package com.shbair.hospital.db.type;

public enum UsersType {
    ADMIN(1, "admin"),
    DOCTOR(2, "doctor"),
    NURSE(3, "nurse");   // مفيش getId هنا

    public static UsersType getUsersTypeByTypeById(int aInt) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private int id;
    private String type;

    // constructor
    private UsersType(int id, String type) {
        this.id = id;
        this.type = type;
    }

    // if enter "admin" -> ADMIN, "doctor" -> DOCTOR
    public static UsersType getUsersTypeByType(String type) {
        for (UsersType u : UsersType.values()) {
            if (u.getType().equals(type)) {   // صح
                return u;
            }
        }
        return null;
    }

    // getters
    public int getId() {
        return id;
    }

    public String getType() {
        return type;
    }
}
