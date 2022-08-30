package com.revature.reimbursementapi.services;

import com.revature.reimbursementapi.daos.ERS_ReimbursementDAO;
import com.revature.reimbursementapi.dtos.requests.NewReimbursementRequest;
import com.revature.reimbursementapi.models.ERS_Reimbursement;
import com.revature.reimbursementapi.util.customexceptions.PlaceHolderException;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class ERS_ReimbursementService {

    private final ERS_ReimbursementDAO reimDAO;

    public ERS_ReimbursementService(ERS_ReimbursementDAO reimDAO ) {
        this.reimDAO = reimDAO;

    }

    public boolean verifyReimbursementFormCompletion(ERS_Reimbursement r) {

        if(r.getReimb_Id() == null) { return false; }
        else if(r.getAmount() == null) { return false; }    //TODO: check what the default value of a bigdecimal is.
        else if(r.getSubmitted() == null) { return false; }
        else if(r.getDescription() == null) { return false; }
        else if(r.getAuthor_id() == null) { return false; }
        else if(r.getType_id() == null) { return false; }


        return true;
    }
//Next TODO: change over from model type to request type.
    public void saveReimbursementRequest(NewReimbursementRequest reimbRequest) {
        //TODO: call verify form complete
        
        //Converting request class to model class
        ERS_Reimbursement newReimbRequest = new ERS_Reimbursement(UUID.randomUUID(), reimbRequest.getAmount(), Timestamp.valueOf(LocalDateTime.now()), null, reimbRequest.getDescription(), reimbRequest.getReceipt(), reimbRequest.getPayment_id(), UUID.fromString(reimbRequest.getAuthor_id()), null, "PENDING", reimbRequest.getType_id());

        //reimbRequest.setStatus_id("PENDING_ID"); //Fill in once ids are decided.
        reimDAO.save(newReimbRequest);

    }

    public List<ERS_Reimbursement> getReimbursementByEmployee_Id(UUID id) {

        List<ERS_Reimbursement> list = reimDAO.getAllByAuthorId(id);
        if(list.isEmpty()) {throw new PlaceHolderException("There are no saved reimbursements for this employee.");} //Placeholder exception.

        return list;
    }

    public void employeeUpdateReimbursement(ERS_Reimbursement reimb) {
        //STUB //Wondering whether to check if status is pending here or in the method that calls this one.
        reimDAO.update(reimb);

    }

    public void managerUpdateReimbursementStatus(UUID reimb_id, String status_id) {
        //STUB
        reimDAO.updateStatus(reimb_id, status_id);

    }

    public String getReimbursementStatusId(UUID reimb_id) {
        //STUB

        return reimDAO.getStatusByReimbId(reimb_id);

    }

    public List<ERS_Reimbursement> getAllReimbursementsOrderBy(String columnName, boolean order) {

        //For order True = Ascending False = Descending.
        List<ERS_Reimbursement> list;

        if(order) {
            list = reimDAO.getAllOrderByAscending(columnName);

        }
        else {
            list = reimDAO.getAllOrderByDescending(columnName);

        }

        if(list.isEmpty()) { throw new PlaceHolderException("There are no reimbursements at this time."); } //Consider replacing with a printStatement.

        return list;

    }

    //TODO: If time allows; create method to check if a reimbursement has already been resolved and return the name or id of the resolver along with the updated status.

}
