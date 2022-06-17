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
        List<Postulation> postulations = postulationRepository.findAll();
        postulations.forEach(postulation -> {
            postulation.setPostulant(postulantClient.getPostulant(postulation.getPostulantId()).getBody());
        });
        if (postulations == null) {return null;}
        return postulations;
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
            return;
        }
        postulationRepository.delete(postulation);
    }

    @Override
    public Postulation getPostulation(Long id){
        Postulation postulation = postulationRepository.findById(id).orElse(null);
        postulation.setPostulant(postulantClient.getPostulant(postulation.getPostulantId()).getBody());
        if (postulation == null){
            return null;
        }
        return postulation;
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
