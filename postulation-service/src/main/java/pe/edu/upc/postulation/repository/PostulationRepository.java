package pe.edu.upc.postulation.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.upc.postulation.entity.Postulation;
import pe.edu.upc.postulation.model.JobOffer;
import pe.edu.upc.postulation.model.Postulant;

import java.util.ArrayList;
import java.util.List;

public interface PostulationRepository extends JpaRepository<Postulation,Long> {
    public Postulation findByNumberPostulation(String numberPostulation);

    public default List<Postulation> findByPostulant(Postulant postulant){
        List<Postulation> postulationList = this.findAll();
        List<Postulation> oneSpecificPostulant = new ArrayList<>();
        for(Postulation es : postulationList) {
            if(es.getPostulantId().equals(postulant)) {
                oneSpecificPostulant.add(es);
            }
        }
        return oneSpecificPostulant;
    };

    public default List<Postulation> findByJobOffer(JobOffer jobOffer){
        List<Postulation> postulationList = this.findAll();
        List<Postulation> oneSpecificJobOffer = new ArrayList<>();
        for(Postulation es : postulationList) {
            if(es.getJobOfferId().equals(jobOffer)) {
                oneSpecificJobOffer.add(es);
            }
        }
        return oneSpecificJobOffer;
    }

}
