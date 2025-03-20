package com.payment.api.service;

import com.paypal.api.payments.*;
import java.util.*;
import com.paypal.base.rest.*;
import java.text.*;
import com.payment.api.dto.*;
import com.payment.api.mapper.*;
import java.time.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentService
{

   @Autowired
	private APIContext apiContext;
	 @Autowired
    private ReceiptMapper receiptMapper;

	//create the payment
	public Payment createPayment(
	    PaymentDTO paymentDto
	) {
	
	  try {
		 Amount amount = new Amount();
		
		DecimalFormat df = new DecimalFormat("0.00", DecimalFormatSymbols.getInstance(Locale.US));
      df.setGroupingUsed(false);  // Ensure no thousand separators

      amount.setTotal(df.format(paymentDto.getTotal()));  // Ensures "45.00"
      amount.setCurrency(paymentDto.getCurrency());
		
		Transaction transaction = new Transaction();
		transaction.setAmount(amount);
		
		transaction.setDescription(paymentDto.getDesc());
		
		List<Transaction> transactions = new ArrayList<>();
		transactions.add(transaction);
		
		Payer payer = new Payer();
		payer.setPaymentMethod(paymentDto.getMethod().toLowerCase());
	
		
		Payment payment = new Payment();
		
		payment.setIntent(paymentDto.getIntent());
		
		RedirectUrls urls = new RedirectUrls();
		urls.setCancelUrl(paymentDto.getCancelUrl());
		urls.setReturnUrl(paymentDto.getSuccessUrl());
		
		payment.setRedirectUrls(urls);
		payment.setPayer(payer);
		payment.setTransactions(transactions);
		
		return payment.create(apiContext);
	 }
	 catch(PayPalRESTException ex) {
		 ex.printStackTrace();
	 }
	 return new Payment();
	}
	
	
	//execute the payment
	public Payment executePayment(PaymentPass paymentInfo) {
	 try {	 
	   PaymentExecution paymentExec = new PaymentExecution();
	   paymentExec.setPayerId(paymentInfo.getPayerID());
	   
	   
	   Payment payment = new Payment();
	   payment.setId(paymentInfo.getPaymentId());
	   
	   return payment.execute(apiContext,paymentExec);
	 }
	 catch(PayPalRESTException ex) {
		 ex.printStackTrace();
	 }
	 return new Payment();
	}

   public ReceiptDTO extractReceipt(PaymentDTO paymentDTO) {
             if(!Objects.isNull(paymentDTO)) {
                  LocalDate date = LocalDate.now(); //transaction date
                  LocalTime time = LocalTime.now(); //transaction time
                  ReceiptDTO receipt = receiptMapper.convert_paymentdetails_to_receipt(paymentDTO);
                  receipt.setDate(date);
                  receipt.setTime(time);
            
           String currencyCode = paymentDTO.getCurrency();
	        for(Locale l: Locale.getAvailableLocales()) {
		           NumberFormat n = NumberFormat.getCurrencyInstance(l);
		           java.util.Currency curObj = n.getCurrency();
		      if(curObj.getCurrencyCode().equals(currencyCode)) {
	              receipt.setTotal(n.format(paymentDTO.getTotal()));
			        break;
		          }
	          }
              return receipt;
             }
            return new ReceiptDTO();
   }
}
