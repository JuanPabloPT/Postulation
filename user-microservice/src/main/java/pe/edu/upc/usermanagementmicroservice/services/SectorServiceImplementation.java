package pe.edu.upc.usermanagementmicroservice.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pe.edu.upc.usermanagementmicroservice.entity.Sector;
import pe.edu.upc.usermanagementmicroservice.repositories.SectorRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class SectorServiceImplementation implements SectorService {
    private SectorRepository sectorRepository;
    @Override
    public List<Sector> listAllSector() {
        return sectorRepository.findAll();
    }

    @Override
    public Sector getSector(Long id) {
        return sectorRepository.findById(id).orElse(null);
    }

    @Override
    public Sector createSector(Sector sector) {
        if(sector == null) return null;
        return sectorRepository.save(sector);
    }

    @Override
    public Sector updateSector(Sector sector) {
        Sector sectorDB = getSector(sector.getId());
        if(sector == null) return null;
        sectorDB.setDescription(sector.getDescription());
        sectorDB.setName(sector.getName());
        return sectorRepository.save(sectorDB);
    }

    @Override
    public void deleteSector(Sector sector) {
        if(sector == null) return;
        sectorRepository.delete(sector);
    }
}
