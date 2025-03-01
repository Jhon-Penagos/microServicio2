package grupo39.ms_books_payments.services;


import grupo39.ms_books_payments.controllers.model.PurchaseRequest;
import grupo39.ms_books_payments.data.OrderJpaRepository;
import grupo39.ms_books_payments.data.model.Purchases;
import grupo39.ms_books_payments.facade.PurchaseFacade;
import grupo39.ms_books_payments.facade.model.Book;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

@Service
@RequiredArgsConstructor
public class PurchaseServiceImp implements PurchaseService {
    private final OrderJpaRepository repository;
    private final PurchaseFacade purchaseFacade;


    @Override
    public Purchases createPurchase(PurchaseRequest purchases) {
        List<Book> purchasesList = purchases.getBooks().stream().map(purchaseFacade::getBook).filter(Objects::nonNull).toList();
        if(purchasesList.size()!=purchases.getBooks().size() || purchasesList.stream().anyMatch(book-> !book.isVisible())){
            return null;
        } else{
            Purchases purchase = Purchases.builder().books(purchasesList.stream().map(Book::getTitle).collect(Collectors.toList())).build();
            repository.save(purchase);
            return purchase;
        }

    }

    @Override
    public Purchases getPurchase(Long id) {

        return repository.findById(id).orElse(null);
    }

    @Override
    public List<Purchases> getPurchases() {
        List<Purchases> purchases = repository.findAll();
        return purchases.isEmpty() ? null : purchases;
    }
}
