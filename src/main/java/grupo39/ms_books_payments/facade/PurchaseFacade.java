package grupo39.ms_books_payments.facade;


import grupo39.ms_books_payments.facade.model.Book;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import org.springframework.web.client.RestTemplate;

@Component
@RequiredArgsConstructor
@Slf4j
public class PurchaseFacade {

    @Value("${getBook.url}")
    private String getProductUrl;

    private final RestTemplate restTemplate;

    public Book getBook(String id) {

        String url = String.format(getProductUrl, id);
        Book elBook= restTemplate.getForObject(url, Book.class);
        if(elBook.getStock()==0){
            elBook.setTitle(elBook.getTitle()+" NO HAY STOCK :(");
        }
        return elBook;
    }
}
