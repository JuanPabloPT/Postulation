package pe.edu.upc.usermanagementmicroservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.upc.usermanagementmicroservice.entity.Skill;

import java.util.List;

public interface SkillRepository extends JpaRepository<Skill, Long> {
    public List<Skill> findByName(String name);
}
