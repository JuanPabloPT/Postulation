package pe.edu.upc.paymentservice.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.paymentservice.entity.Invoice;
import pe.edu.upc.paymentservice.service.InvoiceService;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/invoice")
public class InvoiceController {
    @Autowired
    private InvoiceService invoiceService;

    @GetMapping
    public ResponseEntity<List<Invoice>> getAllInvoice() {
        List<Invoice> invoices = invoiceService.getAllInvoice();
        if(invoices == null) return ResponseEntity.noContent().build();
        return ResponseEntity.ok(invoices);
    }
    @GetMapping(value = "/{id}")
    public ResponseEntity<Invoice> getInvoiceById(@PathVariable("id") Long id) {
        Invoice invoice = invoiceService.getInvoiceById(Invoice.builder().id(id).build());
        if(invoice == null) return ResponseEntity.noContent().build();;
        return ResponseEntity.ok(invoice);
    }
    @GetMapping(value = "/{id}/postulant")
    public ResponseEntity<List<Invoice>> getAllInvoiceByPostulantId(@PathVariable("id") Long id) {
        List<Invoice> invoiceList = invoiceService.getInvoiceByPostulantId(id);
        if(invoiceList == null) return ResponseEntity.noContent().build();

        return ResponseEntity.ok(invoiceList);
    }
    @PostMapping
    public ResponseEntity<Invoice> createInvoice(@RequestBody Invoice invoice) {
        if(invoice == null) return ResponseEntity.noContent().build();
        invoiceService.createInvoice(invoice);
        return ResponseEntity.status(HttpStatus.CREATED).body(invoice);
    }
    @PutMapping(value = "/{id}")
    public ResponseEntity<Invoice> updateInvoice(@PathVariable("id")Long id, @RequestBody Invoice invoice){
        if(id == null || invoice == null) return ResponseEntity.noContent().build();
        invoice.setId(id);
        invoiceService.updateInvoice(invoice);
        return ResponseEntity.ok(invoice);
    }
    @DeleteMapping(value = "/{id}")
    public void deleteInvoice(@PathVariable Long id) {
        Invoice invoice = invoiceService.getInvoiceById(Invoice.builder().id(id).build());
        if(invoice == null) return;
        invoiceService.deleteInvoice(invoice);
    }
}
