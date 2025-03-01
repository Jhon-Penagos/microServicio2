package grupo39.ms_books_payments.services;

import grupo39.ms_books_payments.controllers.model.PurchaseRequest;
import grupo39.ms_books_payments.data.model.Purchases;

import java.util.List;

public interface PurchaseService {

    Purchases createPurchase(PurchaseRequest purchases);

    Purchases getPurchase(Long id);

    List<Purchases> getPurchases();
}
