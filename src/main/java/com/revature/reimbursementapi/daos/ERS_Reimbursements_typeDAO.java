package com.revature.reimbursementapi.daos;

import com.revature.reimbursementapi.util.database.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

public class ERS_Reimbursements_typeDAO {

    public void save(Object obj) {  //Is this necessary? maybe an added feature?

    }

    public List getAll() {
        return null;
    }

    public String getTypeById(String type_id) {
        try(Connection con = ConnectionFactory.getInstance().getConnection()) {
            PreparedStatement ps = con.prepareStatement("SELECT type FROM ers_reimbursement_types WHERE type_id = ?");
            ps.setString(1, type_id);

            ResultSet rs = ps.executeQuery();

            if(rs.next()) {
                return rs.getString("type");

            }

        } catch(Exception e) {
            e.printStackTrace();

        }

        return null; //TODO: create typedoesnotexistexception

    }

    public void update(Object obj) {

    }

    public void delete(String id) {

    }


}
