package pe.edu.upc.usermanagementmicroservice.services;

import pe.edu.upc.usermanagementmicroservice.entity.CV;

import java.util.List;

public interface CVService {
    public List<CV> findAllCV();
    public CV getCV(Long id);
    public CV createCV(CV cv);
    public CV updateCV(CV cv);
    public CV deleteCV(Long id);
}
