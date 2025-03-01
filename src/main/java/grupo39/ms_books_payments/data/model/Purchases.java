package grupo39.ms_books_payments.data.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "purchases")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class Purchases {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ElementCollection //para decir que en esta columna se guardara una lista en spring jpa y no como un string u objeto
    @Column(name = "books")
    private List<String> books;
}

