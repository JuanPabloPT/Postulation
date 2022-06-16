package pe.edu.upc.paymentservice;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import pe.edu.upc.paymentservice.entity.Subscription;
import pe.edu.upc.paymentservice.model.Postulant;
import pe.edu.upc.paymentservice.repository.*;

import java.util.Date;

@DataJpaTest
public class SubscriptionRepositoryMockTest {

    @Autowired
    private EmployerRepository employerRepository;
    @Autowired
    private PostulantRepository postulantRepository;
    @Autowired
    private SubscriptionRepository subscriptionRepository;
    @Autowired
    private Employer_SubscriptionRepository employer_subscriptionRepository;
    @Autowired
    private Postulant_SubscriptionRepository postulant_subscriptionRepository;
    @Test
    public void test() {
        Employer employer = Employer.builder()
                .firstName("Djalma")
                .lastName("Dioses")
                .dni("123456")
                .email("dioses@gmail.com")
                .numberPhone("9924234232")
                .password("djalma")
                .build();
        employerRepository.save(employer);

        Postulant postulant = Postulant.builder()
                .firstName("Diego")
                .lastName("Emirio")
                .email("diego@gmail.com")
                .password("deigo")
                .number("Djalma")
                .birthday(new Date(System.currentTimeMillis()))
                .civilStatus("Soletro")
                .document("6542423")
                .build();
        postulantRepository.save(postulant);

        Subscription subscription = Subscription.builder()
                .name("Silver")
                .description("Una subscription con 5 postulaciones como max almes")
                .duration("1")
                .limitPostulations("20")
                .build();
        subscriptionRepository.save(subscription);

        Employer_Subscription employer_subscriptionRepositoryTest = Employer_Subscription.builder()
                .employer(employerRepository.getById(1L))
                .subscription(subscriptionRepository.getById(1L))
                .date(new Date(System.currentTimeMillis()))
                .build();

        employer_subscriptionRepository.save(employer_subscriptionRepositoryTest);

        Employer employerTest = employerRepository.getById(1L);
        Subscription subscriptionTest = subscriptionRepository.getById(1L);
        Postulant postulantTest = postulantRepository.getById(1L);
        Employer_Subscription employer_subscriptionTest = employer_subscriptionRepository.getById(1L);

        Assertions.assertThat(employerTest.getFirstName()).isEqualTo(employer.getFirstName());
        Assertions.assertThat(postulantTest.getDocument()).isEqualTo(postulant.getDocument());
        Assertions.assertThat(subscriptionTest.getLimitPostulations()).isEqualTo(subscription.getLimitPostulations());
        Assertions.assertThat(employer_subscriptionTest.getEmployer().getFirstName()).isEqualTo(employerTest.getFirstName());
    }
}
