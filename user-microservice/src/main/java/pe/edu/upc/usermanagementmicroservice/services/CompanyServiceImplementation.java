package pe.edu.upc.usermanagementmicroservice.services;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.usermanagementmicroservice.entity.Company;
import pe.edu.upc.usermanagementmicroservice.entity.Sector;
import pe.edu.upc.usermanagementmicroservice.repositories.CompanyRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class CompanyServiceImplementation implements CompanyService {
    @Autowired
    private CompanyRepository companyRepository;
    @Override
    public List<Company> listAllCompany() {
        return companyRepository.findAll();
    }

    @Override
    public Company getCompany(Long id) {
        return companyRepository.findById(id).orElse(null);
    }

    @Override
    public Company createCompany(Company company) {
        return companyRepository.save(company);
    }

    @Override
    public Company updateCompany(Company company) {
        Company companyDB = getCompany(company.getId());
        if(companyDB == null) return null;
        companyDB.setName(company.getName());
        companyDB.setCountry(company.getCountry());
        companyDB.setCity(company.getCity());
        companyDB.setDescription(company.getDescription());
        companyDB.setDirection(company.getDirection());
        companyDB.setDistrict(company.getDistrict());
        companyDB.setEmployer(company.getEmployer());
        companyDB.setLogo(company.getLogo());
        companyDB.setRuc(company.getRuc());
        companyDB.setSector(company.getSector());
        return companyRepository.save(companyDB);
    }

    @Override
    public void deleteCompany(Company company) {
        Company companyDB = getCompany(company.getId());
        if(companyDB == null) return;
        companyRepository.delete(company);
    }

    @Override
    public List<Company> findBySector(Sector sector) {
        return companyRepository.findBySector(sector);
    }
}
