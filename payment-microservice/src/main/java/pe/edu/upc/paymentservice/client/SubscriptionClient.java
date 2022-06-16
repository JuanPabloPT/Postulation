package pe.edu.upc.paymentservice.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import pe.edu.upc.paymentservice.model.Subscription;

@FeignClient(name = "subscription-service", path = "/subscription")
public interface SubscriptionClient {
    @GetMapping(value = "/{id}")
    public ResponseEntity<Subscription> getSubscription(@PathVariable("id")Long id);
}
