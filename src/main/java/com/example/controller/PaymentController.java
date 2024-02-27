package com.example.controller;

import com.example.dto.PaymentRequestDTO;
import com.example.service.PaymentService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/PaymentService")
public class PaymentController {
    private final PaymentService paymentService;

    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    //결제
    @PostMapping("/payment")
    public ResponseEntity<String> create(@RequestHeader("x-username") String userId, @Valid @RequestBody PaymentRequestDTO payment){
        System.out.println(userId);
        String result = paymentService.create(userId,payment.getOrderId());

        if(result.equals("fail")){
            return ResponseEntity.badRequest().body("결제에 실패했습니다.");
        }
        return ResponseEntity.ok().body("결제에 성공하였습니다.");
    }

}
