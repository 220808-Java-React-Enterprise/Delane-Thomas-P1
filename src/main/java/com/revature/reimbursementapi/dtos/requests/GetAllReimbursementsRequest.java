package com.revature.reimbursementapi.dtos.requests;

public class GetAllReimbursementsRequest {
    //Data fields
    private String user_id;
    private String columnName;
    private String column_id;
    private String order;

    public GetAllReimbursementsRequest() {
    }

    public GetAllReimbursementsRequest(String user_id, String columnName, String column_id, String order) {
        this.user_id = user_id;
        this.columnName = columnName;
        this.column_id = column_id;
        this.order = order;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getColumnName() {
        return columnName;
    }

    public void setColumnName(String columnName) {
        this.columnName = columnName;
    }

    public String getColumn_id() {
        return column_id;
    }

    public void setColumn_id(String column_id) {
        this.column_id = column_id;
    }

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }

    @Override
    public String toString() {
        return "GetAllReimbursementsRequest{" +
                "user_id='" + user_id + '\'' +
                ", cloumnName='" + columnName + '\'' +
                ", column_id='" + column_id + '\'' +
                ", order='" + order + '\'' +
                '}';
    }
}
