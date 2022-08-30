package com.revature.reimbursementapi.servlets;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.reimbursementapi.dtos.requests.NewReimbursementRequest;
import com.revature.reimbursementapi.models.ERS_Reimbursement;
import com.revature.reimbursementapi.services.ERS_ReimbursementService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
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
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        NewReimbursementRequest newReimbursementRequest = objectMapper.readValue(req.getInputStream(), NewReimbursementRequest.class);
        //??
        reimbursementService.saveReimbursementRequest(newReimbursementRequest);
        resp.getWriter().write(objectMapper.writeValueAsString(newReimbursementRequest) );


    }


}
