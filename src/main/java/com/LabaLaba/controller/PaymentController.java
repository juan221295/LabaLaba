package com.LabaLaba.controller;

import com.LabaLaba.entity.Payment;
import com.LabaLaba.service.PaymentService;
import com.LabaLaba.session.SessionInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
public class PaymentController {
    @Autowired
    private PaymentService paymentService;

    @GetMapping(value = "/payment/create")
    public String createPayement(HttpSession session) {
        SessionInfo info = (SessionInfo) session.getAttribute("user");

        paymentService.createPayment(info.getId());

        return "redirect:/payment";
    }

    @GetMapping(value = "/payment")
    public String getPaymentPage(HttpSession session, Model model) {
        SessionInfo sessionInfo = (SessionInfo) session.getAttribute("user");
        String role = (String) session.getAttribute("role");

        List<Payment> payments;

        if(role.equalsIgnoreCase("customer")) {
            payments = new ArrayList<>(paymentService.getPaymentByCustomer(sessionInfo.getId()));
        } else {
            payments = new ArrayList<>(paymentService.getPaymentBySupplier(sessionInfo.getId()));
        }

        model.addAttribute("payments", payments);

        return "payment-view";
    }
}
