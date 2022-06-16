package pe.edu.upc.paymentservice.service;

import pe.edu.upc.paymentservice.entity.Invoice;

import java.util.List;

public interface InvoiceService {
    public List<Invoice> getAllInvoice();
    public Invoice getInvoiceById(Invoice invoice);
    public List<Invoice> getInvoiceByPostulantId(Long id);
    public Invoice createInvoice(Invoice invoice);
    public Invoice updateInvoice(Invoice invoice);
    public void deleteInvoice(Invoice invoice);
}
