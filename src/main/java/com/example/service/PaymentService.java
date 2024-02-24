package com.example.service;

import com.example.client.OrderClient;
import com.example.client.StockClient;
import com.example.entity.Payment;
import com.example.repository.PaymentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class PaymentService {

    private final PaymentRepository paymentRepository;
    private final StockClient stockClient;
    private final OrderClient orderClient;

    @Transactional
    public String create(String userId, Long orderId){
        Payment payment = Payment.builder()
                .orderId(orderId)
                .userId(userId)
                .build();


        Payment saved = paymentRepository.save(payment);
        //결제 성공했을 경우-80%
        //랜덤한 확률을 계산후 결제 실패 여부를 결정
        Double probability = Math.random();
        if(0.2 < probability){
            return "success";
        }else{
            //어떻게 짜야하나?
            //결제 실패 했을 때 주문 삭제 요청
            orderClient.cancel(orderId);
            //db에서도 삭제
            paymentRepository.deleteById(orderId);
            return "fail";
        }
    }

}
