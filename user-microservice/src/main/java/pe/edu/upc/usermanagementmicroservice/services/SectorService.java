package pe.edu.upc.usermanagementmicroservice.services;

import pe.edu.upc.usermanagementmicroservice.entity.Sector;

import java.util.List;

public interface SectorService {
    public List<Sector> listAllSector();
    public Sector getSector(Long id);
    public Sector createSector(Sector sector);
    public Sector updateSector(Sector sector);
    public void deleteSector(Sector sector);
}
