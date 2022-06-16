package pe.edu.upc.paymentservice.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.paymentservice.entity.Payment;
import pe.edu.upc.paymentservice.service.PaymentService;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/payment")
public class PaymentController {
    @Autowired
    private PaymentService paymentService;
    @GetMapping
    public ResponseEntity<List<Payment>> getAllPayment() {
        List<Payment> paymentList = paymentService.getAllPayment();
        if(paymentList == null) return ResponseEntity.noContent().build();
        return ResponseEntity.ok(paymentList);
    }
    @GetMapping(value = "/{id}")
    public ResponseEntity<Payment> getPayment(@PathVariable("id")Long id) {
        Payment payment = paymentService.getPayment(id);
        if(payment == null) return ResponseEntity.noContent().build();
        return ResponseEntity.ok(payment);
    }
    @PostMapping
    public ResponseEntity<Payment> createPayment(@RequestBody Payment payment) {
        if(payment == null) return ResponseEntity.noContent().build();
        paymentService.createPayment(payment);
        return ResponseEntity.status(HttpStatus.CREATED).body(payment);
    }
    @PutMapping(value = "/{id}")
    public ResponseEntity<Payment> updatePayment(@PathVariable("id")Long id, @RequestBody Payment payment){
        if(id == null || payment == null) return ResponseEntity.noContent().build();
        payment.setId(id);
        paymentService.updatePayment(payment);
        return ResponseEntity.ok(payment);
    }
    @DeleteMapping(value = "/{id}")
    public void deletePayment(@PathVariable Long id) {
        Payment payment = paymentService.getPayment(id);
        if(payment == null) return;
        paymentService.deletePayment(payment);
    }
}
