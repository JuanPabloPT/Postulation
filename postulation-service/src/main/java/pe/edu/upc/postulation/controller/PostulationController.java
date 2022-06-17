package pe.edu.upc.postulation.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import pe.edu.upc.postulation.entity.Postulation;
import pe.edu.upc.postulation.service.PostulationService;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Slf4j
@RestController
@RequestMapping("/postulation")
public class PostulationController {

    @Autowired
    private PostulationService postulationService;

    @GetMapping
    public ResponseEntity<List<Postulation>> listAllPostulation() {
        List<Postulation> postulations = postulationService.findPostulationAll();
        if (postulations.isEmpty()) {
            return  ResponseEntity.noContent().build();
        }
        return  ResponseEntity.ok(postulations);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Postulation> getPostulation(@PathVariable("id") long id) {
        log.info("Fetching Postulation with id {}", id);
        Postulation postulation  = postulationService.getPostulation(id);
        if (null == postulation) {
            log.error("Postulation with id {} not found.", id);
            return  ResponseEntity.notFound().build();
        }
        return  ResponseEntity.ok(postulation);
    }

    @PostMapping
    public ResponseEntity<Postulation> createPostulation(@RequestBody Postulation postulation) {
        if (postulation == null) return ResponseEntity.noContent().build();
        postulationService.createPostulation (postulation);

        return  ResponseEntity.status( HttpStatus.CREATED).body(postulation);
    }

    @DeleteMapping(value = "/{id}")
    public void deletePostulation(@PathVariable("id") Long id) {
        postulationService.deletePostulation(id);
    }

}
