package pe.edu.upc.paymentservice.service;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.paymentservice.client.PostulantClient;
import pe.edu.upc.paymentservice.entity.*;
import pe.edu.upc.paymentservice.model.Postulant;
import pe.edu.upc.paymentservice.repository.Postulant_SubscriptionRepository;

import java.util.List;
@Service
@AllArgsConstructor
public class Postulant_SubscriptionServiceImplementation implements Postulant_SubscriptionService{
    @Autowired
    private Postulant_SubscriptionRepository postulant_subscriptionRepository;

    @Autowired
    PostulantClient postulantClient;
    @Override
    public List<Postulant_Subscription> getAllPostulant_Subscription() {
        List<Postulant_Subscription> postulant_subscriptions = postulant_subscriptionRepository.findAll();
        postulant_subscriptions.forEach(postulant_subscription ->  {
            postulant_subscription.setPostulant(postulantClient.getPostulant(postulant_subscription.getPostulantId()).getBody());
        });
        if(postulant_subscriptions == null) {return null;}
        return postulant_subscriptions;
    }

    @Override
    public List<Postulant_Subscription> getPostulant_Subscription(Postulant postulant) {
        List<Postulant_Subscription> postulant_subscriptions = postulant_subscriptionRepository.findByAllPostulant(postulant);
        postulant_subscriptions.forEach(postulant_subscription ->  {
            postulant_subscription.setPostulant(postulantClient.getPostulant(postulant_subscription.getPostulantId()).getBody());
        });
        return  postulant_subscriptions;
    }

    @Override
    public Postulant_Subscription createPostulant_Subscription(Postulant_Subscription postulant_subscription) {
        if(postulant_subscription == null) return null;
        return postulant_subscriptionRepository.save(postulant_subscription);
    }

    @Override
    public Postulant_Subscription updatePostulant_Subscription(Postulant_Subscription postulant_subscription) {
        if(postulant_subscription == null) return null;
        Postulant_Subscription postulant_subscriptionDB = postulant_subscriptionRepository.getById(postulant_subscription.getId());
        if(postulant_subscriptionDB == null) return null;
        postulant_subscriptionDB.setPostulant(postulant_subscription.getPostulant());
        postulant_subscriptionDB.setSubscription(postulant_subscription.getSubscription());
        postulant_subscriptionDB.setDate(postulant_subscription.getDate());
        return postulant_subscriptionRepository.save(postulant_subscriptionDB);
    }

    @Override
    public List<Postulant_Subscription> findBySubscription(Subscription subscription) {
        List<Postulant_Subscription> postulant_subscriptions = postulant_subscriptionRepository.findBySubscription(subscription);

        postulant_subscriptions.forEach(postulant_subscription ->  {
            postulant_subscription.setPostulant(postulantClient.getPostulant(postulant_subscription.getPostulantId()).getBody());
        });
        return postulant_subscriptions;
    }

    @Override
    public void deletePostulant_Subscription(Long id) {
        Postulant_Subscription postulant_subscription = this.findSubscription(id);
        if(postulant_subscription == null) return;
        postulant_subscriptionRepository.delete(postulant_subscription);
    }

    @Override
    public Postulant_Subscription findSubscription(Long id) {
        Postulant_Subscription postulant_subscription = postulant_subscriptionRepository.findById(id).orElse(null);
        if(postulant_subscription == null) return null;
        return postulant_subscription;
    }

    @Override
    public Postulant_Subscription findPostulant_LastSubscription(Postulant postulant) {
        Postulant_Subscription postulant_subscription = postulant_subscriptionRepository.findLastSubscriptionPostulant(postulant);
        if(postulant_subscription == null) return null;
        return  postulant_subscription;
    }
}
