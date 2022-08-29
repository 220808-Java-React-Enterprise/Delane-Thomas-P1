package com.revature.reimbursementapi.models;

public class ERS_Reimbursement_type {
    //datafields
    private String type_id;
    private String type;

    //constructors
    public ERS_Reimbursement_type() {}

    public ERS_Reimbursement_type(String type_id, String type) {
        this.type_id = type_id;
        this.type = type;
    }

    //getters and setters

    public String getType_id() {
        return type_id;
    }

    public void setType_id(String type_id) {
        this.type_id = type_id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }


    //toString
    @Override
    public String toString() {
        return "ERS_Reimbursment_types{" +
                "type_id='" + type_id + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
