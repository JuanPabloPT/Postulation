package pe.edu.upc.usermanagementmicroservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.upc.usermanagementmicroservice.entity.Company;
import pe.edu.upc.usermanagementmicroservice.entity.Sector;

import java.util.ArrayList;
import java.util.List;

public interface CompanyRepository extends JpaRepository<Company, Long> {
    public default List<Company> findBySector(Sector sector) {
        List<Company> companyList = this.findAll();
        List<Company> companyList1 = new ArrayList<>();
        for(Company company : companyList) {
            if(company.getSector().getId() != sector.getId())
                companyList1.add(company);
        }
        return companyList1;
    }
}
