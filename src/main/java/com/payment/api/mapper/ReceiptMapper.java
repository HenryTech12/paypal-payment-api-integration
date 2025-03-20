package com.payment.api.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.payment.api.dto.*;
import org.modelmapper.ModelMapper;
import java.util.*;
@Service
public class ReceiptMapper {

      @Autowired
         private ModelMapper mapper;

       public ReceiptDTO convert_paymentdetails_to_receipt(PaymentDTO paymentDTO) {
                if(!Objects.isNull(paymentDTO)) 
                     return mapper.map(paymentDTO, ReceiptDTO.class);
                else
                     return null;
       }

}