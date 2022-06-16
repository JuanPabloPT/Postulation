package pe.edu.upc.paymentservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.upc.paymentservice.entity.Subscription;

public interface SubscriptionRepository extends JpaRepository<Subscription, Long> {
}
