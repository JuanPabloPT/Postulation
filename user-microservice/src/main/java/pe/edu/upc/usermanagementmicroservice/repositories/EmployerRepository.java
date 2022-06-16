package pe.edu.upc.usermanagementmicroservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.upc.usermanagementmicroservice.entity.Employer;

public interface EmployerRepository extends JpaRepository<Employer, Long> {
}
