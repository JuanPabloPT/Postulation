package pe.edu.upc.usermanagementmicroservice.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.usermanagementmicroservice.entity.Company;
import pe.edu.upc.usermanagementmicroservice.entity.Sector;
import pe.edu.upc.usermanagementmicroservice.services.CompanyService;

import javax.validation.Valid;
import java.util.List;
@Slf4j
@RestController
@RequestMapping(value = "/company")
public class CompanyController {
    @Autowired
    private CompanyService companyService;

    @GetMapping
    public ResponseEntity<List<Company>> getAllCompany(@RequestParam(name = "sectorId", required = false)Long sectorId) {
        log.info("Fetching All Company!");
        List<Company> companyList;
        if(sectorId == null) {
            companyList = companyService.listAllCompany();
            if(companyList == null) {
                log.error("Company list is null!");
                return ResponseEntity.noContent().build();
            }
        } else {
            companyList = companyService.findBySector(Sector.builder().id(sectorId).build());
            if(companyList == null) {
                log.error("Company do not find with Sector ID "+sectorId+"!");
                return ResponseEntity.noContent().build();
            }
        }
        return ResponseEntity.ok(companyList);
    }
    @GetMapping(value = "/{id}")
    public ResponseEntity<Company> getCompany(@PathVariable("id")Long id) {
        log.info("Fetching specific Company!");
        if(id == null)  {
            log.error("Company id is null");
            return ResponseEntity.noContent().build();
        }
        Company company = companyService.getCompany(id);
        if(company == null)  {
            log.error("Company do not exist with this id!");
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(company);
    }
    @PostMapping
    public ResponseEntity<Company> createCompany(@Valid @RequestBody Company company, BindingResult result) {
        log.info("Creating Company!");
        //Company companyDB = companyService.getCompany(company.getId());

        if(company == null)  {
            log.error("Company is null!");
            return ResponseEntity.noContent().build();
        }
        companyService.createCompany(company);
        return ResponseEntity.status(HttpStatus.CREATED).body(company);
    }
    @PutMapping(value = "/{id}")
    public ResponseEntity<Company> updateCompany(@PathVariable("id")Long id, @RequestBody Company company) {
        log.info("Updating Company with id {}",id);
        if(id == null)  {
            log.error("Update id Company is null");
            return ResponseEntity.noContent().build();
        }
        if(company == null)  {
            log.error("The Company is null");
            return ResponseEntity.noContent().build();
        }
        company.setId(id);
        companyService.updateCompany(company);
        return ResponseEntity.ok(company);
    }
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Company> deleteCompany(@PathVariable("id") Long id) {
        log.info("Deleting Company with id {}",id);
        Company companyDB = companyService.getCompany(id);
        if(companyDB == null) {
            log.error("Company with this id is null!");
            return ResponseEntity.noContent().build();
        }
        companyService.deleteCompany(companyDB);
        return ResponseEntity.status(HttpStatus.OK).body(companyDB);
    }

}
