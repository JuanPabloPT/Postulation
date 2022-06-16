package pe.edu.upc.paymentservice.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.paymentservice.entity.*;
import pe.edu.upc.paymentservice.service.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/subscription")
public class SubscriptionController {
    @Autowired
    private SubscriptionService subscriptionService;
    @Autowired
    private Postulant_SubscriptionService postulantSubscriptionService;

    @GetMapping
    public ResponseEntity<List<Subscription>> getAllSubscription() {
        List<Subscription> subscriptionList = subscriptionService.getAllSubscription();
        if(subscriptionList == null) return ResponseEntity.noContent().build();
        return ResponseEntity.ok(subscriptionList);
    }
    @GetMapping(value = "/{id}")
    public ResponseEntity<Subscription> getSubscription(@PathVariable("id")Long id) {
        Subscription subscription = subscriptionService.getSubscription(id);
        if(subscription == null) return ResponseEntity.noContent().build();
        return ResponseEntity.ok(subscription);
    }
    @PostMapping
    public ResponseEntity<Subscription> createSubscription(@RequestBody Subscription subscription) {
        if(subscription == null) return ResponseEntity.noContent().build();
        subscriptionService.createSubscription(subscription);
        return ResponseEntity.status(HttpStatus.CREATED).body(subscription);
    }
    @PutMapping(value = "/{id}")
    public ResponseEntity<Subscription> updateSubscription(@PathVariable("id")Long id, @RequestBody Subscription subscription){
        if(id == null || subscription == null) return ResponseEntity.noContent().build();
        subscription.setId(id);
        subscriptionService.updateSubscription(subscription);
        return ResponseEntity.ok(subscription);
    }
    @DeleteMapping(value = "/{id}")
    public void deleteSubscription(@PathVariable Long id) {
        Subscription subscription = subscriptionService.getSubscription(id);
        if(subscription == null) return;
        subscriptionService.deleteSubscription(subscription);
    }

    @GetMapping(value = "/postulant")
    public ResponseEntity<List<Postulant_Subscription>> getAllSubscriptionPostulant() {
        List<Postulant_Subscription> postulantSubscriptionList = postulantSubscriptionService.getAllPostulant_Subscription();
        if(postulantSubscriptionList == null) return ResponseEntity.noContent().build();
        return ResponseEntity.ok(postulantSubscriptionList);
    }

    @GetMapping(value = "/{id}/postulant")
    public ResponseEntity<List<Postulant_Subscription>> getAllSubscriptionByIdPostulant(@PathVariable("id") Long id) {
        Subscription subscription = subscriptionService.getSubscription(id);
        if(subscription == null) return ResponseEntity.noContent().build();

        List<Postulant_Subscription> postulantSubscriptionList = postulantSubscriptionService.findBySubscription(subscription);
        if(postulantSubscriptionList == null) return ResponseEntity.noContent().build();
        return ResponseEntity.ok(postulantSubscriptionList);
    }

    @PostMapping(value = "/postulant")
    public ResponseEntity<Postulant_Subscription> createSubscription(@RequestBody Postulant_Subscription postulant_subscription) {
        if(postulant_subscription == null) return ResponseEntity.noContent().build();
        Subscription subscription = subscriptionService.getSubscription(postulant_subscription.getSubscription().getId());
        if(subscription == null) return ResponseEntity.noContent().build();


        Postulant_Subscription employerSubscription = postulantSubscriptionService.createPostulant_Subscription(postulant_subscription);
        return ResponseEntity.status(HttpStatus.CREATED).body(employerSubscription);
    }

    @DeleteMapping(value = "/postulant/{id}")
    public void deleteSubscriptionPostulant(@PathVariable Long id) {
        postulantSubscriptionService.deletePostulant_Subscription(id);
    }

}
