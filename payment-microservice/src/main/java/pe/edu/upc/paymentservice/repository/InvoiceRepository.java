package pe.edu.upc.paymentservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.upc.paymentservice.entity.Invoice;
import pe.edu.upc.paymentservice.model.Postulant;

import java.util.ArrayList;
import java.util.List;

public interface InvoiceRepository extends JpaRepository<Invoice, Long> {
    public default List<Invoice> findByAllPostulant(Postulant postulant) {
        List<Invoice> invoiceList = this.findAll();
        List<Invoice> oneSpecificPostulant = new ArrayList<>();
        for(Invoice postulantListing : invoiceList) {
            if(postulantListing.getPostulantId().equals(postulant.getId())) {
                oneSpecificPostulant.add(postulantListing);
            }
        }
        return oneSpecificPostulant;
    }
}
