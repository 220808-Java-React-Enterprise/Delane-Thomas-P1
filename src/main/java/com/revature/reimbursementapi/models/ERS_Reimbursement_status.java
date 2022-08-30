package com.revature.reimbursementapi.models;

public class ERS_Reimbursement_status {
    //datafields
    private String status_id;
    private String status;

    //constructors
    public ERS_Reimbursement_status() {}

    public ERS_Reimbursement_status(String status_id, String status) {
        this.status_id = status_id;
        this.status = status;
    }

    //getters and setters

    public String getStatus_id() {
        return status_id;
    }

    public void setStatus_id(String status_id) {
        this.status_id = status_id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }



    //toStrings

    @Override
    public String toString() {
        return "ERS_reimbursement_statuses{" +
                "status_id='" + status_id + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
