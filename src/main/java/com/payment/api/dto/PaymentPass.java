package com.payment.api.dto;

public class PaymentPass {
   
       private String PayerID;
       private String paymentId;

        public void setPayerID(String PayerID) {
	          this.PayerID = PayerID;
	    }

	    public String getPayerID() {
	          return PayerID;
	   }

	   public void setPaymentId(String paymentId) {
		       this.paymentId = paymentId;
	   }

	   public String getPaymentId() {
		     return paymentId;
	   }

      @Override
	   public String toString() {
		    return "[ PaymentID: "+paymentId + ", PayerID: "+PayerID+" ]";
	  }
}