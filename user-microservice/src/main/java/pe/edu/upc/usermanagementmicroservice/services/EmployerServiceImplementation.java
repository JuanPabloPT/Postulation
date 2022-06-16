package pe.edu.upc.usermanagementmicroservice.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pe.edu.upc.usermanagementmicroservice.entity.Employer;
import pe.edu.upc.usermanagementmicroservice.repositories.EmployerRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class EmployerServiceImplementation implements EmployerService{
    private EmployerRepository employerRepository;
    @Override
    public List<Employer> listAllEmployer() {
        return employerRepository.findAll();
    }

    @Override
    public Employer getEmployer(Long id) {
        return employerRepository.findById(id).orElse(null);
    }

    @Override
    public Employer createEmployer(Employer employer) {
        if(employer == null) return null;

        return employerRepository.save(employer);
    }

    @Override
    public Employer updateEmployer(Employer employer) {
        if(employer == null) return null;
        Employer employerDB = getEmployer(employer.getId());
        employerDB.setEmail(employer.getEmail());
        employerDB.setFirstName(employer.getFirstName());
        employerDB.setDni(employer.getDni());
        employerDB.setLastName(employer.getLastName());
        employerDB.setPassword(employer.getPassword());
        employerDB.setNumberPhone(employer.getNumberPhone());

        return employerRepository.save(employerDB);
    }

    @Override
    public void deleteEmployer(Employer employer) {
        if(employer == null) return;
        employerRepository.delete(employer);
    }
}
