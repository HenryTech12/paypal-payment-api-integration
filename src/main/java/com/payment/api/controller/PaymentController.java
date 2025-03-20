package com.payment.api.controller;

import org.springframework.stereotype.Controller; 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import com.payment.api.service.*;
import com.payment.api.dto.*;
import com.payment.api.mapper.*;
import com.paypal.api.payments.*;
import org.springframework.ui.Model; 
import org.springframework.web.bind.annotation.ModelAttribute; 
import org.springframework.web.servlet.view.RedirectView; 
import org.springframework.web.bind.annotation.RequestParam;
import java.util.*;
import org.springframework.web.bind.annotation.RequestMapping;
import jakarta.servlet.http.*; 

@Controller
public class PaymentController {



     @Autowired
      private PaymentService paymentService;
      private ReceiptDTO storeReceipt;

    @GetMapping("/")
     public String home() {
           return "index";
    }

    @GetMapping("/home")
    public String gohome() {
         return "index";
    }

     @PostMapping("/payment/add")
    public String addPaymentInfo(Model model) {
          model.addAttribute("paymentDTO",new PaymentDTO());
          return "payment";
    }

     @GetMapping("/payment/create")
     public RedirectView createPayment(HttpSession session, @ModelAttribute PaymentDTO paymentDTO) {
           String cancelUrl = "http://localhost:8080/payment/error";
           String successUrl = "http://localhost:8080/payment/execute";
           String intent = "sale";

            System.out.println("Method: "+paymentDTO.getMethod());

           paymentDTO.setCancelUrl(cancelUrl);
	        paymentDTO.setSuccessUrl(successUrl);
	        paymentDTO.setIntent(intent);

           session.setAttribute("paymentDTO",paymentDTO);
           Payment createdPayment = paymentService.createPayment(paymentDTO);
           for(Links link : createdPayment.getLinks()) {
                 if(link.getRel().equals("approval_url"))  
                     return new RedirectView(link.getHref());
           }
           return new RedirectView("/payment/error");
     }

     @GetMapping("/payment/execute")
     public RedirectView executePayment(
            PaymentPass paymentInfo, HttpSession session 
     ) {
           PaymentDTO paymentDTO= (PaymentDTO)  session.getAttribute("paymentDTO");
           System.out.println(paymentDTO.getMethod());
           Payment paymentResult =
                        paymentService.executePayment(paymentInfo);
            if(paymentResult.getState().equals("approved")) {
              storeReceipt = paymentService.extractReceipt(paymentDTO);
              return new RedirectView("/payment/success");
            } else {
                 return new RedirectView("/payment/error");
            }
      }

     @RequestMapping("/view/receipt")
      public String getReceipt(Model model) {
          model.addAttribute("receipt", storeReceipt);
          return "receipt";
      }


    @GetMapping("/payment/error")
    public String paymentError() {
         return "failure";
    }

   @GetMapping("/payment/success")
   public String paymentSuccess() {
        return "success";
    }
}