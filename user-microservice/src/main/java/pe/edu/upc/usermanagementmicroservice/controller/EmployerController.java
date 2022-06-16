package pe.edu.upc.usermanagementmicroservice.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.usermanagementmicroservice.entity.Employer;
import pe.edu.upc.usermanagementmicroservice.services.EmployerService;

import java.util.List;
@Slf4j
@RestController
@RequestMapping(value = "/employer")
public class EmployerController {
    @Autowired
    private EmployerService employerService;

    @GetMapping
    public ResponseEntity<List<Employer>> getListEmployer() {
        log.info("Fetching All Employer!");
        List<Employer> employerList = employerService.listAllEmployer();
        if(employerList == null) {
            log.error("Employer list is null!");
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(employerList);
    }
    @GetMapping(value = "/{id}")
    public ResponseEntity<Employer> getEmployer(@PathVariable("id")Long id) {
        log.info("Fetching specific Employer!");
        Employer employer = employerService.getEmployer(id);
        if(employer == null) {
            log.error("Employer do not exist with this id!");
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(employer);
    }
    @PostMapping
    public ResponseEntity<Employer> createEmployer(@RequestBody Employer employer){
        log.info("Creating Employer!");
        if(employer == null)  {
            log.error("Employer is null!");
            return ResponseEntity.noContent().build();
        }
        employerService.createEmployer(employer);
        return ResponseEntity.status(HttpStatus.CREATED).body(employer);
    }
    @PutMapping(value = "/{id}")
    public ResponseEntity<Employer> updateEmployer(@PathVariable("id")Long id, @RequestBody Employer employer) {
        log.info("Updating specific Employer with id {}",id);
        if(id == null) {
            log.error("The id Employer is null!");
            ResponseEntity.noContent().build();
        }
        if(employer == null) {
            log.error("Employer with this id is null!");
            ResponseEntity.noContent().build();
        }
        employer.setId(id);
        employerService.updateEmployer(employer);
        return ResponseEntity.status(HttpStatus.GONE).body(employer);
    }
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Employer> deleteEmployer(@PathVariable("id")Long id) {
        log.info("Deleting specific Employer with id {}",id);
        if(id == null) {
            log.error("The Employer id is null");
            return ResponseEntity.noContent().build();
        }
        Employer employer = employerService.getEmployer(id);
        if(employer == null) {
            log.error("Employer with this id is null!");
            return ResponseEntity.noContent().build();
        }
        employerService.deleteEmployer(employer);
        return ResponseEntity.status(HttpStatus.OK).body(employer);
    }
}
