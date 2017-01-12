package com.LabaLaba.controller;

import com.LabaLaba.entity.Payment;
import com.LabaLaba.service.PaymentService;
import com.LabaLaba.service.SupplierService;
import com.LabaLaba.session.SessionInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
public class PaymentController {
    @Autowired
    private PaymentService paymentService;

    @Autowired
    private SupplierService supplierService;

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

    @GetMapping(value = "/payment/confirm")
    public String confirmPayment(@RequestParam Long paymentId,
                                 HttpSession session) {
        String role = (String) session.getAttribute("role");

        if (!role.equalsIgnoreCase("supplier")) {
            return "redirect:/";
        }
        SessionInfo sessionInfo = (SessionInfo) session.getAttribute("user");

        paymentService.confirmPayment(paymentId);
        return "redirect:/payment/pendingPayment?id="+ sessionInfo.getId();

    }

    @GetMapping(value = "/payment/pendingPayment")
    public String pendingPayment(@RequestParam Long id, HttpSession session, Model model){

        try{
            if(session.getAttribute("role").equals("supplier")){
                SessionInfo sessionInfo = (SessionInfo) session.getAttribute("user");
                if(sessionInfo.getId().equals(id)){
                    model.addAttribute("payments", paymentService.getPaymentBySupplier(id));
                    model.addAttribute("supplier", supplierService.getSupplierById(id));
                    return "supplier/pendingPayment";
                }
                else{
                    return "redirect:/";
                }
            }else {
                return "redirect:/";
            }
        }catch (NullPointerException e){
            return "redirect:/";
        }



    }

}
