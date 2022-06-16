package pe.edu.upc.paymentservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.upc.paymentservice.entity.*;
import pe.edu.upc.paymentservice.model.Postulant;

import java.util.ArrayList;
import java.util.List;

public interface Postulant_SubscriptionRepository extends JpaRepository<Postulant_Subscription, Long> {

    public default Postulant_Subscription findByPostulant(Postulant postulant) {
        List<Postulant_Subscription> postulant_subscriptionList = this.findAll();
        for(Postulant_Subscription postulantListing : postulant_subscriptionList) {
            if(postulantListing.getPostulant().equals(postulant)) {
                return postulantListing;
            }
        }
        return null;
    }
    public default  List<Postulant_Subscription> findBySubscription(Subscription subscription) {
        List<Postulant_Subscription> postulant_subscriptionList = this.findAll();
        List<Postulant_Subscription> oneSpecificSubscription = new ArrayList<>();
        for(Postulant_Subscription es : postulant_subscriptionList) {
            if(es.getSubscription().equals(subscription)) {
                oneSpecificSubscription.add(es);
            }
        }
        return oneSpecificSubscription;
    }
    public default List<Postulant_Subscription> findByAllPostulant(Postulant postulant) {
        List<Postulant_Subscription> postulant_subscriptionList = this.findAll();
        List<Postulant_Subscription> oneSpecificPostulant = new ArrayList<>();
        for(Postulant_Subscription postulantListing : postulant_subscriptionList) {
            if(postulantListing.getPostulant().getId().equals(postulant.getId())) {
                oneSpecificPostulant.add(postulantListing);
            }
        }
        return oneSpecificPostulant;
    }
    public default Postulant_Subscription findLastSubscriptionPostulant(Postulant postulant) {
        List<Postulant_Subscription> oneSpecificPostulant = this.findByAllPostulant(postulant);

        return oneSpecificPostulant.get(oneSpecificPostulant.size()-1);
    }
}
