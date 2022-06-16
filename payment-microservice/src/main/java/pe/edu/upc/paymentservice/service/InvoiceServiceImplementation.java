package pe.edu.upc.paymentservice.service;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.paymentservice.client.PostulantClient;
import pe.edu.upc.paymentservice.client.SubscriptionClient;
import pe.edu.upc.paymentservice.entity.Invoice;
import pe.edu.upc.paymentservice.entity.Payment;
import pe.edu.upc.paymentservice.model.Postulant;
import pe.edu.upc.paymentservice.repository.InvoiceRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class InvoiceServiceImplementation implements InvoiceService{
    @Autowired
    private SubscriptionClient subscriptionClient;
    @Autowired
    private PostulantClient postulantClient;
    @Autowired
    private InvoiceRepository invoiceRepository;


    @Override
    public List<Invoice> getAllInvoice() {
        List<Invoice> listInvoice = invoiceRepository.findAll();

        listInvoice.forEach(invoice -> {
            invoice.setPostulant(postulantClient.getPostulant(invoice.getPostulantId()).getBody());
            invoice.setSubscription(subscriptionClient.getSubscription(invoice.getSubscriptionId()).getBody());
        });

        return listInvoice;
    }

    @Override
    public Invoice getInvoiceById(Invoice invoice) {
        Invoice getInvoice = invoiceRepository.findById(invoice.getId()).orElse(null);
        if (getInvoice == null)
            return null;
        getInvoice.setSubscription(subscriptionClient.getSubscription(invoice.getSubscriptionId()).getBody());
        getInvoice.setPostulant(postulantClient.getPostulant(invoice.getPostulantId()).getBody());
        return getInvoice;
    }

    @Override
    public List<Invoice> getInvoiceByPostulantId(Long id) {
        Postulant postulant = postulantClient.getPostulant(id).getBody();
        if(postulant == null)
            return null;

        List<Invoice> invoiceList = this.invoiceRepository.findByAllPostulant(postulant);

        if(invoiceList == null)
            return null;
        invoiceList.forEach(invoice -> {
            invoice.setPostulant(postulantClient.getPostulant(invoice.getPostulantId()).getBody());
            invoice.setSubscription(subscriptionClient.getSubscription(invoice.getSubscriptionId()).getBody());
        });
        return invoiceList;
    }

    @Override
    public Invoice createInvoice(Invoice invoice) {
        if(invoice == null)
            return null;
        Invoice invoiceSave = invoiceRepository.save(invoice);
        return invoiceSave;
    }

    @Override
    public Invoice updateInvoice(Invoice invoice) {
        if(invoice == null) return null;
        Invoice invoiceDB = invoiceRepository.findById(invoice.getId()).orElse(null);
        invoiceDB.setDateOfBuy(invoice.getDateOfBuy());
        invoiceDB.setPostulantId(invoice.getPostulantId());
        invoiceDB.setSubscriptionId(invoice.getSubscriptionId());

        return invoiceRepository.save(invoiceDB);
    }

    @Override
    public void deleteInvoice(Invoice invoice) {
        if(invoice == null) return;
        invoiceRepository.delete(invoice);
    }
}
