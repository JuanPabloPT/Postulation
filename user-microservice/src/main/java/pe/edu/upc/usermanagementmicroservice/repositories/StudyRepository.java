package pe.edu.upc.usermanagementmicroservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.upc.usermanagementmicroservice.entity.Study;

import java.util.List;

public interface StudyRepository extends JpaRepository<Study, Long> {
    public List<Study> findByName(String name);
}
