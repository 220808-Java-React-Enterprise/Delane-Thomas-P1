package com.revature.reimbursementapi.dtos.requests;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.UUID;

public class NewReimbursementRequest {
    private BigDecimal amount;
    private String description;

    public NewReimbursementRequest() {
    }

    public NewReimbursementRequest(BigDecimal amount, String description) {
        this.amount = amount;
        this.description = description;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "NewReimbursementRequest{" +
                "amount=" + amount +
                ", description='" + description + '\'' +
                '}';
    }
}
