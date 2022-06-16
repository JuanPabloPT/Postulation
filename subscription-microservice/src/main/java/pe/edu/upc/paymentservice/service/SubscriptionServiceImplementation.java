package pe.edu.upc.paymentservice.service;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.paymentservice.entity.Subscription;
import pe.edu.upc.paymentservice.repository.SubscriptionRepository;

import java.util.List;
@Service
@AllArgsConstructor
public class SubscriptionServiceImplementation implements SubscriptionService {
    @Autowired
    private SubscriptionRepository subscriptionRepository;
    @Override
    public List<Subscription> getAllSubscription() {
        List<Subscription> subscriptionList = subscriptionRepository.findAll();
        if(subscriptionList == null) return null;
        return subscriptionList;
    }

    @Override
    public Subscription getSubscription(Long id) {
        Subscription subscription = subscriptionRepository.findById(id).orElse(null);
        if(subscription == null) return null;
        return subscription;
    }

    @Override
    public Subscription createSubscription(Subscription subscription) {
        if(subscription == null) return null;
        return subscriptionRepository.save(subscription);
    }

    @Override
    public Subscription updateSubscription(Subscription subscription) {
        if(subscription == null) return null;
        Subscription subscriptionDB = subscriptionRepository.findById(subscription.getId()).orElse(null);
        subscriptionDB.setDescription(subscription.getDescription());
        subscriptionDB.setDuration(subscription.getDuration());
        subscriptionDB.setName(subscription.getName());
        subscriptionDB.setLimitPostulations(subscription.getLimitPostulations());

        return subscriptionRepository.save(subscriptionDB);
    }

    @Override
    public void deleteSubscription(Subscription subscription) {
        if(subscription == null) return;
        subscriptionRepository.delete(subscription);
    }
}
