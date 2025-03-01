package grupo39.ms_books_payments.facade.model;

import lombok.*;

import java.math.BigDecimal;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class Book {

    private Long id;
    private String title;
    private String author;
    private String isbn;
    private String category;
    private Double rating; // De 1 a 5
    private int stock; // Cantidad en stock
    private BigDecimal price; // Precio del libro
    private boolean visible; // Visibilidad del libro
    private Date publicationDate; // Fecha de publicación
}
