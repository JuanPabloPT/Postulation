package pe.edu.upc.postulation.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.postulation.client.PostulantClient;
import pe.edu.upc.postulation.entity.Postulation;
import pe.edu.upc.postulation.model.Postulant;
import pe.edu.upc.postulation.repository.PostulationRepository;

import java.util.List;

@Slf4j
@Service
public class PostulationServiceImpl implements PostulationService {

    @Autowired
    PostulationRepository postulationRepository;

    @Autowired
    PostulantClient postulantClient;

    //@Autowired
    //JobOfferClient jobOfferClient;

    @Override
    public List<Postulation> findPostulationAll() {
        return postulationRepository.findAll();
    }

    @Override
    public Postulation createPostulation(Postulation postulation){
        Postulation postulationDB = postulationRepository.findByNumberPostulation(postulation.getNumberPostulation());
        if(postulationDB!=null){
            return postulationDB;
        }
        return postulationRepository.save(postulation);
    }

    @Override
    public void deletePostulation(Long id){
        Postulation postulation = this.getPostulation(id);
        if (postulation==null){
            return; }
        postulationRepository.delete(postulation);
    }

    /*@Override
    public Postulation getPostulation(Long id){
        Postulation postulation = postulationRepository.findById(id).orElse(null);
        if (postulation != null){
            //JobOffer jobOffer = jobOfferClient.getJobOffer(postulation.getJobOfferId()).getBody();
            //postulation.setJobOffer(jobOffer);

            //List<PostulantsCV> listpostulants =postulation.getList().stream().map(postulantsCV -> {
            //    CV cv = postulantClient.getCV(postulantsCV.getPostulantCVId()).getBody();
            //    postulantsCV.setCv(cv);
            //    return postulantsCV;
            //}).collect(Collectors.toList());
            //postulation.setList(listpostulants);
        }
        return postulation;
    }*/

    @Override
    public Postulation getPostulation(Long id) {
        return postulationRepository.findById(id).orElse(null);
    }

    @Override
    public List<Postulation> getPostulationsByPostulant(Postulant postulant){
        List<Postulation> postulations = postulationRepository.findByPostulant(postulant);

        postulations.forEach(postulation -> {
            postulation.setPostulant(postulantClient.getPostulant(postulation.getPostulantId()).getBody());
        });
        return postulations;
    }

}
