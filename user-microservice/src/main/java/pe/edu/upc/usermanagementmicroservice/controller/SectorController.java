package pe.edu.upc.usermanagementmicroservice.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.usermanagementmicroservice.entity.Sector;
import pe.edu.upc.usermanagementmicroservice.services.SectorService;

import java.util.List;
@Slf4j
@RestController
@RequestMapping(value ="/sector")
public class SectorController {
    @Autowired
    private SectorService sectorService;

    @GetMapping
    public ResponseEntity<List<Sector>> listSector() {
        log.info("Fetching All Sector!");
        List<Sector> sectorList = sectorService.listAllSector();
        if (sectorList == null) {
            log.error("Sector list is null!");
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(sectorList);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Sector> getSector(@PathVariable("id") Long id) {
        log.info("Fetching specific Sector!");
        Sector sector = sectorService.getSector(id);
        if (sector == null) {
            log.error("Sector do not exist with this id!");
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(sector);
    }

    @PostMapping
    public ResponseEntity<Sector> createSector(@RequestBody Sector sector) {
        log.info("Creating Sector!");
        if (sector == null) {
            log.error("Sector is null!");
            return ResponseEntity.noContent().build();
        }
        sectorService.createSector(sector);
        return ResponseEntity.status(HttpStatus.CREATED).body(sector);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Sector> updateSector(@PathVariable("id") Long id, @RequestBody Sector sector) {
        log.info("Sector specific Sector with id {}",id);
        if(id == null) {
            log.error("The id Sector is null!");
            return ResponseEntity.noContent().build();
        }
        sector.setId(id);
        Sector sectorDB = sectorService.updateSector(sector);
        if (sectorDB == null) {
            log.error("Sector with this id is null!");
            ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(sectorDB);
    }
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Sector> deleteSector(@PathVariable("id")Long id) {
        log.info("Deleting specific Sector with id {}",id);
        if(id == null) {
            log.error("The Sector id is null!");
            return ResponseEntity.noContent().build();
        }
        Sector sector = sectorService.getSector(id);
        if(sector == null) {
            log.error("Sector with this id is null!");
            return ResponseEntity.noContent().build();
        }
        sectorService.deleteSector(sector);
        return ResponseEntity.status(HttpStatus.OK).body(sector);
    }

}
