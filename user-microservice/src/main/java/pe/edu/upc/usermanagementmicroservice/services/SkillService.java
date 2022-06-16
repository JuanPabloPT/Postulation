package pe.edu.upc.usermanagementmicroservice.services;

import pe.edu.upc.usermanagementmicroservice.entity.Skill;

import java.util.List;

public interface SkillService {
    public List<Skill> findAllSkills();
    public Skill getSkill(Long id);
    public Skill createSkill(Skill skill);
    public Skill updateSkill(Skill skill);
    public Skill deleteSkill(Long id);
}
