package pe.edu.upc.usermanagementmicroservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.upc.usermanagementmicroservice.entity.Sector;

public interface SectorRepository extends JpaRepository<Sector, Long> {
}
