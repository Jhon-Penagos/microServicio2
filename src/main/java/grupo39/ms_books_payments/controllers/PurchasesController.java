package grupo39.ms_books_payments.controllers;


import grupo39.ms_books_payments.controllers.model.PurchaseRequest;
import grupo39.ms_books_payments.data.model.Purchases;
import grupo39.ms_books_payments.services.PurchaseService;
import grupo39.ms_books_payments.services.PurchaseServiceImp;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/purchases")
public class PurchasesController {
    @Autowired
    private PurchaseService purchaseService;

    @PostMapping("/purchase")
    public ResponseEntity<Purchases> createPurchase(@RequestBody @Valid PurchaseRequest request) {
        Purchases created = purchaseService.createPurchase(request);
        return ResponseEntity.ok(created);
    }

    @GetMapping("/purchase")
    public ResponseEntity<List<Purchases>> getPurchase() {
        List<Purchases> purchases = purchaseService.getPurchases();
        return ResponseEntity.ok(purchases);

    }
    @GetMapping("/purchase/{id}")
    public ResponseEntity<Purchases> getPurchase(@PathVariable Long id) {
        Purchases purchase = purchaseService.getPurchase(id);
        return ResponseEntity.ok(purchase);
    }
}
