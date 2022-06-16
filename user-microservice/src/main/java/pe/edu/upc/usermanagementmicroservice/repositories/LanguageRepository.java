package pe.edu.upc.usermanagementmicroservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.upc.usermanagementmicroservice.entity.Language;

import java.util.List;

public interface LanguageRepository extends JpaRepository<Language, Long> {
    public List<Language> findByName(String name);
}
