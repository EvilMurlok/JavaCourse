package com.ilya.idea.lab4;

public enum Role {
    STAFF("10%"), MANAGER("20%"), EXECUTIVE("30%");
    private final String percent;
    Role(String role){
        this.percent = role;
    }
    public String getBenefit(){ return percent; }
}

