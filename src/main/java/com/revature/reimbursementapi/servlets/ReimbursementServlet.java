package com.revature.reimbursementapi.servlets;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.reimbursementapi.daos.ERS_ReimbursementDAO;
import com.revature.reimbursementapi.dtos.requests.GetAllReimbursementsRequest;
import com.revature.reimbursementapi.dtos.requests.NewReimbursementRequest;
import com.revature.reimbursementapi.dtos.requests.StatusChangeRequest;
import com.revature.reimbursementapi.models.ERS_Reimbursement;
import com.revature.reimbursementapi.services.ERS_ReimbursementService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.UUID;

public class ReimbursementServlet extends HttpServlet {
    private final ObjectMapper objectMapper;

    private final ERS_ReimbursementService reimbursementService;

    public ReimbursementServlet(ObjectMapper objectMapper, ERS_ReimbursementService reimbursementService) {
        this.objectMapper = objectMapper;
        this.reimbursementService = reimbursementService;

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        GetAllReimbursementsRequest getAllReimbursementsRequest = objectMapper.readValue(req.getInputStream(), GetAllReimbursementsRequest.class);


        resp.setContentType("application/json");
        resp.getWriter().write(objectMapper.writeValueAsString(getAllReimbursementsRequest));

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        NewReimbursementRequest newReimbursementRequest = objectMapper.readValue(req.getInputStream(), NewReimbursementRequest.class);

        resp.getWriter().write(objectMapper.writeValueAsString(newReimbursementRequest));

        resp.setContentType("application/json");

        resp.getWriter().write(objectMapper.writeValueAsString(newReimbursementRequest.getAmount()));

        //??
        try {
            reimbursementService.saveReimbursementRequest(newReimbursementRequest);

        }catch(Exception e) {
            e.printStackTrace();
            resp.getWriter().println( e.getCause());
        }


        try {
            //Converting request class to model class
            ERS_Reimbursement newReimbRequest = new ERS_Reimbursement(UUID.randomUUID(), BigDecimal.valueOf(newReimbursementRequest.getAmount()), Timestamp.valueOf(LocalDateTime.now()), null, newReimbursementRequest.getDescription(), newReimbursementRequest.getReceipt(), newReimbursementRequest.getPayment_id(), UUID.fromString(newReimbursementRequest.getAuthor_id()), null, "P", newReimbursementRequest.getType_id());

            //reimbRequest.setStatus_id("PENDING_ID"); //Fill in once ids are decided.
            new ERS_ReimbursementDAO().save(newReimbRequest);
        } catch(Exception e) {
            e.printStackTrace();

        }


    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        StatusChangeRequest statusChange = objectMapper.readValue(req.getInputStream(), StatusChangeRequest.class);
        //String[] path = req.getRequestURI().split("/");
        //if(path[path.length - 1].equals("StatusChange")) {}
        resp.getWriter().write(objectMapper.writeValueAsString(statusChange));

        reimbursementService.managerUpdateReimbursementStatus(UUID.fromString(statusChange.getReimb_id()), statusChange.getStatus_id());

    }


}
