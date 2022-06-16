package pe.edu.upc.paymentservice.service;

import pe.edu.upc.paymentservice.entity.*;
import pe.edu.upc.paymentservice.model.Postulant;

import java.util.List;

public interface Postulant_SubscriptionService {
    public List<Postulant_Subscription> getAllPostulant_Subscription();
    public List<Postulant_Subscription> getPostulant_Subscription(Postulant postulant);
    public Postulant_Subscription createPostulant_Subscription(Postulant_Subscription postulant_subscription);
    public Postulant_Subscription updatePostulant_Subscription(Postulant_Subscription postulant_subscription);
    public List<Postulant_Subscription> findBySubscription(Subscription subscription);
    public Postulant_Subscription findPostulant_LastSubscription(Postulant postulant);
    public void deletePostulant_Subscription(Long id);
    public  Postulant_Subscription findSubscription(Long id);

}
