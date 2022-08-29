package com.revature.reimbursementapi.services;

import com.revature.reimbursementapi.daos.ERS_Reimbursements_typeDAO;

public class ERS_Reimbursement_typeService {

    private final ERS_Reimbursements_typeDAO typeDAO;

    public ERS_Reimbursement_typeService(ERS_Reimbursements_typeDAO typeDAO) {
        this.typeDAO = typeDAO;

    }

    public boolean verifyType_Id(String id) {
        return true;    //STUB

    }

    public String getType(String type_id) {
        //STUB
        return typeDAO.getTypeById(type_id);


    }

}
