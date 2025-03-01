package grupo39.ms_books_payments.data;

import grupo39.ms_books_payments.data.model.Purchases;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderJpaRepository extends JpaRepository<Purchases, Long> {
}