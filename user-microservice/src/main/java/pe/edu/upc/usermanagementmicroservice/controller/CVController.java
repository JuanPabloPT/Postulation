package pe.edu.upc.usermanagementmicroservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.usermanagementmicroservice.entity.CV;

import pe.edu.upc.usermanagementmicroservice.services.CVService;

import java.util.List;

@RestController
@RequestMapping(value ="/cv")
public class CVController {
    @Autowired
    private CVService cvService;

    @GetMapping
    public ResponseEntity<List<CV>> getAllCV() {
        List<CV> cvList = cvService.findAllCV();
        if(cvList == null) return ResponseEntity.noContent().build();
        return ResponseEntity.ok(cvList);
    }
    @GetMapping(value = "/{id}")
    public ResponseEntity<CV> getCV(@PathVariable("id")Long id) {
        CV cv = cvService.getCV(id);
        if(cv == null) return ResponseEntity.noContent().build();
        return ResponseEntity.ok(cv);
    }
    @PostMapping
    public ResponseEntity<CV> createCV(@RequestBody CV cv) {
        if(cv == null) return ResponseEntity.noContent().build();
        cvService.createCV(cv);
        return ResponseEntity.status(HttpStatus.CREATED).body(cv);
    }
    @PutMapping(value = "/{id}")
    public ResponseEntity<CV> updateCV(@PathVariable("id")Long id, @RequestBody CV cv){
        if(id == null || cv == null) return ResponseEntity.noContent().build();
        cv.setId(id);
        cvService.updateCV(cv);
        return ResponseEntity.ok(cv);
    }
    @DeleteMapping(value = "/{id}")
    public void deleteCV(@PathVariable Long id) {
        CV cv = cvService.getCV(id);
        if(cv == null) return;
        cvService.deleteCV(id);
    }
}
